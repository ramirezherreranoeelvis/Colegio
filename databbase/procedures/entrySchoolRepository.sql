-- findAllByStudent
DELIMITER //

CREATE PROCEDURE findAllByStudent(
    IN p_dniStudent VARCHAR(8)
)
BEGIN
    SELECT e.*
    FROM entryschool e
    JOIN person p on e.idPerson = p.idPerson
    WHERE p.dni = p_dniStudent AND p.typePerson = "student"; 
END //