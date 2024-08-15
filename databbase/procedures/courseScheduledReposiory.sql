DELIMITER //

CREATE PROCEDURE usp_findCoursesByDniStudentByYear(
	IN p_dniStudent VARCHAR(8),
    IN p_year VARCHAR(4)
)
BEGIN
	SELECT
	ce.*
	FROM coursescheduled ce
	JOIN enrollment e ON ce.idEnrollment = e.idEnrollment
	JOIN season s ON e.idSeason = s.idSeason
	JOIN enrollmentstudent es ON e.idEnrollment = es.idEnrollment
	JOIN person p ON es.idStudent = p.idPerson
	WHERE p.dni = p_dniStudent AND s.year = p_year;
END//

DELIMITER ;