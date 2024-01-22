package com.example.demo.service;

import com.example.demo.dto.CalculateMaxRequestDTO;
import com.example.demo.dto.ResponseDTO;

public interface CalculateService {

    public ResponseDTO findMaX(CalculateMaxRequestDTO calculateMaxRequestDTO);

    Exception throwException();
}
