package com.example.payroll.service;

import com.example.payroll.entity.SalaryMaster;
import com.example.payroll.repository.SalaryMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class SalaryMasterService {

    @Autowired
    private SalaryMasterRepository salaryMasterRepository;

    public SalaryMaster addSalary(SalaryMaster salaryMaster) {
        return salaryMasterRepository.save(salaryMaster);
    }

    public SalaryMaster updateSalary(SalaryMaster salaryMaster) {
        return salaryMasterRepository.save(salaryMaster);
    }

    public Optional<SalaryMaster> getSalary(String employeeNumber) {
        return salaryMasterRepository.findById(employeeNumber);
    }

    public void deleteSalary(String employeeNumber) {
        salaryMasterRepository.deleteById(employeeNumber);
    }

    //Example of how to create a SalaryMaster Object.
    public SalaryMaster createExampleSalary(){
        SalaryMaster salary = new SalaryMaster();
        salary.setEmployeeNumber("E123");
        salary.setEffectiveDate(LocalDate.now());
        salary.setHandEntryBasic(new BigDecimal("5000.00"));
        salary.setHandEntryFullDa(new BigDecimal("2000.00"));
        salary.setHandEntryFullHra(new BigDecimal("1500.00"));
        salary.setFullConveyanceAllowance(new BigDecimal("300.00"));
        salary.setFullEducationAllowance(new BigDecimal("200.00"));
        salary.setFullMedicalAllowance(new BigDecimal("100.00"));
        salary.setFullOtherAllowance(new BigDecimal("500.00"));
        return salary;
    }
}
