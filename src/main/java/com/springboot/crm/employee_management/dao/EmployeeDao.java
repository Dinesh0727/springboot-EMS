package com.springboot.crm.employee_management.dao;

import java.util.List;

import com.springboot.crm.employee_management.Entity.Employee;

public interface EmployeeDao {
    public List<Employee> findAll();
}
