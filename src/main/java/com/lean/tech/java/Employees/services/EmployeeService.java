package com.lean.tech.java.Employees.services;

import java.util.List;

import com.lean.tech.java.Employees.config.EmployeeException;
import com.lean.tech.java.Employees.dto.EmployeeRequestDTO;
import com.lean.tech.java.Employees.model.Employee;

public interface EmployeeService {

    public Employee saveEmployee(EmployeeRequestDTO employeeDTO) throws EmployeeException;

    public void deleteEmployee(Integer id) throws EmployeeException;

    public List<Employee> allEmployee(String positionName, String name) throws EmployeeException;


    
}
