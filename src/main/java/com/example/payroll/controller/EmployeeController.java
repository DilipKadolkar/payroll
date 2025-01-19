package com.example.payroll.controller;

import com.example.payroll.Employee;
import com.example.payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") // Base API URL for employee-related endpoints
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Get an employee by ID
    @GetMapping("/{employeeID}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeID) {
        return employeeService.getEmployeeById(employeeID)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update an existing employee
    @PutMapping("/{employeeID}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeID, @RequestBody Employee updatedEmployee) {
        try {
            Employee updated = employeeService.updateEmployee(employeeID, updatedEmployee);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an employee by ID
    @DeleteMapping("/{employeeID}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer employeeID) {
        try {
            employeeService.deleteEmployeeById(employeeID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get employees by department
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        return ResponseEntity.ok(employees);
    }

    // Get employees by last name
    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<Employee>> getEmployeesByLastName(@PathVariable String lastName) {
        List<Employee> employees = employeeService.getEmployeesByLastName(lastName);
        return ResponseEntity.ok(employees);
    }

    // Get an employee by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
