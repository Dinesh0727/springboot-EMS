package com.springboot.crm.employee_management.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crm.employee_management.Entity.Employee;
import com.springboot.crm.employee_management.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
    
}
