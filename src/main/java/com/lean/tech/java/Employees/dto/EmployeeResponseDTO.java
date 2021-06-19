package com.lean.tech.java.Employees.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmployeeResponseDTO {
    private Integer id;
    private Integer salary;
    private PersonDTO personId;
}
