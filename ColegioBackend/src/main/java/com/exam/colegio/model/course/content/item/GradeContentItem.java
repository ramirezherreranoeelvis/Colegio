package com.exam.colegio.model.course.content.item;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Builder
@Entity
@Table(name = "gradeContentItem")
public class GradeContentItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idGradeContentItem;

        @ManyToOne
        @JoinColumn(name = "idGradeType", nullable = false)
        private GradeType gradeType;

        @OneToOne
        @JoinColumn(name = "idStudentContentItem", nullable = false)
        private StudentContentItem studentContentItem;

        @Column(name = "grade", precision = 4, scale = 2, nullable = false)
        private BigDecimal gradeValue;

        @Column(name = "comments", length = 500)
        private String comments;

        @Column(name = "gradedAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date gradedAt;

        @PrePersist
        protected void onCreate() {
                gradedAt = new Date();
        }
}
