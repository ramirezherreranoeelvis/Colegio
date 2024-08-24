package com.exam.colegio.model.course.content;

import com.exam.colegio.model.course.CourseScheduled;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("session")
public class Session extends Content {

        @Builder
        public Session(int idContent, String name, int number, boolean isVisible, CourseScheduled enrollment) {
                super(idContent, name, number, isVisible, enrollment);
        }

}
