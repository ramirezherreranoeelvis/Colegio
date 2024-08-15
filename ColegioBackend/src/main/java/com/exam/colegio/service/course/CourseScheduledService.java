package com.exam.colegio.service.course;

import com.exam.colegio.dao.course.ICourseDAO;
import com.exam.colegio.model.course.CourseScheduled;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.course.ICourseRepository;
import com.exam.colegio.repository.course.ICourseScheduledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseDAO {

        @Override
        public List<CourseScheduled> obtenerPorStudentYPorTemporada(Student student, Season season) {
                return this.courseScheduledRepository.obtenerPorStudentYPorTemporada(student.getDni(), season.getYear());
        }

        private final ICourseScheduledRepository courseScheduledRepository;

        @Autowired
        public CourseService(ICourseScheduledRepository courseScheduledRepository) {
                this.courseScheduledRepository = courseScheduledRepository;
        }

}
