package com.example.payroll.controller;

import com.example.payroll.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/companies") 
public class CompanyController {
   
    @GetMapping
    public ResponseEntity<List<Company>> getAllEmployees() {
        List<Company> companies = new ArrayList<>();
        Company company=new Company();
        company.setCompanyName("Mauli Construction");
		companies.add(company);
        
		Company company1=new Company();
        company1.setCompanyName("Aquisharp");
		companies.add(company1);
		
		Company company2=new Company();
        company2.setCompanyName("Al Sama");
		companies.add(company2);
		
		return ResponseEntity.ok(companies);
    }

}
