package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public class ResponseDTO implements Serializable {

    private int numbers;

    private Object data;

    public ResponseDTO(Integer number) {
        this.numbers = number;
    }

    public ResponseDTO(Object data) {
        this.data = data;
    }
}
