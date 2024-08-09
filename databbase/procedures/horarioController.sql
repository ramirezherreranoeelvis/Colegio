DELIMITER //
CREATE PROCEDURE GetEnrollmentBySeasonAndStudent(
    IN p_idSeason INT,
    IN p_idStudent INT
)
BEGIN
    SELECT e.*
    FROM enrollment e
    JOIN enrollmentStudent es ON e.idEnrollment = es.idEnrollment
    WHERE e.idSeason = p_idSeason AND es.idStudent = p_idStudent;
END //
DELIMITER ;