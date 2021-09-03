package com.emp.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "seq_employee", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "employee_seq")
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;


}
