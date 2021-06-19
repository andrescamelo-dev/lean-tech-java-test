package com.lean.tech.java.Employees.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PositionDTO {
    private Integer id;
    private String name;
    private List<EmployeeResponseDTO> employees;
}
