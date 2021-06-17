package com.lean.tech.java.Employees.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class EmployeeDTO {
    
    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;
    private BigDecimal salary;
    private Integer positionId;
    
}
