package com.exam.colegio.dao.course;

import com.exam.colegio.dto.curso.CursoDTO;
import com.exam.colegio.dto.notas.Promedios;
import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;

import java.util.List;
import java.util.Optional;
public interface ICourseScheduledDAO {

        List<CursoDTO> obtenerPorStudentYPorTemporada(Student student, Season season);

        Optional<CursoDTO> findByCode(String code);

        Optional<CursoDTO> findByCodeByStudent(String code, Student student);

        Promedios calcularPromedios(Enrollment enrollment, Student student);

}
