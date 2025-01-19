package com.example.payroll.service;

import com.example.payroll.Employee;
import com.example.payroll.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add a new employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Integer employeeID) {
        return employeeRepository.findById(employeeID);
    }

    // Update an existing employee
    public Employee updateEmployee(Integer employeeID, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeID);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            employee.setJobTitle(updatedEmployee.getJobTitle());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setHireDate(updatedEmployee.getHireDate());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setAddressLine1(updatedEmployee.getAddressLine1());
            employee.setAddressLine2(updatedEmployee.getAddressLine2());
            employee.setCity(updatedEmployee.getCity());
            employee.setState(updatedEmployee.getState());
            employee.setZipCode(updatedEmployee.getZipCode());
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeID);
        }
    }

    // Delete an employee by ID
    public void deleteEmployeeById(Integer employeeID) {
        employeeRepository.deleteById(employeeID);
    }

    // Get employees by department
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    // Get employees by last name
    public List<Employee> getEmployeesByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    // Get an employee by email
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}