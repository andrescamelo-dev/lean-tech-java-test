package com.lean.tech.java.Employees.controller;

import java.util.List;

import com.lean.tech.java.Employees.LeanTechJavaTestApplication;
import com.lean.tech.java.Employees.common.ErrorTypeEnum;
import com.lean.tech.java.Employees.common.ErrorsCodeEnum;
import com.lean.tech.java.Employees.common.Utils;
import com.lean.tech.java.Employees.config.EmployeeException;
import com.lean.tech.java.Employees.dto.EmployeeRequestDTO;
import com.lean.tech.java.Employees.dto.PositionDTO;
import com.lean.tech.java.Employees.model.Employee;
import com.lean.tech.java.Employees.services.impl.EmployeeServiceImpl;
import com.lean.tech.java.Employees.services.impl.PositionServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(LeanTechJavaTestApplication.PATH_SERVICE + "/api")
public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    PositionServiceImpl positionService;
    private String MESSAGE_LOGICAL_ERROR = "Logical Error";
    private String MESSAGE_GENERAL_ERROR = "General Error ";
   


    @ApiOperation(value = "Method for create a employee", response = ResponseEntity.class)
    @PostMapping(value = "/createEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Object createEmployee(@RequestBody EmployeeRequestDTO employeeDTO) {
        Employee result = null;
        try {
            employeeDTO.setId(null);
            result = employeeService.saveEmployee(employeeDTO);
        } catch (EmployeeException e) {
            LOG.error(MESSAGE_LOGICAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_LOGICAL_ERROR + e.getMessage(), ErrorTypeEnum.LOGICAL.getName(),
                    ErrorsCodeEnum.BAD_REQUEST.getCode());
        } catch (Exception e) {
            LOG.error(MESSAGE_GENERAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_GENERAL_ERROR + e.getMessage(), ErrorTypeEnum.GENERAL.getName(),
                    ErrorsCodeEnum.INTERNAL_SERVER_ERROR.getCode());
        }
        return result;
    }


    @ApiOperation(value = "Method for update a employee", response = ResponseEntity.class)
    @PostMapping(value = "/updateEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Object updateEmployee(@RequestBody EmployeeRequestDTO employeeDTO) {
        Employee result = null;
        try {
            result = employeeService.saveEmployee(employeeDTO);
        } catch (EmployeeException e) {
            LOG.error(MESSAGE_LOGICAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_LOGICAL_ERROR+ e.getMessage(), ErrorTypeEnum.LOGICAL.getName(),
                    ErrorsCodeEnum.BAD_REQUEST.getCode());
        } catch (Exception e) {
            LOG.error(MESSAGE_GENERAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_GENERAL_ERROR+ e.getMessage(), ErrorTypeEnum.GENERAL.getName(),
                    ErrorsCodeEnum.INTERNAL_SERVER_ERROR.getCode());
        }
        return result;
    }

    @ApiOperation(value = "Method for delete a employee", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteEmployee/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Object deleteEmployee(@PathVariable("employeeId") Integer employeeId ) {
        Boolean result = true;
        try {
             if (employeeId == null) {
                 throw new EmployeeException("the value employeeId can't be null");
             }
             employeeService.deleteEmployee(employeeId);
        } catch (EmployeeException e) {
            LOG.error(MESSAGE_LOGICAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_LOGICAL_ERROR+ e.getMessage(), ErrorTypeEnum.LOGICAL.getName(),
                    ErrorsCodeEnum.BAD_REQUEST.getCode());
        } catch (Exception e) {
            LOG.error(MESSAGE_GENERAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_GENERAL_ERROR+ e.getMessage(), ErrorTypeEnum.GENERAL.getName(),
                    ErrorsCodeEnum.INTERNAL_SERVER_ERROR.getCode());
        }
        return result;
    }


    @ApiOperation(value = "Method for find a employees by position name  or employee name", response = ResponseEntity.class)
    @GetMapping(value = "/allEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Object allEmployee(@RequestParam String positionName, @RequestParam String name) {
        List<Employee> result = null;
        try {
            result = employeeService.allEmployee(positionName, name);
        } catch (EmployeeException e) {
            LOG.error(MESSAGE_LOGICAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_LOGICAL_ERROR+ e.getMessage(), ErrorTypeEnum.LOGICAL.getName(),
                    ErrorsCodeEnum.BAD_REQUEST.getCode());
        } catch (Exception e) {
            LOG.error(MESSAGE_GENERAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_GENERAL_ERROR+ e.getMessage(), ErrorTypeEnum.GENERAL.getName(),
                    ErrorsCodeEnum.INTERNAL_SERVER_ERROR.getCode());
        }
        return result;
    }


    @ApiOperation(value = "Method for find a position order by salary", response = ResponseEntity.class)
    @GetMapping(value = "/allPosition", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Object allPosition() {
        List<PositionDTO> result = null;
        try {
            result = positionService.allPosition() ;
        } catch (EmployeeException e) {
            LOG.error(MESSAGE_LOGICAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_LOGICAL_ERROR+ e.getMessage(), ErrorTypeEnum.LOGICAL.getName(),
                    ErrorsCodeEnum.BAD_REQUEST.getCode());
        } catch (Exception e) {
            LOG.error(MESSAGE_GENERAL_ERROR, e);
            return Utils.errorResponse(MESSAGE_GENERAL_ERROR+ e.getMessage(), ErrorTypeEnum.GENERAL.getName(),
                    ErrorsCodeEnum.INTERNAL_SERVER_ERROR.getCode());
        }
        return result;
    }


}
