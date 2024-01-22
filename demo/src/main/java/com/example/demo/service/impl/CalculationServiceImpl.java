package com.example.demo.service.impl;

import com.example.demo.Aspect.CustomAnnotation;
import com.example.demo.dto.CalculateMaxRequestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculationServiceImpl implements CalculateService {

    @Override
    public ResponseDTO findMaX(CalculateMaxRequestDTO calculateMaxRequestDTO) {

        int n = calculateMaxRequestDTO.getTotalNumbers();
        int max = 0;
        for(Integer number:calculateMaxRequestDTO.getNumbers()){
            if(number>max){
                max = number;
            }
        }

        toTestCustomAnnotation();

        return new ResponseDTO(max);
    }


    @Override
    public Exception throwException(){
        throw new RuntimeException("Exception Occurred.....");
    }

    @CustomAnnotation
    public void toTestCustomAnnotation(){
        log.info("Custom Annotation Testing");
    }
}
