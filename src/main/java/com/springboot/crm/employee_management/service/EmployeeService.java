package com.springboot.crm.employee_management.service;

import java.util.List;

import com.springboot.crm.employee_management.Entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    public Employee findEmployeeById(int id);

    public Employee save(Employee theEmployee);

    public void deleteById(int id);
}
