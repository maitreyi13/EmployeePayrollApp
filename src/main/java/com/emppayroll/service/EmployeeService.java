package com.emppayroll.service;
import com.emppayroll.dto.EmpDto;
import com.emppayroll.exception.EmployeePayrollException;
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

    public EmployeeEntity saveData(EmpDto empData) {
        EmployeeEntity newEmpData = new EmployeeEntity(empData);
        repository.save(newEmpData);           //UC6 - save in repo
        return newEmpData;
    }
    public Optional<EmployeeEntity> findById(Long id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id);
        } else throw new EmployeePayrollException("No employee in database.");          //UC10
    }

    public List<EmployeeEntity> findAllData() {
        if (repository.findAll().isEmpty())
        {
            System.out.println("No data found");
            throw new EmployeePayrollException("No employee in database.");

        } else return repository.findAll();
    }

    public EmployeeEntity editData(EmpDto empData, Long id) {
        EmployeeEntity existingGreet = repository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setEmployeeId(empData.getEmployeeId());
            existingGreet.setFirstName(empData.getFirstName());
//            existingGreet.setLastName(empData.getLastName());
//            existingGreet.setProfilePic(empData.getProfilePic());
//            existingGreet.setAddress(empData.getAddress());
            existingGreet.setSalary(empData.getSalary());
//            existingGreet.setStartDate(empData.getStartDate());
//            existingGreet.setNotes(empData.getNotes());
            return repository.save(existingGreet);
        }
        return repository.save(existingGreet);
    }
    public void deleteData(Long id) {
        repository.deleteById(id);
    }
    public List<EmployeeEntity> findByName(String firstName) {
        return (repository.findEmployeeByName(firstName));
    }

}