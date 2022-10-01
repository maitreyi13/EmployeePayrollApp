package com.emppayroll.exception;

import com.emppayroll.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeePayrollHandler {
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception){
        ResponseDto resDTO = new ResponseDto("Exception while processing REST request",
                exception.getMessage());
        return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
    }
}