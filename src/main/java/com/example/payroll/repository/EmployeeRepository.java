package com.example.payroll.repository;

import com.example.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// @Repository is a Spring annotation that
// indicates that the decorated class is a repository.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(String department);  // Find employees by department

    List<Employee> findByLastName(String lastName); // Find employees by last name

    Employee findByEmail(String email); // Find an employee by unique email
}