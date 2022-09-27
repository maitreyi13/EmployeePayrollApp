package com.emppayroll.dto;
import com.emppayroll.model.EmployeeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {
    String message;
    Object response;
    public ResponseDto(String message, EmployeeEntity response) {
        this.message = message;
        this.response = response;
    }
}