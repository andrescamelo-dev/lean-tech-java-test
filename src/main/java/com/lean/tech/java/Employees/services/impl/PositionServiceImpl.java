package com.lean.tech.java.Employees.services.impl;

import java.util.List;

import com.lean.tech.java.Employees.config.EmployeeException;
import com.lean.tech.java.Employees.convert.EmployeeConverter;
import com.lean.tech.java.Employees.dto.PositionDTO;
import com.lean.tech.java.Employees.model.Employee;
import com.lean.tech.java.Employees.repository.EmployeeRepository;
import com.lean.tech.java.Employees.services.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl  implements PositionService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<PositionDTO> allPosition() throws EmployeeException {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        return EmployeeConverter.convertEmployeesToPosionDTO(employees);
    }
}
