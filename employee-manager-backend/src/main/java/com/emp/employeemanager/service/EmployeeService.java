package com.emp.employeemanager.service;

import com.emp.employeemanager.exception.UserNotFoundException;
import com.emp.employeemanager.model.Employee;
import com.emp.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository; // final ile tanımlandığı için constructor içinde initial bir atama yaptık.

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(()->new UserNotFoundException("User by id"+id+" was not found!"));
    }

    public Employee findEmployeeByPhone(String phone) {
        return employeeRepository.findEmployeeByPhone(phone);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
