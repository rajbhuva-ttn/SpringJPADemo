package com.example.demo.service.impl;

import com.example.demo.dto.CalculateMaxRequestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class CalculationServiceImplTest {

    @InjectMocks
    CalculationServiceImpl calculationServiceImpl;

    @BeforeAll
    static void beforeTest(){
        log.info("Before All Test case this line will be printed");
    }

    @Test
    void findMaX() {
       CalculateMaxRequestDTO calculateMaxRequestDTO = mock(CalculateMaxRequestDTO.class);
       when(calculateMaxRequestDTO.getNumbers()).thenReturn(Arrays.asList(1,2,88,5));
       when(calculateMaxRequestDTO.getTotalNumbers()).thenReturn(4);
       assertEquals(88,calculationServiceImpl.findMaX(calculateMaxRequestDTO).getNumbers());
    }



}
