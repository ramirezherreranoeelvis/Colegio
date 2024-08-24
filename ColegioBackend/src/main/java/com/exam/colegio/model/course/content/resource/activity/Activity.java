package com.exam.colegio.model.course.content.resource;

import com.exam.colegio.model.course.content.Content;
import com.exam.colegio.util.Permission;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class Activity extends Resource {

        @Column(name = "dueDate")
        @Temporal(TemporalType.TIMESTAMP)
        private Date dueDate;

        public Activity(int idResource, Content content, String name, String description, Permission permission, Date createdAt, Date dueDate) {
                super(idResource, content, name, description, permission, createdAt);
                this.dueDate = dueDate;
        }

        public Activity() {}
}
