DELIMITER //
CREATE PROCEDURE usp_findByStudent(
	IN p_dniStudent VARCHAR(8)
)
BEGIN
	SELECT
		s.*
	FROM season s
	JOIN enrollment e ON s.idSeason = e.idSeason
	JOIN enrollmentstudent es ON e.idEnrollment = es.idEnrollment
	JOIN person p ON es.idStudent = p.idPerson
	WHERE p.dni = p_dniStudent;
END //
DELIMITER ;