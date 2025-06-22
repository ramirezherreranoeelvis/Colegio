-- teacher
INSERT INTO access
        (access, description, password, username)
VALUES
        (1, "", "10002000", "LBarbozaRa"),
        (1, "", "10002000", "FCoriCu"),
        (1, "", "10002000", "JDoeSm"),
        (1, "", "10002000", "JDoeSm2"),
        (1, "", "10002000", "JDoeSm3"),
        (1, "", "10002000", "AGreenJo"),
        (1, "", "10002000", "BBrownMi"),
        (1, "", "10002000", "CWhiteDa"),
        (1, "", "10002000", "DBlackGa"),
        (1, "", "10002000", "EGrayMa"),
        (1, "", "10002000", "FBlueHe"),
        (1, "", "10002000", "GBlueLo"),
        (1, "", "10002000", "HYelowGo"),
        (1, "", "10002000", "IPurpleWi"),
        (1, "", "10002000", "JOrangeAn");
        
INSERT INTO person
        (dni, name, surnamePaternal, surnameMaternal, phoneNumber, idAccess, typePerson)
VALUES
        ('99995978', 'Luis', 'Barboza', 'Ramirez', '+51 199 999 999', 1, 'teacher'),
        ('19345678', 'Fernando', 'Cori', 'Curi', '+51 119 345 678', 2, 'teacher'),
        ('12345698', 'John', 'Doe', 'Smith', '+51 112 345 698', 3, 'teacher'),
        ('12395678', 'John', 'Doe', 'Smith', '+51 112 395 678', 4, 'teacher'),
        ('87654321', 'Jane', 'Doe', 'Smith', '+51 187 654 321', 5, 'teacher'),
        ('12345679', 'Alice', 'Green', 'Johnson', '+51 112 345 679', 6, 'teacher'),
        ('22345678', 'Bob', 'Brown', 'Miller', '+51 122 345 678', 7, 'teacher'),
        ('32345678', 'Charlie', 'White', 'Davis', '+51 132 345 678', 8, 'teacher'),
        ('42345678', 'David', 'Black', 'Garcia', '+51 142 345 678', 9, 'teacher'),
        ('52345678', 'Eve', 'Gray', 'Martinez', '+51 152 345 678', 10, 'teacher'),
        ('62345678', 'Frank', 'Blue', 'Hernandez', '+51 162 345 678', 11, 'teacher'),
        ('72345678', 'Grace', 'Yellow', 'Lopez', '+51 172 345 678', 12, 'teacher'),
        ('82345678', 'Hank', 'Red', 'Gonzalez', '+51 182 345 678', 13, 'teacher'),
        ('92345678', 'Ivy', 'Purple', 'Wilson', '+51 192 345 678', 14, 'teacher'),
        ('10234567', 'Jack', 'Orange', 'Anderson', '+51 110 235 678', 15, 'teacher');

-- papa
INSERT INTO access
        (access, description, password, username)
VALUES
        (1, "", "10002000", "AMamaniDi"),
        (1, "", "10002000", "FAlanyaDo"),
        (1, "", "10002000", "AGarciaAp"),
        (1, "", "10002000", "AHerreraMe"),
        (1, "", "10002000", "ARamirezCha");
INSERT INTO person
        (dni, name, surnamePaternal, surnameMaternal, phoneNumber, idAccess, typePerson)
VALUES
        ('99233923', 'Alvaro', 'Mamani', 'Diaz', '+51 149 255 878', 16, 'father'),
        ('95305354', 'Fernandez', 'Alanya', 'Dominguez', '+51 179 832 738', 17, 'father'),
        ('92135308', 'Alejandro', 'Garcia', 'Aparco', '+51 126 100 862', 18, 'father'),
        ('13765172', 'Alex', 'Herrera', 'Medina', '+51 158 739 411', 19, 'father'),
        ('65504696', 'Anibal', 'Ramirez', 'Chavez', '+51 123 881 724', 20, 'father');

-- mama
INSERT INTO access
        (access, description, password, username)
VALUES
        (1, "", "10002000", "CSalvatierraTo"),
        (1, "", "10002000", "DCoronelJu"),
        (1, "", "10002000", "IPeraltaCa"),
        (1, "", "10002000", "RParedesFa"),
        (1, "", "10002000", "SManriqueSa");
INSERT INTO person
        (dni, name, surnamePaternal, surnameMaternal, phoneNumber, idAccess, typePerson)
VALUES
        ('82439576', 'Carmen', 'Salvatierra', 'Tomapasca', '+51 198 690 363', 21, 'mother'),
        ('37793163', 'Dayana', 'Coronel', 'Julca', '+51 168 218 983', 22, 'mother'),
        ('61325132', 'Isabel', 'Peralta', 'Calla', '+51 152 172 528', 23, 'mother'),
        ('51800719', 'Rosario', 'Paredes', 'Falla', '+51 116 684 261', 24, 'mother'),
        ('30577936', 'Sayuri', 'Manrique', 'Sanchez', '+51 125 923 306', 25, 'mother');

-- estudiante
INSERT INTO access
        (access, description, password, username)
VALUES
        (1, "", "10002000", "AMamaniCo"),
        (1, "", "10002000", "JGarciaPe"),
        (1, "", "10002000", "AGarciaPe1"),
        (1, "", "10002000", "LRamirezSa"),
        (1, "", "10002000", "AAlanyaMa"),
        (1, "", "10002000", "GRamirezSa"),
        (1, "", "10002000", "AGarciaPe2"),
        (1, "", "10002000", "JMamaniCo"),
        (1, "", "10002000", "JHerreraPa"),
        (1, "", "10002000", "NAlanyaMa");
INSERT INTO person
        (dni, name, surnamePaternal, surnameMaternal, phoneNumber, idAccess, idFather, idMother, idGrade, typePerson)
VALUES
        ('21787088', 'Ariana', 'Mamani', 'Coronel', '+51 185 334 752', 26, 16, 22, 7, 'student'),
        ('16002131', 'Juan', 'Garcia', 'Peralta', '+51 110 428 708', 27, 18, 23, 7, 'student'),
        ('42088728', 'Andres', 'Garcia', 'Peralta', '+51 133 928 804', 28, 18, 23, 8, 'student'),
        ('17464282', 'Luis', 'Ramirez', 'Salvatierra', '+51 169 617 791', 29, 20, 21, 8, 'student'),
        ('59273086', 'Alfonso', 'Alanya', 'Manrique', '+51 100 950 992', 30, 17, 25, 7, 'student'),
        ('65206787', 'Gonzalo', 'Ramirez', 'Salvatierra', '+51 135 854 938', 31, 20, 21, 8, 'student'),
        ('70994344', 'Andrea', 'Garcia', 'Peralta', '+51 112 406 888', 32, 18, 23, 7, 'student'),
        ('87797322', 'Julio', 'Mamani', 'Coronel', '+51 198 556 661', 33, 16, 22, 8, 'student'),
        ('52559487', 'Jorge', 'Herrera', 'Paredes', '+51 162 822 719', 34, 19, 24, 8, 'student'),
        ('12768531', 'Nicol', 'Alanya', 'Manrique', '+51 169 617 791', 35, 17, 25, 7, 'student');

-- Tabla: course
INSERT INTO course
        (name)
VALUES
        ('logico matemático'),
        ('química'),
        ('aritmética'),
        ('geometría'),
        ('álgebra'),
        ('razonamiento matemático'),
        ('razonamiento verbal'),
        ('literatura'),
        ('comprensión lectora'),
        ('religión'),
        ('física'),
        ('historia universal'),
        ('cómputo'),
        ('ingles'),
        ('biología'),
        ('comunicación integral'),
        ('economía'),
        ('educación física'),
        ('geografía'),
        ('lenguaje'),
        ('castellano'),
        ('ortografía'),
        ('cívica'),
        ('historia del perú'),
        ('personal social'),
        ('logico verbal'),
        ('psicología'),
        ('fechas cívicas');
-- Tabla: grade
INSERT INTO grade
        (name, idNextGrade, idPreviousGrade)
VALUES
		('1° primaria', 2, NULL),
		('2° primaria', 3, 1),
		('3° primaria', 4, 2),
		('4° primaria', 5, 3),
		('5° primaria', 6, 4),
		('6° primaria', 7, 5),
		('1° secundaria', 8, 6),
		('2° secundaria', 9, 7),
		('3° secundaria', 10, 8),
		('4° secundaria', 11, 9),
		('5° secundaria', NULL, 10);
-- Tabla: season
INSERT INTO season
        (year, startDate)
VALUES
        (2025, '2024-04-04'),
        (2026, NULL),
        (2027, NULL),
        (2028, NULL),
        (2029, NULL),
        (2030, NULL);

-- Tabla: classroom
INSERT INTO classroom
        (floor, number)
VALUES
        (1, 101),
        (1, 102),
        (1, 103),
        (2, 201),
        (2, 202),
        (2, 203),
        (2, 204),
        (3, 301),
        (3, 302),
        (3, 303),
        (3, 304),
        (3, 305);
-- Tabla: typestatus
INSERT INTO typestatus
        (name)
VALUES
        ('anulado'),
        ('cancelado'),
        ('pendiente');

INSERT INTO enrollment
  (cost, enrolled, monthlyFee, months, periodType, vacancies, idGrade, idSeason)
VALUES
  (150.00, 0, 150.00, 12, 'TRIMESTRE', 40, 1, 1),
  (150.00, 0, 150.00, 12, 'TRIMESTRE', 40, 2, 1),
  (150.00, 0, 150.00, 12, 'TRIMESTRE', 40, 3, 1),
  (150.00, 0, 150.00, 12, 'TRIMESTRE', 40, 4, 1),
  (150.00, 0, 150.00, 12, 'TRIMESTRE', 40, 5, 1),
  (150.00, 0, 150.00, 12, 'TRIMESTRE', 40, 6, 1),
  (250.00, 0, 250.00, 12, 'TRIMESTRE', 40, 7, 1),
  (250.00, 0, 250.00, 12, 'TRIMESTRE', 40, 8, 1),
  (250.00, 0, 250.00, 12, 'TRIMESTRE', 40, 9, 1),
  (250.00, 0, 250.00, 12, 'TRIMESTRE', 40, 10, 1),
  (250.00, 0, 250.00, 12, 'TRIMESTRE', 40, 11, 1);


SELECT * FROM colegio.content;


INSERT INTO coursescheduled
  (code, day, endTime, portada, startTime, idClassroom, idCourse, idEnrollment)
VALUES
  ('803566083', 'LUNES', '08:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature1_thumb.jpg', '08:00:00', 1, 1, 7),
  ('803566084', 'LUNES', '09:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature2_thumb.jpg', '08:45:00', 2, 2, 7),
  ('803566085', 'LUNES', '10:15:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature3_thumb.jpg', '09:30:00', 3, 3, 7),
  ('803566086', 'LUNES', '11:00:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature4_thumb.jpg', '10:15:00', 4, 4, 7),
  ('803566087', 'LUNES', '11:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature5_thumb.jpg', '11:00:00', 5, 5, 7),
  ('803566088', 'LUNES', '12:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature6_thumb.jpg', '11:45:00', 6, 6, 7),
  ('803566089', 'MARTES', '08:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature7_thumb.jpg', '08:00:00', 7, 7, 7),
  ('803566090', 'MARTES', '09:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature8_thumb.jpg', '08:45:00', 8, 8, 7),
  ('803566091', 'MARTES', '10:15:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature9_thumb.jpg', '09:30:00', 9, 9, 7),
  ('803566092', 'MARTES', '11:00:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature10_thumb.jpg', '10:15:00', 10, 10, 7),
  ('803566093', 'MARTES', '11:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature11_thumb.jpg', '11:00:00', 1, 11, 8),
  ('803566094', 'MARTES', '12:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature12_thumb.jpg', '11:45:00', 2, 12, 8),
  ('803566095', 'MIÉRCOLES', '08:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature13_thumb.jpg', '08:00:00', 3, 13, 8),
  ('803566096', 'MIÉRCOLES', '09:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature14_thumb.jpg', '08:45:00', 4, 14, 8),
  ('803566097', 'MIÉRCOLES', '10:15:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature15_thumb.jpg', '09:30:00', 5, 15, 8),
  ('803566098', 'MIÉRCOLES', '11:00:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature16_thumb.jpg', '10:15:00', 6, 16, 8),
  ('803566099', 'MIÉRCOLES', '11:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature17_thumb.jpg', '11:00:00', 7, 17, 8),
  ('803566100', 'MIÉRCOLES', '12:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature18_thumb.jpg', '11:45:00', 8, 18, 8),
  ('803566101', 'JUEVES', '08:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature19_thumb.jpg', '08:00:00', 9, 19, 8),
  ('803566102', 'JUEVES', '09:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature20_thumb.jpg', '08:45:00', 10, 20, 8),
  ('803566103', 'JUEVES', '10:15:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature1_thumb.jpg', '09:30:00', 1, 21, 8),
  ('803566104', 'JUEVES', '11:00:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature2_thumb.jpg', '10:15:00', 2, 22, 8),
  ('803566105', 'JUEVES', '11:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature3_thumb.jpg', '11:00:00', 3, 23, 8),
  ('803566106', 'JUEVES', '12:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature4_thumb.jpg', '11:45:00', 4, 24, 8),
  ('803566107', 'VIERNES', '08:45:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature5_thumb.jpg', '08:00:00', 5, 25, 8),
  ('803566108', 'VIERNES', '09:30:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature6_thumb.jpg', '08:45:00', 6, 26, 8),
  ('803566109', 'VIERNES', '10:15:00', 'https://ultra.content.blackboardcdn.com/ultra/static/images/default-banners/nature7_thumb.jpg', '09:30:00', 7, 27, 8);

INSERT INTO content (`typeContent`, `isVisible`, `name`, `number`, `idCourseScheduled`) VALUES 
('session', 1, 'Historia de la Quimica', '1', '1'),
('session', 1, 'Hexenos', '2', '1'),
('session', 1, 'Pentenos', '3', '1'),
('session', 1, 'Fusiones y Mezclas', '4', '1'),
('session', 1, 'Fusiones y Mezclas II', '5', '1'),
('session', 1, 'Propiedades Generales de la Materia', '6', '1'),
('session', 1, 'Estados y Cambios de Estado de la Materia', '7', '1'),
('session', 1, 'Fenómenos Físicos y Químicos de la Materia', '8', '1'),
('session', 1, 'Sustancias Simples y Compuestas', '9', '1'),
('session', 1, 'Mezclas Homogéneas y Heterogéneas', '10', '1'),
('session', 1, 'Historia del Átomo', '11', '1'),
('session', 1, 'Número Atómico y Número de Masa', '12', '1'),
('session', 1, 'Anión y Catión', '13', '1'),
('session', 1, 'Niveles, Subniveles y Orbitales', '14', '1'),
('session', 1, 'Historia de la Tabla Periódica', '15', '1'),
('session', 1, 'Estructura de la Tabla Periódica Actual', '16', '1'),
('session', 1, 'Ubicación de un Elemento en la TPA', '17', '1'),
('session', 1, 'Número de Oxidación', '18', '1'),
('session', 1, 'Óxidos Básicos o Metálicos', '19', '1'),
('session', 1, 'Óxidos Ácidos o Anhídridos', '20', '1');
















