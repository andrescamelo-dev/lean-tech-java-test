package com.lean.tech.java.Employees.convert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lean.tech.java.Employees.dto.EmployeeRequestDTO;
import com.lean.tech.java.Employees.dto.EmployeeResponseDTO;
import com.lean.tech.java.Employees.dto.PersonDTO;
import com.lean.tech.java.Employees.dto.PositionDTO;
import com.lean.tech.java.Employees.model.Employee;
import com.lean.tech.java.Employees.model.Person;
import com.lean.tech.java.Employees.model.Position;

public class EmployeeConverter {

    public static Employee convertEmployeeDtoToEmployee(EmployeeRequestDTO employeeDTO) {
        Person personId = Person.builder().name(employeeDTO.getName()).lastName(employeeDTO.getLastName())
                .address(employeeDTO.getAddress()).cityName(employeeDTO.getCityName())
                .cellphone(employeeDTO.getCellphone()).build();
        Position positionId = Position.builder().id(employeeDTO.getPositionId()).build();
        return Employee.builder().id(employeeDTO.getId()).salary(employeeDTO.getSalary()).personId(personId).positionId(positionId).build();
    }

    public static List<PositionDTO> convertEmployeesToPosionDTO(List<Employee> employees) {
        List<PositionDTO> result =  new ArrayList<>();
        Map<PositionDTO, List<EmployeeResponseDTO>> emplsMap = new HashMap<>();
        employees.stream().forEach(x -> {
            PositionDTO positionDTO = PositionDTO.builder().id(x.getPositionId().getId())
                    .name(x.getPositionId().getName()).build();
            if (emplsMap.containsKey(positionDTO)) {
                EmployeeResponseDTO eDto = createObjetEmployeeDTO(x);
                emplsMap.get(positionDTO).add(eDto);

            } else {
                List<EmployeeResponseDTO> emplsList = new ArrayList<>();
                EmployeeResponseDTO eDto = createObjetEmployeeDTO(x);
                emplsList.add(eDto);
                emplsMap.put(positionDTO, emplsList);
            }
        });
       
        for (Map.Entry<PositionDTO, List<EmployeeResponseDTO>> entry : emplsMap.entrySet()) {
            List<EmployeeResponseDTO> employeesList = entry.getValue().stream().sorted(Comparator.comparingInt(EmployeeResponseDTO::getSalary).reversed()).collect(Collectors.toList());
            PositionDTO posDto = PositionDTO.builder().id(entry.getKey().getId()).name(entry.getKey().getName())
            .employees(employeesList).build();
            result.add(posDto);
        }
        
        return result;
    }

    public static EmployeeResponseDTO createObjetEmployeeDTO(Employee employee) {
        PersonDTO personDto = PersonDTO.builder().name(employee.getPersonId().getName())
                .lastNam2(employee.getPersonId().getLastName()).address(employee.getPersonId().getAddress())
                .cityName(employee.getPersonId().getCityName()).cellphone(employee.getPersonId().getCellphone())
                .build();
        return EmployeeResponseDTO.builder().personId(personDto).salary(employee.getSalary()).id(employee.getId())
                .build();

    }

}
