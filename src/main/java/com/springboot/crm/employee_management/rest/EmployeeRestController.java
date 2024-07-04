package com.springboot.crm.employee_management.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crm.employee_management.Entity.Employee;
import com.springboot.crm.employee_management.dao.EmployeeDao;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao employeeDao;
    
    public EmployeeRestController(EmployeeDao theEmployeeDao){
        this.employeeDao = theEmployeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
    
}
