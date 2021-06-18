package com.lean.tech.java.Employees.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;

/**
 *
 * @author Andres Camelo <br>
 * @date 16/06/2021
 */

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@Builder
public class Employee {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JoinColumn(name = "personId", nullable = false, referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.ALL}, optional = false)
    private Person personId;
    @JoinColumn(name = "positionId", nullable = false, referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Position positionId;
    @Column(name = "salary")
    private BigDecimal salary;

    @Tolerate
    public Employee(){
      super();
    }

   
}
