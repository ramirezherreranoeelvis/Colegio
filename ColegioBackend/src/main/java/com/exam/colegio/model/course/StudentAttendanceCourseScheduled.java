package com.exam.colegio.model.course;

import com.exam.colegio.model.person.Student;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
@Entity
@Table(name = "studentAttendanceCourseScheduled")
public class StudentAttendanceCourseScheduled {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idStudentAttendanceCourseScheduled;

        @ManyToOne
        @JoinColumn(name = "idPerson", nullable = false)
        private Student student;

        @ManyToOne
        @JoinColumn(name = "idCourseScheduled", nullable = false)
        private CourseScheduled courseScheduled;

        @Column(name = "timeEntry", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date timeEntry;

        @Column(name = "timeExit")
        @Temporal(TemporalType.TIMESTAMP)
        private Date timeExit;

        @PrePersist
        protected void onCreate() {
                timeEntry = new Date();
        }

}
