DELIMITER //

CREATE PROCEDURE usp_getReportsByStudent(
    IN p_dniStudent VARCHAR(8)
)
BEGIN
    SELECT
        r.*, 
        a.name AS assistant_name,
        a.surnamePaternal AS assistant_surnamePaternal,
        a.surnameMaternal AS assistant_surnameMaternal,
        a.phoneNumber AS assistant_phoneNumber
    FROM report r
    JOIN reportperson rp ON r.idReport = rp.idReport
    JOIN person p ON rp.idPerson = p.idPerson
    JOIN person a ON r.idAssistant = a.idPerson  -- Asegúrate de que idAssistant esté en la tabla report
    WHERE p.dni = p_dniStudent;
END //

DELIMITER ;



call usp_getReportsByStudent("21787088")