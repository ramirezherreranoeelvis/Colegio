package com.exam.colegio.entity.course;

import com.exam.colegio.entity.Classroom;
import com.exam.colegio.entity.enrollment.Enrollment;
import jakarta.persistence.*;
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
        @JoinColumn(name = "idEnrollment", nullable = false)
        private Enrollment enrollment;

}
