package com.emppayroll.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeEntity {
    @Id
    Long employeeId;
    String firstName;
    String lastName;
    String profilePic;
    String address;
    Long salary;
    String notes;

    public EmployeeEntity(Long employeeId, String firstName,String lastName, String profilePic, String address, Long salary, String notes) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.address = address;
        this.salary = salary;
        this.notes = notes;
    }

    public EmployeeEntity() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}