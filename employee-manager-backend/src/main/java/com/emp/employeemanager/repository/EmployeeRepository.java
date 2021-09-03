package com.emp.employeemanager.repository;

import com.emp.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Employee findEmployeeByPhone(String phone);

}
