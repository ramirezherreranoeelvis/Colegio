package com.exam.colegio.entity.course;

import com.exam.colegio.entity.other.Classroom;
import com.exam.colegio.entity.other.DayOfWeek;
import com.exam.colegio.entity.enrollment.Enrollment;
import com.exam.colegio.entity.person.Teacher;
import jakarta.persistence.*;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "courseScheduled")
public class CourseScheduled {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idCourseScheduled;

        @ManyToOne
        @JoinColumn(name = "idClassroom", nullable = false)
        private Classroom classroom;

        @ManyToOne
        @JoinColumn(name = "idCourse", nullable = false)
        private Course course;

        @ManyToOne
        @JoinColumn(name = "idTeacher", nullable = false)
        private Teacher teacher;

        @ManyToOne
        @JoinColumn(name = "idEnrollment", nullable = false)
        private Enrollment enrollment;

        @Column(name = "startTime", nullable = false)
        private LocalTime startTime;

        @Column(name = "endTime", nullable = false)
        private LocalTime endTime;

        @Enumerated(EnumType.STRING)
        @Column(name = "day", length = 10, nullable = false, columnDefinition = "VARCHAR(10)")
        private DayOfWeek dayOfWeek;

}
