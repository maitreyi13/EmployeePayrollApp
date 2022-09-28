package com.emppayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmpPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpPayrollApplication.class, args);
        log.info("Employee Payroll App");
    }
}
