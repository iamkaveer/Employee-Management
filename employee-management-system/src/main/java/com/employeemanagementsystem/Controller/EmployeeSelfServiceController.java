package com.employeemanagementsystem.Controller;

import com.employeemanagementsystem.Dto.EmployeeRequest;
import com.employeemanagementsystem.Dto.EmployeeUpdateRequest;
import com.employeemanagementsystem.Model.Employee;
import com.employeemanagementsystem.Service.EmployeeService;
import com.employeemanagementsystem.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeSelfServiceController {
    @Autowired
    private EmployeeService employeeService;

    //update employee profile
    @PutMapping("/update-profile/{empId}")
    public ResponseEntity<String> updateProfileInfo(@RequestBody EmployeeUpdateRequest employeeRequest, @PathVariable int empId) throws UserNotFoundException{
        Employee existEmployee = employeeService.getUserByID(empId);
        employeeService.updateProfileInfo(empId,employeeRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("profile updated");
    }
}
