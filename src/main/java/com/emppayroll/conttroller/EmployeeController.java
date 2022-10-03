package com.emppayroll.conttroller;
import com.emppayroll.dto.EmpDto;
import com.emppayroll.dto.ResponseDto;
import com.emppayroll.model.EmployeeEntity;
import com.emppayroll.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService service;
//USeCase1 - Create Payroll App
    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String greet() {
        return "Welcome to Employee Payroll App";
    }
        /*
        Extending GreetingController to use Services Layer to get Simple Greeting message
         */
    @GetMapping("/serviceCall")
    public String serviceCall() {
        return service.welcomeMessage();
    }

//USeCase2 - Various http requests
    //Insert Employee Data
//    @PostMapping("/saveData")
//    public ResponseDto addEmpData(@RequestBody EmpDto empData) {
//        EmployeeEntity response = service.saveData(empData);
//        return new ResponseDto("Data Added Successfully", response);
//    }
//    //Get by ID
//    @GetMapping("/findById/{id}")
//    public Optional<EmployeeEntity> getById(@PathVariable Long id){
//        return service.findById(id);
//    }
//    //get all the data
//    @GetMapping("/printAll")
//    public List<EmployeeEntity> findAllData() {
//        return service.findAllData();
//    }
////UseCase3 - Added dto layer
//    //Edit or Update the data by id
//    @PutMapping("/edit/{id}")
//    public ResponseDto editData(@RequestBody EmployeeEntity empData, @PathVariable long id) {
//        EmployeeEntity response = service.editData(empData, id);
//        return new ResponseDto("Data Edited Successfully",response);
//    }
//    //Delete the data by id
//    @DeleteMapping("/delete/{id}")
//    public String deleteData(@PathVariable Long id) {
//        service.deleteData(id);
//        return "Employee Data deleted";
//    }
    //UseCase4
    @PostMapping("/postDto")
    public ResponseEntity<ResponseDto> addEmpData(@Valid @RequestBody EmpDto empData) {
        EmployeeEntity response = service.saveData(empData);
        ResponseDto dtoResponse = new ResponseDto("Data Added Successfully", Optional.ofNullable(response));
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }
    //Get by ID
    @GetMapping("/searchByid/{id}")
    public ResponseEntity<ResponseDto> getEmpData(@PathVariable Long id) {
        Optional<EmployeeEntity> empData;
        empData = service.findById(id);
        ResponseDto respDTO= new ResponseDto("Employee details by ID", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    //get all the data
    @GetMapping("/printAllDto")
    public ResponseEntity<ResponseDto> findAllData() {
        List<EmployeeEntity> empDatalist;
        empDatalist = service.findAllData();
        ResponseDto respDTO = new ResponseDto("All Employee Data", empDatalist);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    //Edit or Update the data by id
    @PutMapping("/editDto/{id}")
    public ResponseEntity<ResponseDto> updateEmpData(@PathVariable Long id, @RequestBody EmpDto empDto) {
        Optional<EmployeeEntity> empData;
        empData = Optional.ofNullable(service.editData(empDto, id));
        ResponseDto respDTO= new ResponseDto("Data Updated Successfully", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //Delete the data by id
    @DeleteMapping("/deleteDto/{id}")
    public ResponseEntity <ResponseDto> deleteEmpData(@PathVariable Long id) {
        service.deleteData(id);
        ResponseDto respDTO= new ResponseDto("Deleted Successfully", "Deleted id: " + id);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/empName/{firstName}")
    public ResponseEntity<ResponseDto> getEmployeeByName(@PathVariable String firstName) {
        List<EmployeeEntity> empDatalist;
        empDatalist = service.findByName(firstName);
        ResponseDto respDTO= new ResponseDto("Employee details of "+firstName+" :", empDatalist);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}