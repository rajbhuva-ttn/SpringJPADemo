package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonJPARepository;
import com.example.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonJPARepository personJPARepository;

    @GetMapping("/findById")
    public ResponseDTO findById(@RequestParam int id){
//        return new ResponseDTO(personRepository.findById(id));
        return new ResponseDTO(personJPARepository.findById(id));
    }

    @GetMapping("/deleteById")
    public ResponseDTO deleteById(@RequestParam int id){
//        return new ResponseDTO(personRepository.deleteById(id));
        return new ResponseDTO(personJPARepository.deleteById(id));
    }

    @PostMapping("/insert")
    public ResponseDTO insert(@RequestBody Person person){
        log.info(person.toString());
//        return personRepository.insert(person);
        return personJPARepository.insert(person);
    }

    @PostMapping("/update")
    public ResponseDTO update(@RequestBody Person person){
        log.info(person.toString());
//        return personRepository.updateDetails(person);
        return personJPARepository.updateDetails(person);
    }

    @GetMapping("/findByName")
    public ResponseDTO findByName(@RequestParam String name){
        log.info("JPA findByName Query");
        return new ResponseDTO(personJPARepository.findByName(name));
    }
}
