package com.exam.colegio.model;

import com.exam.colegio.model.entity.Person;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
@Entity
@DiscriminatorValue("assistant")
public class Assistant extends Person {

}
