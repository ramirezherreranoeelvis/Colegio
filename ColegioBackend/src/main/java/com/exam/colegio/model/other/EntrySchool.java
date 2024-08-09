package com.exam.colegio.model.other;

import com.exam.colegio.model.person.Student;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Builder
@Entity
@Table(name = "entrySchool")
public class EntrySchool {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idEntrySchool;

        @ManyToOne
        @JoinColumn(name = "idPerson", nullable = false, updatable = false)
        private Student student;

        @Column(name = "timeEntry", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date timeEntry;

        @Column(name = "timeExit")
        @Temporal(TemporalType.TIMESTAMP)
        private Date timeExit;

        @PrePersist
        protected void onCreate() {
                timeEntry = new Date();
        }

}
