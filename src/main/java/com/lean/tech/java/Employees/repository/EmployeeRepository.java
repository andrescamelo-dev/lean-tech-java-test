package com.lean.tech.java.Employees.repository;

import java.util.List;

import com.lean.tech.java.Employees.model.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository("EmployeeRepository")
public interface EmployeeRepository  extends CrudRepository<Employee, Integer>  {

    @Query(value = "select e.* from employee e INNER JOIN person p ON (e.personId = p.id) WHERE p.name = ? ", nativeQuery = true)
    List<Employee> findByPositionId(String name);
    
}
