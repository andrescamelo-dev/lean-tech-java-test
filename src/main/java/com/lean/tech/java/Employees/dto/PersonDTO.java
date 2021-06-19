package com.lean.tech.java.Employees.dto;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PersonDTO {
    private String name;
    private String lastNam2;
    private String address;
    private String cellphone;
    private String cityName;
}
