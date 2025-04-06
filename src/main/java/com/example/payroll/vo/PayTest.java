package com.example.payroll.vo;

public class PayTest {

    public static void main(String[] args) {
        FairPayVO fairPayVO = new FairPayVO();
        fairPayVO.setEmployeeNo("APSPL1037");

        // Input fields to calculate fair pay slip
//        fairPayVO.setPresentDays(25);
//        fairPayVO.setBasicRate(290.0); // TODO need to calculate
//        fairPayVO.setDaRate(194.0);
//        fairPayVO.setHraFinalRate(24.5806);

        fairPayVO.setEarnedEducationAllowance(975.00);
        fairPayVO.setEarnedMedicalAllowance(1000.00);
        fairPayVO.setEarnedOtherAllowance(5875.00);
        fairPayVO.setEarnedOvertime(5687.00);
        fairPayVO.setEarnedAttendanceBonus(0.00);
        fairPayVO.setEarnedProductionIncentive(10969.90);
        fairPayVO.setProfTax(200.00);
        fairPayVO.setMlwf(25.00);
        fairPayVO.setAdvance(2000.00);

        System.out.println("fairPayVO Earned Basic = "+fairPayVO.getEarnedBasic());
        System.out.println("fairPayVO Earned DA = "+fairPayVO.getEarnedDa());
        System.out.println("fairPayVO Earned HRA = "+fairPayVO.getEarnedHra());

        System.out.println("fairPayVO Earned Gross = "+fairPayVO.getEarnedGross());
        System.out.println("fairPayVO ESI = "+fairPayVO.getEsi0_75());
        System.out.println("fairPayVO PF = "+fairPayVO.getPf12());
        System.out.println("fairPayVO Total Deduction = "+fairPayVO.getTotalDeduction());
        System.out.println("fairPayVO Earned NetPay = "+fairPayVO.getEarnedNetPay());
    }
}
