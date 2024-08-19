package com.exam.colegio.repository.course.content.item;

import com.exam.colegio.model.course.content.item.StudentContentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentContentItemRepository extends JpaRepository<StudentContentItem, Integer> {

}
