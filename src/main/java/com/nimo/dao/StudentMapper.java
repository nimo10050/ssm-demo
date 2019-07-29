package com.nimo.dao;

import com.nimo.entity.Course;
import com.nimo.entity.Student;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> queryStudent();
    List<Course> queryCourse();
}
