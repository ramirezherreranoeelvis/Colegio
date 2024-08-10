-- findCoursesByStudentAndEnrollment
DELIMITER //

CREATE PROCEDURE GetCoursesByStudentAndEnrollment(
    IN p_dniStudent VARCHAR(8),
    IN p_idEnrollment INT
)
BEGIN
    SELECT cs.*
    FROM enrollment e
    JOIN enrollmentStudent es ON e.idEnrollment = es.idEnrollment
    JOIN courseScheduled cs ON e.idEnrollment = cs.idEnrollment
    WHERE es.idStudent = (SELECT idPerson FROM person WHERE dni = p_dniStudent) 
      AND e.idEnrollment = p_idEnrollment;
END //

DELIMITER ;
-- findBySeasonAndStudent
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