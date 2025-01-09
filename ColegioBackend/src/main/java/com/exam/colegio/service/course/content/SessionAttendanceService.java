package com.exam.colegio.service.course.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.colegio.dao.course.content.ISessionAttendanceDAO;
import com.exam.colegio.model.course.StatusAttendance;
import com.exam.colegio.model.course.content.Content;
import com.exam.colegio.model.course.content.SessionAttendance;
import com.exam.colegio.model.course.content.SessionContent;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.course.content.ISessionAttendanceRepository;

@Service
@Transactional
public class SessionAttendanceService implements ISessionAttendanceDAO {

        @Override
        public ResponseEntity<?> registerAttendance(Student student, SessionContent session,
                        StatusAttendance statusAttendance) {
                var response = this.sessionAttendanceRepository.save(new SessionAttendance().builder()
                .student(student)
                .status(statusAttendance)
                .session(session)
                .build());
                return ResponseEntity.ok("Se registro su asistencia exitosamente");
        }

        @Autowired
        ISessionAttendanceRepository sessionAttendanceRepository;

}
