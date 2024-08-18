package com.exam.colegio.model.course.content;

import com.exam.colegio.model.course.Session;
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

        @Column(name = "createtAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createtAt;

        @Builder
        public Forum(int idResource, Session session, String name, String description, Permission permission, Date createtAt, Date createtAt1) {
                super(idResource, session, name, description, permission, createtAt);
                this.createtAt = createtAt1;
        }

}
