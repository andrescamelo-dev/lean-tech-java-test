package com.lean.tech.java.Employees.convert;

import com.lean.tech.java.Employees.dto.EmployeeDTO;
import com.lean.tech.java.Employees.model.Employee;
import com.lean.tech.java.Employees.model.Person;
import com.lean.tech.java.Employees.model.Position;

public class EmployeeConverter {
   
    public static Employee convertEmployeeDtoToEmployee(EmployeeDTO employeeDTO){
    Person personId = Person.builder().name(employeeDTO.getName())
     .lastName(employeeDTO.getLastName())
     .address(employeeDTO.getAddress())
     .cityName(employeeDTO.getCityName())
     .cellphone(employeeDTO.getCellphone()).build();
     Position positionId = Position.builder().id(employeeDTO.getPositionId()).build();
     return  Employee.builder().salary(employeeDTO.getSalary()).personId(personId).positionId(positionId).build();
    }

}
