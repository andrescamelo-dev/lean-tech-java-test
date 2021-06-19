package com.lean.tech.java.Employees.common;

import com.lean.tech.java.Employees.dto.ErrorResponseDTO;

import org.springframework.http.HttpStatus;

public class Utils {
  
    
    public static ErrorResponseDTO errorResponse(String message, String typeError,String code){
        ErrorResponseDTO errors = new ErrorResponseDTO();
        errors.setMessage(message);
        errors.setCode(code);
        errors.setType(typeError);
        return errors;
    }
}
