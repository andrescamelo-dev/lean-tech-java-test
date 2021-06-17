package com.lean.tech.java.Employees.repository;

import com.lean.tech.java.Employees.model.Position;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("PositionRepository")
public interface PositionRepository  extends CrudRepository<Position, Integer>  {
    
}
