package com.example.demo.repository.impl;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public ResponseDTO deleteById(int id) {
        return new ResponseDTO(jdbcTemplate.update("delete from person where id=?", id));
    }

    @Override
    public ResponseDTO insert(Person person) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(person.getBirthdate(), formatter);
        return new ResponseDTO(jdbcTemplate.update("insert into person (id,name,location,birthdate) values (?,?,?,?)", person.getId(), person.getName(),person.getLocation(), date));
    }

    @Override
    public ResponseDTO updateDetails(Person person) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(person.getBirthdate(), formatter);
        return new ResponseDTO(jdbcTemplate.update("update person set name = ?, location = ?, birthdate = ? where id = ?", person.getName(),person.getLocation(), date,person.getId()));
    }
}
