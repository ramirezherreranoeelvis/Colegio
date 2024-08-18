package com.exam.colegio.model.course.content;

import com.exam.colegio.model.course.ContentItem;
import com.exam.colegio.model.course.Session;
import com.exam.colegio.util.Permission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(
        name = "typeResource",
        discriminatorType = DiscriminatorType.STRING,
        length = 20
)
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@Table(name = "resource")
public class Resource {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idResource;

        @ManyToOne
        @JoinColumn(name = "idSession", nullable = false)
        private Session session;

        @Column(name = "name", nullable = false, length = 100)
        private String name;

        @Column(name = "description", nullable = false, length = 300)
        private String description;

        @Enumerated(EnumType.STRING)
        @Column(name = "permission", length = 10, nullable = false, columnDefinition = "VARCHAR(10)")
        private Permission permission;

        @Column(name = "createtAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createtAt;

        @JsonIgnore
        @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL, orphanRemoval = true)
        private final List<ContentItem> contentItems = new ArrayList<>();

}
