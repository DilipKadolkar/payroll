package com.example.payroll.repository;

import com.example.payroll.entity.SalaryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryMasterRepository extends JpaRepository<SalaryMaster, String> {
    // You can add custom query methods here if needed
}
