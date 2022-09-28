package com.emppayroll.dto;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
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

    public EmpDto(String firstName,String lastName, String profilePic,String address, long salary, Date startDate, String notes) {
        this.firstName= firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.address = address;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
    }
}