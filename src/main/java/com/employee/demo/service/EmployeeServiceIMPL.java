package com.employee.demo.service;

import com.employee.demo.model.Employee;
import com.employee.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeByID(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee removed";
    }

    @Override
    public Optional<Employee> updatEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id).map(e->{
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setEmail(employee.getEmail());
            e.setPhone(employee.getPhone());
            return employeeRepository.save(e);
        });
    }

}
