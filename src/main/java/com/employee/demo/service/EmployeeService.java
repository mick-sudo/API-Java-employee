package com.employee.demo.service;

import com.employee.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Optional<Employee> updatEmployee(Long id, Employee employee);

    Optional<Employee> getEmployeByID(Long id);

    String deleteEmployee(Long id);
}
