package com.employeemanagementsystem.Controller;

import com.employeemanagementsystem.Dto.EmployeeRequest;
import com.employeemanagementsystem.Model.Employee;
import com.employeemanagementsystem.Service.EmployeeService;
import com.employeemanagementsystem.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //create a new employee
    @PostMapping("/create")
    public ResponseEntity<Employee> createNew(@RequestBody @Valid EmployeeRequest employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    //get all employee
    @GetMapping("/get-all")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    //find employee by id
    @GetMapping("/get-employee/{id}")
    public ResponseEntity<Employee> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(employeeService.getUserByID(id));
    }

    //update employee by hr
    @PutMapping("/update-employee/hr/{hrID}/employee/{empId}")
    public ResponseEntity<String> updateInfo(@RequestBody EmployeeRequest employeeRequest, @PathVariable int hrID, @PathVariable int empId) throws UserNotFoundException {
        Employee hr = employeeService.getUserByID(hrID);
        Employee existEmployee = employeeService.getUserByID(empId);
        if(hr.getJobRole().equals("HR")){
            employeeService.updateUser(empId, employeeRequest);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("updated");
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("invalid hr id");
        }
    }
    //delete employee by hr
    @DeleteMapping("/delete-employee/hr/{hrID}/employee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int hrID, @PathVariable int empId) throws UserNotFoundException {
        Employee hr = employeeService.getUserByID(hrID);
        Employee existEmployee = employeeService.getUserByID(empId);
        if (hr.getJobRole().equals("HR")) {
            employeeService.deleteEmployee(empId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("invalid hr id");
        }
    }
}
