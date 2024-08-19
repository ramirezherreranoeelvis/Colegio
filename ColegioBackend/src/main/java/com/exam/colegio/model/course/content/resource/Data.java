package com.exam.colegio.model.course.session.resource;

import com.exam.colegio.model.course.session.Session;
import com.exam.colegio.util.Permission;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("data")
public class Data extends Resource {

        @Builder
        public Data(int idResource, Session session, String name, String description, Permission permission, Date createtAt) {
                super(idResource, session, name, description, permission, createtAt);
        }



}
