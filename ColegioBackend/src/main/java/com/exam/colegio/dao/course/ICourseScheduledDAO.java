package com.exam.colegio.dao.course;

import com.exam.colegio.dto.CursoDTO;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;

import java.util.List;
public interface ICourseScheduledDAO {

        List<CursoDTO> obtenerPorStudentYPorTemporada(Student student, Season season);

}
