package com.exam.colegio.model.course.content.resource;

import com.exam.colegio.model.course.content.item.GradeType;
import com.exam.colegio.model.course.content.item.StudentContentItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        @Column(name = "grade", precision = 4, scale = 2, nullable = false)
        private BigDecimal gradeValue;

        @Column(name = "comments", length = 500)
        private String comments;

        @Column(name = "gradedAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date gradedAt;

        @ManyToOne
        @JoinColumn(name = "idHomework")
        private Resource resource;

        @PrePersist
        protected void onCreate() {
                gradedAt = new Date();
        }



}
