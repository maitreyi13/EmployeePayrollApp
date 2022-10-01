package com.emppayroll.model;
import com.emppayroll.dto.EmpDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue
    Long employeeId;
    String firstName;
    String lastName;
    String department;
    String profilePic;
    String address;
    String gender;
    Long salary;
    Date startDate;
    String notes;

    public EmployeeEntity(EmpDto empData) {
        this.firstName = empData.getFirstName();
        this.lastName = empData.getLastName();
        this.department = empData.getDepartment();
        this.address = empData.getAddress();
        this.gender = empData.getGender();
        this.profilePic = empData.getProfilePic();
        this.salary = empData.getSalary();
        this.startDate = empData.getStartDate();
        this.notes = empData.getNotes();
    }
}