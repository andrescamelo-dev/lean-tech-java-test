package com.lean.tech.java.Employees.services;

import java.util.List;

import com.lean.tech.java.Employees.config.EmployeeException;
import com.lean.tech.java.Employees.dto.PositionDTO;

public interface PositionService {

    public List<PositionDTO> allPosition() throws EmployeeException;


    
}
