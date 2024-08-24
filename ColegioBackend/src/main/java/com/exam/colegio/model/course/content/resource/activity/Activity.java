package com.exam.colegio.model.course.content.resource.activity;

import com.exam.colegio.model.course.content.Content;
import com.exam.colegio.model.course.content.resource.GradeActivity;
import com.exam.colegio.model.course.content.resource.Resource;
import com.exam.colegio.util.Permission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("activity")
public abstract class Activity extends Resource {

        @Column(name = "dueDate")
        @Temporal(TemporalType.TIMESTAMP)
        private Date dueDate;

        @JsonIgnore
        @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
        private final List<GradeActivity> gradeActivity = new ArrayList<>();

        public Activity(int idResource, Content content, String name, String description, Permission permission, Date createdAt, Date dueDate) {
                super(idResource, content, name, description, permission, createdAt);
                this.dueDate = dueDate;
        }

        /**
         * metodo abstracto para el peso, no se define aca porque el peso varia de la especificacion
         */
        //public abstract double getWeight();
}
