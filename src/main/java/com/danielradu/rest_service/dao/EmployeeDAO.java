package com.danielradu.rest_service.dao;

import com.danielradu.rest_service.model.Employee;
import com.danielradu.rest_service.model.Employees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

    private final Employees employees = new Employees();

    public EmployeeDAO() {
        employees.getEmployeeList()
                .add(new Employee(1, "Andrew", "Page", "andrew@hpe.com", "Lead Manager"));

        employees.getEmployeeList()
                .add(new Employee(2, "Mark", "Grey", "mark@hpe.com", "Senior Software Engineer"));

        employees.getEmployeeList()
                .add(new Employee(3, "Daniel", "Radu", "daniel@hpe.com", "(Future) Trainee Software Engineer"));

    }

    public Employees getEmployees() {
        return employees;
    }

    public Employee getEmployeeById(Integer id) {
        return employees
                .getEmployeeList()
                .stream()
                .filter(employee -> employee.getEmployee_id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addEmployee(Employee employee) {
        employees.getEmployeeList().add(employee);
    }

}
