package com.exam.colegio.service.course;

import com.exam.colegio.dao.course.ICourseScheduledDAO;
import com.exam.colegio.dto.curso.*;
import com.exam.colegio.dto.notas.Promedio;
import com.exam.colegio.dto.notas.Promedios;
import com.exam.colegio.model.course.CourseScheduled;
import com.exam.colegio.model.course.content.Content;
import com.exam.colegio.model.course.content.resource.Resource;
import com.exam.colegio.model.course.content.resource.activity.Activity;
import com.exam.colegio.model.course.content.resource.activity.Forum;
import com.exam.colegio.model.course.content.resource.activity.Homework;
import com.exam.colegio.model.course.content.resource.activity.exam.DailyExam;
import com.exam.colegio.model.course.content.resource.activity.exam.MonthlyExam;
import com.exam.colegio.model.course.content.resource.activity.exam.WeeklyExam;
import com.exam.colegio.model.course.content.resource.activity.exam.examfinal.ExamFinal;
import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.enrollment.EnrollmentPeriod;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.course.ICourseScheduledRepository;
import com.exam.colegio.repository.enrollment.IEnrollmentRepository;
import com.exam.colegio.service.course.content.resource.GradeActivityService;
import com.exam.colegio.service.course.content.resource.activity.ActivityService;
import com.exam.colegio.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseScheduledService implements ICourseScheduledDAO {

        @Override
        public List<CursoDTO> obtenerPorStudentYPorTemporada(Student student, Season season) {
                return this.courseScheduledRepository.obtenerPorStudentYPorTemporada(student.getDni(), season.getYear())
                        .stream()
                        .map(courseScheduled -> {
                                        var classroom = courseScheduled.getClassroom();
                                        var course = courseScheduled.getCourse();
                                        var enrollment = courseScheduled.getEnrollment();
                                        return CursoDTO.builder()
                                                .codigo(courseScheduled.getCode())
                                                .numeroSalon(classroom.getNumber())
                                                .piso(classroom.getFloor())
                                                .nombre(course.getName() + "-" + enrollment.getSeason().getYear())
                                                .horaInicio(courseScheduled.getStartTime())
                                                .horaFin(courseScheduled.getEndTime())
                                                .dia(courseScheduled.getDayOfWeek().getDisplayName())
                                                .profesores(courseScheduled.getTeacherCourseScheduleds()
                                                        .stream()
                                                        .map(teacherCourseScheduled -> {
                                                                        var teacher = teacherCourseScheduled.getTeacher();
                                                                        return teacher.getName() + " " + teacher.getSurnamePaternal() + " " + teacher.getSurnameMaternal();
                                                                }
                                                        ).toList()
                                                )
                                                .portada(courseScheduled.getPortada())
                                                .build();
                                }
                        ).toList();
        }

        @Override
        public Optional<CursoDTO> findByCode(String code) {
                return this.courseScheduledRepository.findByCode(code).map(courseScheduled -> {
                        var classroom = courseScheduled.getClassroom();
                        var course = courseScheduled.getCourse();
                        var enrollment = courseScheduled.getEnrollment();
                        var teacherCourseScheduleds = courseScheduled.getTeacherCourseScheduleds();
                        var contents = courseScheduled.getContentList();
                        return CursoDTO.builder()
                                .codigo(courseScheduled.getCode())
                                .nombre(course.getName() + "-" + enrollment.getSeason().getYear())
                                .numeroSalon(classroom.getNumber())
                                .piso(classroom.getFloor())
                                .horaInicio(courseScheduled.getStartTime())
                                .horaFin(courseScheduled.getEndTime())
                                .dia(courseScheduled.getDayOfWeek().getDisplayName())
                                .profesores(teacherCourseScheduleds.stream()
                                        .map(teacherCourseScheduled -> {
                                                        var teacher = teacherCourseScheduled.getTeacher();
                                                        return teacher.getName() + " " + teacher.getSurnamePaternal() + " " + teacher.getSurnameMaternal();
                                                }
                                        ).toList()
                                )
                                .portada(courseScheduled.getPortada())
                                .numeroSesiones((int) contents.stream()
                                        .filter(content -> content.getType().equals("session"))
                                        .count()
                                )
                                .contenidos(contents.stream()
                                        .filter(Content::isVisible)
                                        .map(content -> ContentDTO.builder()
                                                .nombre(content.getName())
                                                .numero(content.getNumber())
                                                .tipo(content.getType())
                                                .recursos(content.getResourceList().stream()
                                                        .map(resource -> ResourceDTO.builder()
                                                                .nombre(resource.getName())
                                                                .descripcion(resource.getDescription())
                                                                .tipo(resource.getType())
                                                                .items(resource.getContentItems().stream()
                                                                        .map(item -> ItemDTO.builder()
                                                                                .dniPerson(item.getPerson().getDni())
                                                                                .tipo(item.getType())
                                                                                .contenido(item.getContent())
                                                                                .nombreArchivo(item.getName())
                                                                                .build()
                                                                        ).toList()
                                                                ).build()
                                                        ).toList()
                                                ).build()
                                        ).toList()
                                ).build();
                });
        }

        @Override
        public Promedios calcularPromedios(Enrollment enrollment, Student student) {
                // datos
                List<EnrollmentPeriod> enrollmentPeriods = enrollment.getEnrollmentPeriods();
                List<CourseScheduled> cursosProgramados = enrollment.getCourseScheduleds();
                List<Promedio> promedioList = cursosProgramados.stream()
                        .map(courseScheduled -> {
                                        List<Integer> promediosCursos = new ArrayList<>();
                                        enrollmentPeriods.forEach(enrollmentPeriod -> {
                                                if (enrollmentPeriod.isVisibilityDate()) {
                                                        var period = enrollmentPeriod.getPeriod();
                                                        //tareas dentro de rango de un periodo
                                                        List<Homework> homeworkList = activityService.getActivitiesByTypeAndDateRange(courseScheduled, Homework.class, period.getStartDate(), period.getEndtDate());
                                                        List<Forum> forumList = activityService.getActivitiesByTypeAndDateRange(courseScheduled, Forum.class, period.getStartDate(), period.getEndtDate());
                                                        List<DailyExam> dailyExamList = activityService.getActivitiesByTypeAndDateRange(courseScheduled, DailyExam.class, period.getStartDate(), period.getEndtDate());
                                                        List<WeeklyExam> weeklyExamList = activityService.getActivitiesByTypeAndDateRange(courseScheduled, WeeklyExam.class, period.getStartDate(), period.getEndtDate());
                                                        List<MonthlyExam> monthlyExamList = activityService.getActivitiesByTypeAndDateRange(courseScheduled, MonthlyExam.class, period.getStartDate(), period.getEndtDate());
                                                        List<ExamFinal> examFinalList = activityService.getActivitiesByTypeAndDateRange(courseScheduled, ExamFinal.class, period.getStartDate(), period.getEndtDate());
                                                        promediosCursos.add(gradeActivityService.promedioGeneral(
                                                                homeworkList,
                                                                forumList,
                                                                dailyExamList,
                                                                weeklyExamList,
                                                                monthlyExamList,
                                                                examFinalList,
                                                                student.getIdPerson(),
                                                                enrollment.getTypePeriod().getDisplayName()
                                                        ));
                                                } else {
                                                        promediosCursos.add(null);
                                                }
                                        });
                                        return Promedio.builder()
                                                .nombre(courseScheduled.getCourse().getName())
                                                .codigo(courseScheduled.getCode())
                                                .promedios(promediosCursos)
                                                .build();
                                }
                        ).toList();
                List<String> periods = new ArrayList<>();
                for (int i = 0; i < enrollmentPeriods.size(); i++) {
                        periods.add(enrollmentPeriods.get(i).getEnrollment().getTypePeriod().getDisplayName() +" "+ (i + 1));
                }
                return Promedios.builder()
                        .periodos(periods)
                        .promedioList(promedioList)
                        .build();
        }

        @Override
        public Optional<CursoDTO> findByCodeByStudent(String code, Student student) {
                var courseScheduled = this.courseScheduledRepository.findByCode(code);
                return courseScheduled.map(courseS -> {
                        var classroom = courseS.getClassroom();
                        var course = courseS.getCourse();
                        var enrollment = courseS.getEnrollment();
                        var teacherCourseScheduleds = courseS.getTeacherCourseScheduleds();
                        var contents = courseS.getContentList();
                        return CursoDTO.builder()
                                .codigo(courseS.getCode())
                                .nombre(course.getName() + "-" + enrollment.getSeason().getYear())
                                .numeroSalon(classroom.getNumber())
                                .piso(classroom.getFloor())
                                .horaInicio(courseS.getStartTime())
                                .horaFin(courseS.getEndTime())
                                .dia(courseS.getDayOfWeek().getDisplayName())
                                .profesores(teacherCourseScheduleds.stream()
                                        .map(teacherCourseScheduled -> {
                                                        var teacher = teacherCourseScheduled.getTeacher();
                                                        return teacher.getName() + " " + teacher.getSurnamePaternal() + " " + teacher.getSurnameMaternal();
                                                }
                                        ).toList()
                                )
                                .portada(courseS.getPortada())
                                .numeroSesiones((int) contents.stream()
                                        .filter(content -> content.getType().equals("session"))
                                        .count()
                                )
                                .contenidos(contents.stream()
                                        .filter(Content::isVisible)
                                        .map(content -> ContentDTO.builder()
                                                .nombre(content.getName())
                                                .numero(content.getNumber())
                                                .tipo(content.getType())
                                                .recursos(buildResources(content, student)
                                                ).build()
                                        ).toList()
                                ).build();
                });
        }

        private final ICourseScheduledRepository courseScheduledRepository;
        private final IEnrollmentRepository enrollmentRepository;
        private final ActivityService activityService;
        private final GradeActivityService gradeActivityService;

        @Autowired
        public CourseScheduledService(ICourseScheduledRepository courseScheduledRepository, IEnrollmentRepository enrollmentRepository, ActivityService activityService, GradeActivityService gradeActivity) {
                this.courseScheduledRepository = courseScheduledRepository;
                this.enrollmentRepository = enrollmentRepository;
                this.activityService = activityService;
                this.gradeActivityService = gradeActivity;
        }

        private List<ResourceDTO> buildResources(Content content, Student student) {
                return content.getResourceList().stream()
                        .map(resource -> {
                                var resourceDTO = ResourceDTO.builder()
                                        .nombre(resource.getName())
                                        .descripcion(resource.getDescription())
                                        .tipo(resource.getType())
                                        .items(buildItems(resource, student))
                                        .build();
                                if (!resource.getType().equals("data")) {
                                        resourceDTO.setNotas(getNotaForStudent((Activity) resource, student));
                                }
                                return resourceDTO;
                        })
                        .toList();
        }

        private List<ItemDTO> buildItems(Resource resource, Student student) {
                return resource.getContentItems().stream()
                        .filter(contentItem -> contentItem.getType().equals("teacherContent")
                                               || (contentItem.getType().equals("studentContent") && contentItem.getPerson().getDni().equals(student.getDni())))
                        .map(item -> ItemDTO.builder()
                                .dniPerson(item.getPerson().getDni())
                                .tipo(item.getType())
                                .contenido(item.getContent())
                                .nombreArchivo(item.getName())
                                .build())
                        .toList();
        }

        private List<NotaDTO> getNotaForStudent(Activity activity, Student student) {
                return activity.getGradeActivity().stream()
                        .filter(gradeActivity -> gradeActivity.getPerson().getDni().equals(student.getDni()))
                        .map(gradeActivity -> NotaDTO.builder()
                                .comentario(gradeActivity.getComments())
                                .fechaCalificacion(DateFormatUtil.ymd(gradeActivity.getGradedAt()))
                                .nota(gradeActivity.getGradeValue())
                                .build())
                        .collect(Collectors.toList());
        }

}
