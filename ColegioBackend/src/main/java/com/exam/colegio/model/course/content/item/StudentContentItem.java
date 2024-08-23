package com.exam.colegio.model.course.content.item;

import com.exam.colegio.model.course.content.resource.Resource;
import com.exam.colegio.model.person.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("studentContent")
public class StudentContentItem extends ContentItem {

        @OneToOne(mappedBy = "studentContentItem", cascade = CascadeType.ALL)
        private GradeContentItem gradeContentItem;

        @Builder

        public StudentContentItem(int idContentItem, Person person, Resource resource, String content, String name, GradeContentItem gradeContentItem) {
                super(idContentItem, person, resource, content, name);
                this.gradeContentItem = gradeContentItem;
        }

}
