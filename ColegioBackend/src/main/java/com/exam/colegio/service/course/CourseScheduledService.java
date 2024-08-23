package com.exam.colegio.service.course;

import com.exam.colegio.dao.course.ICourseScheduledDAO;
import com.exam.colegio.dto.curso.ContentDTO;
import com.exam.colegio.dto.curso.CursoDTO;
import com.exam.colegio.dto.curso.ItemDTO;
import com.exam.colegio.dto.curso.ResourceDTO;
import com.exam.colegio.model.course.content.Content;
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

        private final ICourseScheduledRepository courseScheduledRepository;

        @Autowired
        public CourseScheduledService(ICourseScheduledRepository courseScheduledRepository) {
                this.courseScheduledRepository = courseScheduledRepository;
        }

}
