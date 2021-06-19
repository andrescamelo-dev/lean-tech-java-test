package com.lean.tech.java.Employees.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import com.lean.tech.java.Employees.controller.EmployeeController;
import com.lean.tech.java.Employees.dto.EmployeeRequestDTO;
import com.lean.tech.java.Employees.dto.ErrorResponseDTO;
import com.lean.tech.java.Employees.dto.PositionDTO;
import com.lean.tech.java.Employees.model.Employee;
import com.lean.tech.java.Employees.model.Person;
import com.lean.tech.java.Employees.model.Position;
import com.lean.tech.java.Employees.repository.EmployeeRepository;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class EmployeeControllerTest {

    @Autowired
	EmployeeController employeeController;

	private EmployeeRepository employeeRepository;
    private Employee employee;
	private EmployeeRequestDTO employeeRequestDTO;

	@BeforeEach
	void setUp() {
		employeeRepository = Mockito.mock(EmployeeRepository.class);
		Person personId = Person.builder().name("Andres").lastName("Camelo")
				.address("cra 8").cityName("Cali")
				.cellphone("223111").build();
		Position positionId = Position.builder().id(1).build();
		employee = Employee.builder().id(null).salary(1000).personId(personId)
				.positionId(positionId).build();
	employeeRequestDTO = EmployeeRequestDTO.builder().name("Andres").lastName("Camelo")
	.address("cra 8").cityName("Cali")
	.cellphone("223111").positionId(1).salary(1000).build();
	   

	}

	@Test
	void whenCreateEmployee_thenResponseOkReturn() throws Exception {
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		Object createEmployee = employeeController.createEmployee(employeeRequestDTO);
		assertNotNull(createEmployee);

	}

	@Test
	void whenCreateEmployee_thenResponseBadReturn() throws Exception {
		Mockito.when(employeeRepository.save(null)).thenReturn(null);
		ErrorResponseDTO errorResponseDTO = (ErrorResponseDTO) employeeController.createEmployee(null);
		assertNotNull(errorResponseDTO);

	}

	@Test
	void whenUpdateEmployee_thenResponseOkReturn() throws Exception {
		employee.setId(1);
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		Object createEmployee = employeeController.updateEmployee(employeeRequestDTO);
		assertNotNull(createEmployee);

	}

	@Test
	void whenUpdateEmployee_thenResponseBadReturn() throws Exception {
		Mockito.when(employeeRepository.save(null)).thenReturn(null);
		ErrorResponseDTO errorResponseDTO = (ErrorResponseDTO) employeeController.updateEmployee(null);
		assertNotNull(errorResponseDTO);

	}


	@Test
	void whenDeleteEmployee_thenResponseOkReturn() throws Exception {
		employee.setId(1);
		doNothing().when(employeeRepository).delete(employee);
		Boolean delete = (Boolean) employeeController.deleteEmployee(1);
		assertEquals(true, delete);
	}

	@Test
	void whenDeleteEmployee_thenResponseBadReturn() throws Exception {
		employee.setId(null);
		doNothing().when(employeeRepository).delete(employee);
		ErrorResponseDTO errorResponseDTO = (ErrorResponseDTO) employeeController.deleteEmployee(null);
		assertNotNull(errorResponseDTO);

	}


	@Test
	void whenFindAllEmployees_thenResponseOkReturn() throws Exception {
		Mockito.when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
		List<Employee> createEmployee = (List<Employee>) employeeController.allEmployee("","");
		assertNotNull(createEmployee);
	}

	@Test
	void whenFindAllEmployeesByPositionOrName_thenResponseOkReturn() throws Exception {
		Mockito.when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
		List<Employee> createEmployee = (List<Employee>) employeeController.allEmployee("dev","andres");
		assertNotNull(createEmployee);
	}


	@Test
	void whenPositionEmployees_thenResponseOkReturn() throws Exception {
		Mockito.when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
		List<PositionDTO> createEmployee = (List<PositionDTO>) employeeController.allPosition();
		assertNotNull(createEmployee);
	}

}
