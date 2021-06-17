package com.lean.tech.java.Employees.services;

import java.util.List;

import com.lean.tech.java.Employees.config.EmployeeException;
import com.lean.tech.java.Employees.model.Position;

public interface PositionService {

    public List<Position> allPosition() throws EmployeeException;


    
}
