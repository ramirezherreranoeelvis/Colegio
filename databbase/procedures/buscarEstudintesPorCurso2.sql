select 
        tc.salary
from person p
join teacherCourseScheduled tc on p.idPerson = tc.idTeacher
where dni = '99995978'