package com.lean.tech.java.Employees.controller;
import com.lean.tech.java.Employees.LeanTechJavaTestApplication;
import com.lean.tech.java.Employees.dto.EmployeeDTO;
import com.lean.tech.java.Employees.services.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;



@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
    RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH })
@RestController
@RequestMapping(LeanTechJavaTestApplication.PATH_SERVICE+"/api")
public class EmployeeController {


@Autowired
EmployeeServiceImpl employeeService;

@ApiOperation(value = "Method for create a employee", response = ResponseEntity.class)
@PostMapping(value = "/saveEmployee", produces = {MediaType.APPLICATION_JSON_VALUE })
@ResponseStatus(value = HttpStatus.OK)
@ResponseBody
public Object saveEmployee( @RequestBody EmployeeDTO employeeDTO){
    return employeeService.saveEmployee(employeeDTO);
}


@ApiOperation(value = "Method for find a employees by position name  or employee name", response = ResponseEntity.class)
@GetMapping(value = "/allEmployee", produces = {MediaType.APPLICATION_JSON_VALUE })
@ResponseStatus(value = HttpStatus.OK)
@ResponseBody
public Object allEmployee(@RequestParam String positionName, @RequestParam String name){
    return employeeService.allEmployee(positionName, name)  ;
}

}

