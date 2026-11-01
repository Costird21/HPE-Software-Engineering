package com.danielradu.rest_service;

import com.danielradu.rest_service.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


public class EmployeeDAOTest {

    @Test
    public void testAddEmployee() {
        com.danielradu.rest_service.dao.EmployeeDAO employeeDAO = new com.danielradu.rest_service.dao.EmployeeDAO();

        assertThat(employeeDAO.getEmployees().getEmployeeList().size() == 3);

        int id = employeeDAO.getEmployees().getEmployeeList().size() + 1;
        Employee employee = new Employee(id, "Tester", "2", "tester2@hpe.com", "tester");
        employeeDAO.addEmployee(employee);

        assertThat(employeeDAO.getEmployees().getEmployeeList().size() == 4);

    }

    @Test
    public void testExistsByID() {
        com.danielradu.rest_service.dao.EmployeeDAO employeeDAO = new com.danielradu.rest_service.dao.EmployeeDAO();

        int id = employeeDAO.getEmployees().getEmployeeList().size() + 1;
        Employee employee = new Employee(id, "Tester", "2", "tester2@hpe.com", "tester");
        employeeDAO.addEmployee(employee);
        boolean exists = (employeeDAO.getEmployeeById(id) != null);
        assertThat(exists).isTrue();
    }

    @Test
    public void testGetAllEmployees() {
        com.danielradu.rest_service.dao.EmployeeDAO employeeDAO = new com.danielradu.rest_service.dao.EmployeeDAO();

        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(1, "Andrew", "Page", "andrew@hpe.com", "Lead Manager");
        Employee employee2 = new Employee(2, "Mark", "Grey", "mark@hpe.com", "Senior Software Engineer");
        Employee employee3 = new Employee(3, "Daniel", "Radu", "daniel@hpe.com", "(Future) Trainee Software Engineer");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);


        assertThat(employeeDAO.getEmployees().getEmployeeList() == employeeList);
        assertThat(employeeDAO).isNotNull();
        assertThat(employeeDAO.getEmployees().getEmployeeList().size()).isEqualTo(3);

    }
}
