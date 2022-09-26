package com.emppayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpPayrollApplication.class, args);
        System.out.println("Employee Payroll Project");
    }

}
