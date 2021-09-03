package com.emp.employeemanager.rest;

import com.emp.employeemanager.model.Employee;
import com.emp.employeemanager.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(exposedHeaders = {"*"})
// or origins = {"http://localhost:7777"} or exposedHeaders="Access-Control-Allow-Origin"
public class EmployeeResource {

    /**
     * NOT: CORS kısaca kendi uygulamamızın başka bir uygulamaya bağlanma işleminin yönetilmesidir.
     * Uygulamalar arası haberleşmenin istemci tarafından izin verilmesi gerekmektedir.
     * <p>
     * Spring Boot uygulamamızda oluşturduğumuz servislerin diğer uygulamalar ile haberleşebilmesi için CORS desteğini açmamız gerekiyor.
     * Bu desteği ise @CrossOrigin anotasyonu ile sağlamaktayız.
     */

    private final EmployeeService employeeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeResource.class);

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //@CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeService.deleteEmployee(id);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return new ResponseEntity<>("Record not found! - " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Record deleted.", HttpStatus.OK);
    }


}
