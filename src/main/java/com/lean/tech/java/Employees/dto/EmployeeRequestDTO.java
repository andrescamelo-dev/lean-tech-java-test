package com.lean.tech.java.Employees.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;


@Data
@Builder
public class EmployeeRequestDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;
    private Integer salary;
    private Integer positionId;

    @Tolerate
    public EmployeeRequestDTO(){
      super();
    }
    
}
