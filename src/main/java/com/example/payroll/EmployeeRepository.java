package com.example.payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository is a Spring annotation that
// indicates that the decorated class is a repository.
public interface EmployeeRepository extends JpaRepository <Employee, Long>{
    List<Employee> findAll();
}