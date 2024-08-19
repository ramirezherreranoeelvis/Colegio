package com.exam.colegio.model.course.content.resource;

import com.exam.colegio.model.course.content.Content;
import com.exam.colegio.model.course.content.Session;
import com.exam.colegio.util.Permission;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("forum")
public class Forum extends Resource {

        @Column(name = "dueDate")
        @Temporal(TemporalType.TIMESTAMP)
        private Date dueDate;

        @Builder
        public Forum(int idResource, Content content, String name, String description, Permission permission, Date createdAt, Date dueDate) {
                super(idResource, content, name, description, permission, createdAt);
                this.dueDate = dueDate;
        }

}
