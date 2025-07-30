package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Program is starting...................");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate template = context.getBean("springJDBCTemplate", JdbcTemplate.class);

        //Insert query
        String query = "insert into student(id, name, city) values (?,?,?)";

        //Fire the query
        int result = template.update(query, 103, "Hifza", "Oman");
        System.out.println(result);
    }
}