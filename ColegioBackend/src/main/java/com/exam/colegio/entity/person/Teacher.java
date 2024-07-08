package com.exam.colegio.entity.person;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@DiscriminatorValue("teacher")
public class Teacher extends Person {

}
