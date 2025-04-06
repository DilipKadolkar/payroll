package com.example.payroll.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
@Getter
@Setter
public class FairPayVO {
    String employeeNo;

    double earnedBasic;
    double earnedDa;
    double earnedHra;

    String esiNumber;
    String uan;
    String gender;
    String name;

    int daysInMonth;
    int presentDays;
    double otHours;

    BigDecimal basicRate;
    BigDecimal daRate;
    BigDecimal hraFinalRate;
    double educationRate;
    double medicalRate;
    double otherAllowanceRate;

    double earnedEducationAllowance;
    double earnedMedicalAllowance;
    double earnedOtherAllowance;
    double earnedOvertime;
    double earnedAttendanceBonus;
    double earnedProductionIncentive;
    double earnedGross;

    double esi0_75;
    public double pf12;
    double profTax;
    double mlwf;
    double advance;
    double totalDeduction;

    double earnedNetPay;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEsiNumber() {
        return esiNumber;
    }

    public void setEsiNumber(String esiNumber) {
        this.esiNumber = esiNumber;
    }

    public String getUan() {
        return uan;
    }

    public void setUan(String uan) {
        this.uan = uan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }

    public void setDaysInMonth(int daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(int presentDays) {
        this.presentDays = presentDays;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public BigDecimal getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(BigDecimal basicRate) {
        this.basicRate = basicRate;
    }

    public BigDecimal getDaRate() {
        return daRate;
    }

    public void setDaRate(BigDecimal daRate) {
        this.daRate = daRate;
    }

    public BigDecimal getHraFinalRate() {
        return hraFinalRate;
    }

    public void setHraFinalRate(BigDecimal hraFinalRate) {
        this.hraFinalRate = hraFinalRate;
    }

    public double getEducationRate() {
        return educationRate;
    }

    public void setEducationRate(double educationRate) {
        this.educationRate = educationRate;
    }

    public double getMedicalRate() {
        return medicalRate;
    }

    public void setMedicalRate(double medicalRate) {
        this.medicalRate = medicalRate;
    }

    public double getOtherAllowanceRate() {
        return otherAllowanceRate;
    }

    public void setOtherAllowanceRate(double otherAllowanceRate) {
        this.otherAllowanceRate = otherAllowanceRate;
    }

    public double getEarnedBasic() {
        return earnedBasic = getPresentDays() * getBasicRate().doubleValue();
    }

    public void setEarnedBasic(double earnedBasic) {
        this.earnedBasic = earnedBasic;
    }

    public double getEarnedDa() {
        return earnedDa = getPresentDays() * getDaRate().doubleValue();
    }

    public void setEarnedDa(double earnedDa) {
        this.earnedDa = earnedDa;
    }

    public double getEarnedHra() {
        return earnedHra = getPresentDays() * getHraFinalRate().doubleValue();
    }

    public void setEarnedHra(double earnedHra) {
        this.earnedHra = earnedHra;
    }

    public double getEarnedEducationAllowance() {
        return earnedEducationAllowance;
    }

    public void setEarnedEducationAllowance(double earnedEducationAllowance) {
        this.earnedEducationAllowance = earnedEducationAllowance;
    }

    public double getEarnedMedicalAllowance() {
        return earnedMedicalAllowance;
    }

    public void setEarnedMedicalAllowance(double earnedMedicalAllowance) {
        this.earnedMedicalAllowance = earnedMedicalAllowance;
    }

    public double getEarnedOtherAllowance() {
        return earnedOtherAllowance;
    }

    public void setEarnedOtherAllowance(double earnedOtherAllowance) {
        this.earnedOtherAllowance = earnedOtherAllowance;
    }

    public double getEarnedOvertime() {
        return earnedOvertime;
    }

    public void setEarnedOvertime(double earnedOvertime) {
        this.earnedOvertime = earnedOvertime;
    }

    public double getEarnedAttendanceBonus() {
        return earnedAttendanceBonus;
    }

    public void setEarnedAttendanceBonus(double earnedAttendanceBonus) {
        this.earnedAttendanceBonus = earnedAttendanceBonus;
    }

    public double getEarnedProductionIncentive() {
        return earnedProductionIncentive;
    }

    public void setEarnedProductionIncentive(double earnedProductionIncentive) {
        this.earnedProductionIncentive = earnedProductionIncentive;
    }

    public double getEarnedGross() {
        earnedGross = getEarnedBasic() + getEarnedDa() + getEarnedHra() + earnedEducationAllowance + earnedMedicalAllowance + earnedOtherAllowance + earnedOvertime +earnedAttendanceBonus + earnedProductionIncentive;


        return earnedGross;
    }

    public void setEarnedGross(double earnedGross) {
        this.earnedGross = earnedGross;
    }

    public double getEsi0_75() {
        return esi0_75 = getEarnedGross() * 0.75/100;
    }

    public void setEsi0_75(double esi0_75) {
        this.esi0_75 = esi0_75;
    }

    public double getPf12() {
        DecimalFormat df = new DecimalFormat("#.##");
        return this.pf12 = Double.parseDouble(df.format((getEarnedBasic() + getEarnedDa()) * 0.12));
    }

    public void setPf12(double pf12) {
        this.pf12 = getEarnedBasic() * 0.12;
    }

    public double getProfTax() {
        return profTax;
    }

    public void setProfTax(double profTax) {
        this.profTax = profTax;
    }

    public double getMlwf() {
        return mlwf;
    }

    public void setMlwf(double mlwf) {
        this.mlwf = mlwf;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getTotalDeduction() {
        return totalDeduction = getPf12() + getProfTax() + getMlwf() + getAdvance();
    }

    public void setTotalDeduction(double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public double getEarnedNetPay() {
        DecimalFormat df = new DecimalFormat("#.##");
        //return this.pf12 = Double.parseDouble(df.format((getEarnedBasic() + getEarnedDa()) * 0.12));
        return earnedNetPay = Double.parseDouble(df.format(getEarnedGross() - getTotalDeduction()));
    }

    public void setEarnedNetPay(double earnedNetPay) {
        this.earnedNetPay = earnedNetPay;
    }

    @Override
    public String toString() {
        return "FairPayVO{" +
                "employeeNo='" + employeeNo + '\'' +
                ", earnedBasic=" + earnedBasic +
                ", earnedDa=" + earnedDa +
                ", earnedHra=" + earnedHra +
                ", esiNumber='" + esiNumber + '\'' +
                ", uan='" + uan + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", daysInMonth=" + daysInMonth +
                ", presentDays=" + presentDays +
                ", otHours=" + otHours +
                ", basicRate=" + basicRate +
                ", daRate=" + daRate +
                ", hraFinalRate=" + hraFinalRate +
                ", educationRate=" + educationRate +
                ", medicalRate=" + medicalRate +
                ", otherAllowanceRate=" + otherAllowanceRate +
                ", earnedEducationAllowance=" + earnedEducationAllowance +
                ", earnedMedicalAllowance=" + earnedMedicalAllowance +
                ", earnedOtherAllowance=" + earnedOtherAllowance +
                ", earnedOvertime=" + earnedOvertime +
                ", earnedAttendanceBonus=" + earnedAttendanceBonus +
                ", earnedProductionIncentive=" + earnedProductionIncentive +
                ", earnedGross=" + earnedGross +
                ", esi0_75=" + esi0_75 +
                ", pf12=" + pf12 +
                ", profTax=" + profTax +
                ", mlwf=" + mlwf +
                ", advance=" + advance +
                ", totalDeduction=" + totalDeduction +
                ", earnedNetPay=" + earnedNetPay +
                '}';
    }

}

