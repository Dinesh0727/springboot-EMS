package com.springboot.crm.employee_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crm.employee_management.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
