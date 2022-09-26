package com.emppayroll.service;
import com.emppayroll.model.EmployeeEntity;
import com.emppayroll.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    Repo repository;

    public String welcomeMessage() {
        return "This is Employee Payroll App";
    }

    public EmployeeEntity saveData(EmployeeEntity empData) {
        repository.save(empData);
        return empData;
    }
    public Optional<EmployeeEntity> findById(Long id) {
        return repository.findById(id);
    }

    public List<EmployeeEntity> findAllData() {
        return repository.findAll();
    }

    public EmployeeEntity editData(EmployeeEntity empData, Long id) {
        EmployeeEntity existingGreet = repository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setEmployeeId(empData.getEmployeeId());
            existingGreet.setFirstName(empData.getFirstName());
            existingGreet.setLastName(empData.getLastName());
            existingGreet.setProfilePic(empData.getProfilePic());
            existingGreet.setAddress(empData.getAddress());
            existingGreet.setSalary(empData.getSalary());
            existingGreet.setNotes(empData.getNotes());
            return repository.save(existingGreet);
        }
        else
            return null;
    }
    public void deleteData(Long id) {
        repository.deleteById(id);
    }
}