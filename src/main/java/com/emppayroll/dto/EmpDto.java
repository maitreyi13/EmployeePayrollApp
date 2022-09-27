package com.emppayroll.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
public class EmpDto {
    @Id
    @GeneratedValue
    long employeeId;
    String firstName;
    String lastName;
    String address;
    String profilePic;
    Long salary;
    Date startDate;
    String notes;
}