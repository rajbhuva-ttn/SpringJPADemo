package com.example.demo.dto;


import lombok.Data;

import java.util.List;

@Data
public class CalculateMaxRequestDTO {

    int totalNumbers;
    List<Integer> numbers;
}
