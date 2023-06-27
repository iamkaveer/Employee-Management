package com.employeemanagementsystem.Service;

import com.employeemanagementsystem.Dto.EmployeeRequest;
import com.employeemanagementsystem.Dto.EmployeeUpdateRequest;
import com.employeemanagementsystem.Model.Employee;
import com.employeemanagementsystem.Repository.IEmployeeRepository;
import com.employeemanagementsystem.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    //create a new employee
    public Employee createEmployee(EmployeeRequest employee) {
        Employee newEmployee = Employee.build(0,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getJobRole(),
                employee.getSalary());
        return iEmployeeRepository.save(newEmployee);
    }

    //get the list of all employee
    public List<Employee> getAll() {
        return iEmployeeRepository.findAll();
    }

    //get the employee by employee id
    public Employee getUserByID(int empId) throws UserNotFoundException {
        Employee employee = iEmployeeRepository.findById(empId)
                .orElseThrow(() -> new UserNotFoundException("Employee not found with id: " + empId));
        return employee;
    }

    //update the employee by hr
    public void updateUser(int empId, EmployeeRequest employeeRequest) {
        Employee exist = iEmployeeRepository.findByEmpId(empId);
        exist.setFirstName(employeeRequest.getFirstName());
        exist.setLastName(employeeRequest.getLastName());
        exist.setEmail(employeeRequest.getEmail());
        exist.setSalary(employeeRequest.getSalary());
        exist.setJobRole(employeeRequest.getJobRole());
        exist.setPhoneNumber(employeeRequest.getPhoneNumber());
        iEmployeeRepository.save(exist);
    }

    //delete the employee by hr
    public void deleteEmployee(int empId) {
        iEmployeeRepository.deleteById(empId);
    }

    //update employee profile by employee
    public void updateProfileInfo(int empId, EmployeeUpdateRequest employeeRequest) {
        Employee employee = iEmployeeRepository.findByEmpId(empId);
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhoneNumber(employeeRequest.getPhoneNumber());
        iEmployeeRepository.save(employee);
    }
}
