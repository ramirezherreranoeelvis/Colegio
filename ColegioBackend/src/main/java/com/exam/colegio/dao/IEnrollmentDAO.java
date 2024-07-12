package com.exam.colegio.dao;

import com.exam.colegio.dto.CourseHorarioDTO;

import java.util.List;
public interface IEnrollmentDAO {

        List<CourseHorarioDTO> findAllCoursesByStudentAndEnrollment(Integer dniStudent, Integer idEnrollment);

}
