package com.practice.dao;

import com.practice.entity.Student;

import java.util.List;

public interface StudentDao {
    //for inserting data
    int insert(Student student);

    //for updating data
    int updateData(Student student);

    //for deleting data
    int delete(int id);

    //for selecting single row/object
    Student getStudent(int id);

    //for selecting multiple objects
//    public static List<Student> getAllStudents();
}
