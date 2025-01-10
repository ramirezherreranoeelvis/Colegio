package com.exam.colegio.controller.person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.colegio.dao.course.IContentDAO;
import com.exam.colegio.dao.course.ICourseScheduledDAO;
import com.exam.colegio.dao.course.IStatusAttendanceDAO;
import com.exam.colegio.dao.course.content.ISessionAttendanceDAO;
import com.exam.colegio.dao.person.IStudentDAO;
import com.exam.colegio.model.course.content.SessionContent;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TeacherController {

        @GetMapping("/session-students")
        public ResponseEntity<?> findStudentsByContent(@RequestParam Integer idContent) {
                return this.contentDAO.findStudentsByContent(idContent);
        }

        @GetMapping("/course-students")
        public ResponseEntity<?> findStudentsByCourse(@RequestParam String codeCourse) {
                var courseScheduled = this.courseScheduledDAO.findByCode(codeCourse);
                return this.courseScheduledDAO.findStudents(courseScheduled.get());
        }

        @PostMapping("/registerAttendance")
        public ResponseEntity<?> registerAttendance(@Valid @RequestBody AttendanceRequest attendanceRequest) {
                var student = this.studentDAO.findByDni(attendanceRequest.getDniStudent());
                var content = this.contentDAO.findById(attendanceRequest.getIdContent());
                var status = this.statusAttendanceDAO.findByID(attendanceRequest.getIdStatus());
                return this.sessionAttendanceDAO.registerAttendance(student.get(), (SessionContent) content.get(),
                                status.get());
        }

        @PutMapping("/registerExit")
        public ResponseEntity<?> registerExit(@Valid @RequestBody ExitRequest exitRequest) {
                var student = this.studentDAO.findByDni(exitRequest.getDniStudent());
                var content = this.contentDAO.findById(exitRequest.getIdContent());
                return this.sessionAttendanceDAO.registerExitAttendance(student.get(), (SessionContent) content.get());
        }

        private final IStatusAttendanceDAO statusAttendanceDAO;
        private final IStudentDAO studentDAO;
        private final ISessionAttendanceDAO sessionAttendanceDAO;
        private final IContentDAO contentDAO;
        private final ICourseScheduledDAO courseScheduledDAO;

        public TeacherController(IStatusAttendanceDAO statusAttendanceDAO, IStudentDAO studentDAO,
                        ISessionAttendanceDAO sessionAttendanceDAO, IContentDAO contentDAO, ICourseScheduledDAO courseScheduledDAO) {
                this.statusAttendanceDAO = statusAttendanceDAO;
                this.studentDAO = studentDAO;
                this.sessionAttendanceDAO = sessionAttendanceDAO;
                this.contentDAO = contentDAO;
                this.courseScheduledDAO = courseScheduledDAO;
        }

}

@Data
class AttendanceRequest {
        @NotNull(message = "El DNI no puede ser nulo.")
        @Size(min = 8, max = 8, message = "El DNI debe tener exactamente 8 caracteres.")
        private String dniStudent;
        @NotNull(message = "Debes tener una Sesión donde registrar Asistencia.")
        private Integer idContent;
        @NotNull(message = "Debes tener un estado de asistencia.")
        private Integer idStatus;

}

@Data
class ExitRequest {
        @NotNull(message = "El DNI no puede ser nulo.")
        @Size(min = 8, max = 8, message = "El DNI debe tener exactamente 8 caracteres.")
        private String dniStudent;
        @NotNull(message = "Debes tener una Sesión donde registrar Asistencia.")
        private Integer idContent;
}