package com.exam.colegio.model.course;

import com.exam.colegio.model.course.content.Resource;
import com.exam.colegio.model.person.Person;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "contentItem")
public class ContentItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idContentItem;

        @ManyToOne
        @JoinColumn(name = "idPerson", nullable = false)
        private Person person;

        @ManyToOne
        @JoinColumn(name = "idResource", nullable = false)
        private Resource resource;

        @Column(name = "Content", nullable = false, columnDefinition = "LONGTEXT")
        private String content;

}
