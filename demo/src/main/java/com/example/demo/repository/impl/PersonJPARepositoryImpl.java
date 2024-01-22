package com.example.demo.repository.impl;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Repository
@Transactional
@Slf4j
@Primary
public class PersonJPARepositoryImpl implements PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Person findById(int id) {
        log.info("JPA findById Query");
        return entityManager.find(Person.class, id);
    }

    @Override
    public ResponseDTO deleteById(int id) {
        Person person = findById(id);
        log.info("JPA deleteById Query");
        entityManager.remove(person);
        return new ResponseDTO("Deleted Successfully");
    }

    @Override
    public ResponseDTO insert(Person person) {
        log.info("JPA insert Query");
        return new ResponseDTO(entityManager.merge(person));
    }

    @Override
    public ResponseDTO updateDetails(Person person) {
        log.info("JPA updateDetails Query");
        return new ResponseDTO(entityManager.merge(person));
    }
}
