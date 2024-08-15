package com.exam.colegio.dao.course;

import com.exam.colegio.model.course.CourseScheduled;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;

import java.util.List;
public interface ICourseDAO {

        List<CourseScheduled> obtenerPorStudentYPorTemporada(Student student, Season season);

}
