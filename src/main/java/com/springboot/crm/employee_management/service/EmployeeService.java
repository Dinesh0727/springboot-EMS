package com.springboot.crm.employee_management.service;

import java.util.List;

import com.springboot.crm.employee_management.Entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
}
