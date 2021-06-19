package com.lean.tech.java.Employees.repository;

import java.util.List;

import com.lean.tech.java.Employees.model.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository("EmployeeRepository")
public interface EmployeeRepository  extends CrudRepository<Employee, Integer>  {

    @Query(value = "select e from Employee e, Person per, Position pos WHERE e.positionId.id = pos.id AND e.personId.id = per.id AND (pos.name = ?1 OR per.name = ?2)", nativeQuery = false)
    List<Employee> findBYPositionIdAndName(String positionName, String name);
    
}
