package com.example.payroll.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SalaryMaster")
public class SalaryMaster {

    @Id
    @Column(name = "Employee_Number")
    private String employeeNumber;

    @Column(name = "Effective_Date")
    private LocalDate effectiveDate;

    @Column(name = "HAND_ENTRY_BASIC", precision = 10, scale = 2)
    private BigDecimal handEntryBasic;

    @Column(name = "HAND_ENTRY_FULL_DA", precision = 10, scale = 2)
    private BigDecimal handEntryFullDa;

    @Column(name = "HAND_ENTRY_FULL_HRA", precision = 10, scale = 2)
    private BigDecimal handEntryFullHra;

    @Column(name = "FULL_CONVEYANCE_ALLOWANCE", precision = 10, scale = 2)
    private BigDecimal fullConveyanceAllowance;

    @Column(name = "FULL_EDUCATION_ALLOWANCE", precision = 10, scale = 2)
    private BigDecimal fullEducationAllowance;

    @Column(name = "FULL_MEDICAL_ALLOWANCE", precision = 10, scale = 2)
    private BigDecimal fullMedicalAllowance;

    @Column(name = "FULL_OTHER_ALLOWANCE", precision = 10, scale = 2)
    private BigDecimal fullOtherAllowance;

    // Constructors, getters, setters, and toString()
    public SalaryMaster() {}

    // Getters and Setters

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getHandEntryBasic() {
        return handEntryBasic;
    }

    public void setHandEntryBasic(BigDecimal handEntryBasic) {
        this.handEntryBasic = handEntryBasic;
    }

    public BigDecimal getHandEntryFullDa() {
        return handEntryFullDa;
    }

    public void setHandEntryFullDa(BigDecimal handEntryFullDa) {
        this.handEntryFullDa = handEntryFullDa;
    }

    public BigDecimal getHandEntryFullHra() {
        return handEntryFullHra;
    }

    public void setHandEntryFullHra(BigDecimal handEntryFullHra) {
        this.handEntryFullHra = handEntryFullHra;
    }

    public BigDecimal getFullConveyanceAllowance() {
        return fullConveyanceAllowance;
    }

    public void setFullConveyanceAllowance(BigDecimal fullConveyanceAllowance) {
        this.fullConveyanceAllowance = fullConveyanceAllowance;
    }

    public BigDecimal getFullEducationAllowance() {
        return fullEducationAllowance;
    }

    public void setFullEducationAllowance(BigDecimal fullEducationAllowance) {
        this.fullEducationAllowance = fullEducationAllowance;
    }

    public BigDecimal getFullMedicalAllowance() {
        return fullMedicalAllowance;
    }

    public void setFullMedicalAllowance(BigDecimal fullMedicalAllowance) {
        this.fullMedicalAllowance = fullMedicalAllowance;
    }

    public BigDecimal getFullOtherAllowance() {
        return fullOtherAllowance;
    }

    public void setFullOtherAllowance(BigDecimal fullOtherAllowance) {
        this.fullOtherAllowance = fullOtherAllowance;
    }

    @Override
    public String toString() {
        return "SalaryMaster{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", handEntryBasic=" + handEntryBasic +
                ", handEntryFullDa=" + handEntryFullDa +
                ", handEntryFullHra=" + handEntryFullHra +
                ", fullConveyanceAllowance=" + fullConveyanceAllowance +
                ", fullEducationAllowance=" + fullEducationAllowance +
                ", fullMedicalAllowance=" + fullMedicalAllowance +
                ", fullOtherAllowance=" + fullOtherAllowance +
                '}';
    }
}
