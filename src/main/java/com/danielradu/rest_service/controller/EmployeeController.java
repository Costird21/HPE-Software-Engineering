package com.danielradu.rest_service.controller;

import com.danielradu.rest_service.dao.EmployeeDAO;
import com.danielradu.rest_service.model.Employee;
import com.danielradu.rest_service.model.Employees;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping()
    public Employees getEmployees() {
        return employeeDAO.getEmployees();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {

        Employee employee = employeeDAO.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);

    }

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {

        Integer id = employeeDAO
                .getEmployees()
                .getEmployeeList()
                .size() + 1;

        employee.setEmployee_id(id);

        employeeDAO.addEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getEmployee_id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
