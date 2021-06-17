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
@Table(name = "person")
@Data
@Builder
public class Person {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "cityName")
    private String cityName;
}
