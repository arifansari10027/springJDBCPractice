package com.practice;

import com.practice.dao.StudentDao;
import com.practice.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Program is starting...................");
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        Student student = new Student();
        //For inserting data
        student.setId(102);
        student.setName("Ankush");
        student.setCity("Jamshedpur");
        int insertResult = studentDao.insert(student);
        System.out.println("Rows inserted: " + insertResult);

        //For updating data
        student.setId(102);
        student.setName("Hifza");
        student.setCity("Oman");
        int updateResult = studentDao.updateData(student);
        System.out.println("Rows updated: " + updateResult);

        //For deleting data
        int deleteResult = studentDao.delete(102);
        System.out.println("Rows deleted: " + deleteResult);

        //For selecting data
//        Student studentResult = studentDao.getStudent(102);
//        System.out.println(studentResult);

        //For selecting all data
//        List<Student> allStudents = StudentDao.getAllStudents();
//        for (Student s:allStudents) {
//            System.out.println(s);
        }
    }
//}