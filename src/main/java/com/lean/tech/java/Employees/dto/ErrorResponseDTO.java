package com.lean.tech.java.Employees.dto;

import lombok.Data;

@Data
public class ErrorResponseDTO {

	  private String message;
	  private String code;
	  private String type;
}
