-- findByStudentAndEnrollment
DELIMITER //

CREATE PROCEDURE GetEnrollmentStudentByStudentAndEnrollment(
    IN p_studentId INT,
    IN p_enrollmentId INT
)
BEGIN
    SELECT es.*
    FROM enrollmentStudent es
    WHERE es.idStudent = p_studentId AND es.idEnrollment = p_enrollmentId;
END //

DELIMITER ;
