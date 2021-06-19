package com.lean.tech.java.Employees.services.impl;

import java.util.List;

import com.lean.tech.java.Employees.config.EmployeeException;
import com.lean.tech.java.Employees.convert.EmployeeConverter;
import com.lean.tech.java.Employees.dto.EmployeeRequestDTO;
import com.lean.tech.java.Employees.model.Employee;
import com.lean.tech.java.Employees.repository.EmployeeRepository;
import com.lean.tech.java.Employees.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(EmployeeRequestDTO employeeDTO) throws EmployeeException {
        Employee employee = EmployeeConverter.convertEmployeeDtoToEmployee(employeeDTO);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) throws EmployeeException {
        Employee employee =  Employee.builder().id(id).build();
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> allEmployee(String positionName, String name) throws EmployeeException {

        if (positionName.isBlank() || name.isEmpty()) {
            return (List<Employee>) employeeRepository.findAll();
        } else {
            return employeeRepository.findBYPositionIdAndName(positionName, name);
        }

       
    }
    
}
