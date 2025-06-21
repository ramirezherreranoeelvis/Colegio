-- findCoursesByStudentAndEnrollment
DELIMITER //

CREATE PROCEDURE findStudentsBySesion(
    IN p_idContent INT
)
BEGIN
        SELECT 
                *
        FROM content cnt
        JOIN coursescheduled c ON cnt.idCourseScheduled = c.idCourseScheduled
        JOIN enrollment e ON c.idEnrollment = e.idEnrollment
        JOIN enrollmentstudent es ON e.idEnrollment = es.idEnrollment
        JOIN person p ON es.idStudent = p.idPerson
        WHERE cnt.idContent = p_idContent AND cnt.typeContent = 'session';
END //

DELIMITER ;