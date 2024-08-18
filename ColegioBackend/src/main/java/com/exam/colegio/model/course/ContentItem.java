package com.exam.colegio.model.course;

import com.exam.colegio.model.person.Person;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "resource")
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

        @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
        private String content;

}
