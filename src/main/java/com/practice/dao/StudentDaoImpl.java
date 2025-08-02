package com.practice.dao;

import com.practice.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        //Insert query
        String query = "insert student(id, name, city) values (?,?,?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return result;
    }

    @Override
    public int updateData(Student student) {
        String query = "update student set name = ?, city = ? where id = ?";
        int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return result;
    }

    @Override
    public int delete(int id) {
        String query = "delete from student where id = ?";
        int result = this.jdbcTemplate.update(query, id);
        return result;
    }

    @Override
    public Student getStudent(int id) {
        String query = "select * from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, id);
        return student;
    }

//    @Override
//    public List<Student> getAllStudents() {
//        //selecting multiple students
//        String query = "select * from student";
//        List<Student> students = this.jdbcTemplate.query(query, newRowMapperImpl());
//        return students;
//    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
