package com.example.payroll.service;

import java.util.ArrayList;

import com.example.payroll.Employee;

public interface EmpService {
    ArrayList<Employee> findAllEmployee();
    Employee findAllEmployeeByID(long id);
    void addEmployee();
    void deleteAllData();
}
