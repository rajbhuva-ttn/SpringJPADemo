package com.example.demo.repository;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonJPARepository extends CrudRepository<Person, Integer> {

    Person findById(int id);

    ResponseDTO deleteById(int id);

    ResponseDTO insert(Person person);

    ResponseDTO updateDetails(Person person);

    List<Person> findByName(String name);
}
