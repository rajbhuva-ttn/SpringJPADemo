package com.example.demo.controller;


import com.example.demo.dto.CalculateMaxRequestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CalculationContoller {

    @Autowired
    CalculateService calculateService;

    @PostMapping(path = "/calculate")
    public ResponseDTO calculateMax(@RequestBody CalculateMaxRequestDTO calculateMaxRequestDTO){

        return calculateService.findMaX(calculateMaxRequestDTO);
    }

    @GetMapping(path = "/throwException")
    public ResponseDTO throwException(){
        return new ResponseDTO(calculateService.throwException());
    }
}
