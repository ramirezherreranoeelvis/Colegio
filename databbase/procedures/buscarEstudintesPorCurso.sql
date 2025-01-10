-- findBySeasonAndStudent
DELIMITER //
CREATE PROCEDURE usp_findStudentsByContent(
    IN p_idContent INT
)
BEGIN
	SELECT 
		p.*
	FROM content cnt
	JOIN coursescheduled c ON cnt.idCourseScheduled = c.idCourseScheduled
	JOIN enrollment e ON c.idEnrollment = e.idEnrollment
	JOIN enrollmentstudent es ON e.idEnrollment = es.idEnrollment
	JOIN person p ON es.idStudent = p.idPerson
	WHERE cnt.idContent = p_idContent AND cnt.typeContent = 'session';
END //
DELIMITER ;

-- mostrar alumnos de un curso en especifico
DELIMITER //
CREATE PROCEDURE usp_findStudentsByCourse(
    IN p_codeCourse INT
)
BEGIN
	SELECT 
        p.*
	FROM coursescheduled c
	JOIN enrollment e ON c.idEnrollment = e.idEnrollment
	JOIN enrollmentstudent es ON e.idEnrollment = es.idEnrollment
	JOIN person p ON es.idStudent = p.idPerson
	WHERE c.code = p_codeCourse;
END //
DELIMITER ;

-- cursos al que un profesor tiene acceso por temporada
DELIMITER //
CREATE PROCEDURE usp_findCourseBySeason(
    IN p_year VARCHAR(4),
    IN p_dni VARCHAR(8)
)
BEGIN
	SELECT cs.*
	FROM coursescheduled cs
	JOIN enrollment e ON cs.idEnrollment = e.idEnrollment
	JOIN season s ON e.idSeason = s.idSeason
	JOIN teachercoursescheduled tcs ON cs.idCourseScheduled = tcs.idCourseScheduled
	JOIN person p ON tcs.idTeacher = p.idPerson
	WHERE s.year = p_year AND p.dni = p_dni;
END //
DELIMITER ;



















