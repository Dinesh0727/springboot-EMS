package com.springboot.crm.employee_management.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findEmployeeById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found " + employeeId);
        }

        return theEmployee;
    }

    

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON, set it to 0 
        // so that this is to force a save an item instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findEmployeeById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee with id " + employeeId + " is not found");
        }

        employeeService.deleteById(employeeId);

        return "Deleted the employee with id - " + employeeId;
    }
}
