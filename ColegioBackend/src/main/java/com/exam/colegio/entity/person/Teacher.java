package com.exam.colegio.model;

import com.exam.colegio.model.entity.Person;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@DiscriminatorValue("teacher")
public class Teacher extends Person {

}
