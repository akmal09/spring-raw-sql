package com.raw.springsql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void InsertEmployee(Integer id, String name, String email, int age){
        String query = "INSERT INTO employee(id, name, email, age) VALUES (?,?,?,?)";
        jdbcTemplate.update(query, id, name, email, age);
    }
}
