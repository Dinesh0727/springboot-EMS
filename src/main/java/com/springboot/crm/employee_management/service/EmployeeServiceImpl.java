package com.springboot.crm.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.crm.employee_management.Entity.Employee;
import com.springboot.crm.employee_management.dao.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> result =  employeeRepository.findById(id);
        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return theEmployee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


}
