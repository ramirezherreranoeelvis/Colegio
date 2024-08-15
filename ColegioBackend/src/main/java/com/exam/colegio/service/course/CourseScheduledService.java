package com.exam.colegio.service.course;

import com.exam.colegio.dao.course.ICourseScheduledDAO;
import com.exam.colegio.dto.CursoDTO;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.course.ICourseScheduledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                                                .id(courseScheduled.getIdCourseScheduled())
                                                .numberClassroom(classroom.getNumber())
                                                .floor(classroom.getFloor())
                                                .name(course.getName() + "-" + enrollment.getSeason().getYear())
                                                .startTime(courseScheduled.getStartTime())
                                                .endTime(courseScheduled.getEndTime())
                                                .day(courseScheduled.getDayOfWeek().getDisplayName())
                                                .profesores(courseScheduled.getTeacherCourseScheduled()
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

        private final ICourseScheduledRepository courseScheduledRepository;

        @Autowired
        public CourseScheduledService(ICourseScheduledRepository courseScheduledRepository) {
                this.courseScheduledRepository = courseScheduledRepository;
        }

}
