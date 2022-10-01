package com.emppayroll.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;              //UC5
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@NoArgsConstructor
public class EmpDto {
    @Id
    @GeneratedValue

    Long employeeId;
//UC8
    @NotEmpty (message = "First name can not be empty")
    @Pattern(regexp="^[A-Z][a-zA-Z\\s]{2,}$", message="Invalid Name(Should have 1 Upper Case and min 3 Characters.)")
    String firstName;
    @NotEmpty (message = "Last name can not be empty")
    @Pattern(regexp="^[A-Z][a-zA-Z\\s]{2,}$", message="Invalid Name(Should have 1 Upper Case and min 3 Characters.)")
    String lastName;
    String department;
    @NotEmpty(message = "Address Cannot be Empty")
    String address;
    String gender;
    String profilePic;
    @Min(value = 5000, message="Salary Should be More than 5000")
    Long salary;
    @JsonFormat(pattern = "dd mm yyyy")
    @NotNull(message = "Start Date cannot be Empty")
    @PastOrPresent(message = "Start Date should be past or present date")
    Date startDate;
    String notes;
}