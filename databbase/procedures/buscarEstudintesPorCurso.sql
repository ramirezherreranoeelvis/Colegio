-- MOSTRAR EL PROFESOR LOS CURSOS EN EL QUE PUEDE ENTRAR
select 
        c.*
from person p
join teacherCourseScheduled tc on p.idPerson = tc.idTeacher
JOIN coursescheduled c on tc.idCourseScheduled = c.idCourseScheduled
where dni = '99995978'

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





















