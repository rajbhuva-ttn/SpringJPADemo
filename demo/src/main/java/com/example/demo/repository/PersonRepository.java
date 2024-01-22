package com.example.demo.repository;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository {


    Person findById(int id);

    ResponseDTO deleteById(int id);

    ResponseDTO insert(Person person);

    ResponseDTO updateDetails(Person person);
}
