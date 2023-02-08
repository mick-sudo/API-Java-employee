package com.employee.demo.controller;


import com.employee.demo.model.Employee;
import com.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/allEmployee")
    public List<Employee> employeesList(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<Employee> employeeById(@PathVariable Long id){return employeeService.getEmployeByID(id);}

    @PutMapping("/{id}")
    public Optional<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updatEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
