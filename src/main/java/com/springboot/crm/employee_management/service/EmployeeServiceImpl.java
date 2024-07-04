package com.springboot.crm.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.crm.employee_management.Entity.Employee;
import com.springboot.crm.employee_management.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

}
