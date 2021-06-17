package com.lean.tech.java.Employees.model;

import lombok.Builder;
import lombok.Data;
/**
 *
 * @author Andres Camelo <br>
 * @date 16/06/2021
 */

import javax.persistence.*;

@Entity
@Table(name = "position")
@Data
@Builder
public class Position {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
}
