package com.exam.colegio.service.course;

import com.exam.colegio.dao.course.ICourseScheduledDAO;
import com.exam.colegio.dto.curso.*;
import com.exam.colegio.model.course.content.Content;
import com.exam.colegio.model.course.content.resource.Resource;
import com.exam.colegio.model.course.content.resource.activity.Activity;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.course.ICourseScheduledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                        var contents = courseScheduled.getContents();
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
                                                .recursos(content.getResources().stream()
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

        private java.util.logging.Logger logger = java.util.logging.Logger.getLogger(getClass().getName());

        @Override
        public Optional<CursoDTO> findByCodeByStudent(String code, Student student) {
                var courseScheduled = this.courseScheduledRepository.findByCode(code);
                logger.info(student.getIdPerson() + "");
                return courseScheduled.map(courseS -> {
                        var classroom = courseS.getClassroom();
                        var course = courseS.getCourse();
                        var enrollment = courseS.getEnrollment();
                        var teacherCourseScheduleds = courseS.getTeacherCourseScheduleds();
                        var contents = courseS.getContents();
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

        private List<ResourceDTO> buildResources(Content content, Student student) {
                return content.getResources().stream()
                        .map(resource -> {
                                var resourceDTO = ResourceDTO.builder()
                                        .nombre(resource.getName())
                                        .descripcion(resource.getDescription())
                                        .tipo(resource.getType())
                                        .items(buildItems(resource, student))
                                        .build();
                                if (!resource.getType().equals("data")) {
                                        resourceDTO.setNota(getNotaForStudent((Activity) resource, student));
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

        private NotaDTO getNotaForStudent(Activity activity, Student student) {
                return activity.getGradeActivity().stream()
                        .filter(gradeActivity -> gradeActivity.getPerson().getDni().equals(student.getDni()))
                        .map(gradeActivity -> NotaDTO.builder()
                                .comentario(gradeActivity.getComments())
                                .fechaCalificacion(gradeActivity.getGradedAt())
                                .nota(gradeActivity.getGradeValue())
                                .build())
                        .findFirst()
                        .orElse(null);
        }

        private final ICourseScheduledRepository courseScheduledRepository;

        @Autowired
        public CourseScheduledService(ICourseScheduledRepository courseScheduledRepository) {
                this.courseScheduledRepository = courseScheduledRepository;
        }

}
