package com.example.payroll.controller;

import com.example.payroll.entity.SalaryMaster;
import com.example.payroll.service.EmployeeService;
import com.example.payroll.service.SalaryMasterService;
import com.example.payroll.vo.FairPayVO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class FileUploadController {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    SalaryMasterService sm = new SalaryMasterService();

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(FileUploadController fileUploadController, @RequestParam("file") MultipartFile file) {
        System.out.println("FileUploadController.handleFileUpload called");

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".xlsx") && !file.getOriginalFilename().endsWith(".xls")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid file format! Please upload an Excel file.");
            }

            // Create directory if it does not exist
//            Path uploadPath = Paths.get(UPLOAD_DIR);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }

            // Save the file to the server
            String filePath = "C:\\Users\\Public\\IdeaProjects\\payroll\\uploads\\" + file.getOriginalFilename();
            File destFile = new File(filePath);
            file.transferTo(destFile);
            System.out.println("FileUploadController.handleFileUpload, filePath =>  " + filePath);

            //getWorkBook();
            // Write to file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                getWorkBook().write(fileOut);
                System.out.println("Excel file written successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return ResponseEntity.ok("File uploaded successfully: " + filePath);
//            Sheet sheet = workbook.getSheetAt(0);
//            Row firstRow = sheet.getRow(0);
//            Cell firstCell = firstRow.getCell(0);
//
//            String cellValue = getCellValueAsString(firstCell);
//            System.out.println("First row, first column content: " + cellValue);
//
//            return ResponseEntity.ok("First row, first column content: " + cellValue);
//
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the file.");
        }
    }

    public Workbook getWorkBook() {
        // Create a new Excel workbook
        Workbook fairworkbook = new XSSFWorkbook();
        Sheet sheet = fairworkbook.createSheet("Employee Data");
        FairPayVO fairPayVO = getFairPayVO();

        System.out.println("fairPayVO.getPf12() = "+fairPayVO.getPf12());

        Row headers = sheet.createRow(6);
        Cell cellHeader = headers.createCell(0);
        cellHeader.setCellValue("EmployeeNo");

        cellHeader = headers.createCell(1);
        cellHeader.setCellValue("ESI Number");

        cellHeader = headers.createCell(2);
        cellHeader.setCellValue("UAN");

        cellHeader = headers.createCell(3);
        cellHeader.setCellValue("Gender");

        cellHeader = headers.createCell(4);
        cellHeader.setCellValue("Name");

        cellHeader = headers.createCell(5);
        cellHeader.setCellValue("DAYS IN MONTH");

        cellHeader = headers.createCell(6);
        cellHeader.setCellValue("PRESENT DAYS");

        cellHeader = headers.createCell(7);
        cellHeader.setCellValue("OT HOURS");

        cellHeader = headers.createCell(8);
        cellHeader.setCellValue("BASIC RATE");

        cellHeader = headers.createCell(9);
        cellHeader.setCellValue("DA RATE");

        cellHeader = headers.createCell(10);
        cellHeader.setCellValue("HRA FINAL RATE");

        cellHeader = headers.createCell(11);
        cellHeader.setCellValue("EDUCATION RATE");

        cellHeader = headers.createCell(12);
        cellHeader.setCellValue("MEDICAL RATE");

        cellHeader = headers.createCell(13);
        cellHeader.setCellValue("OTHER ALLOWANCE RATE");

        cellHeader = headers.createCell(14);
        cellHeader.setCellValue("Earned BASIC");

        cellHeader = headers.createCell(15);
        cellHeader.setCellValue("Earned DA");

        cellHeader = headers.createCell(16);
        cellHeader.setCellValue("Earned HRA");
        cellHeader = headers.createCell(17);
        cellHeader.setCellValue("Earned EDUCATION ALLOWANCE");


        cellHeader = headers.createCell(18);
        cellHeader.setCellValue("Earned MEDICAL ALLOWANCE");

        cellHeader = headers.createCell(19);
        cellHeader.setCellValue("Earned OTHER ALLOWANCE");

        cellHeader = headers.createCell(20);
        cellHeader.setCellValue("Earned OVERTIME");

        cellHeader = headers.createCell(21);
        cellHeader.setCellValue("Earned ATTENDANCE BONUS");

        cellHeader = headers.createCell(22);
        cellHeader.setCellValue("Earned PRODUCTION INCENTIVE");
        cellHeader = headers.createCell(23);
        cellHeader.setCellValue("Earned GROSS");
        cellHeader = headers.createCell(24);
        cellHeader.setCellValue("ESI 0.75%");
        cellHeader = headers.createCell(25);
        cellHeader.setCellValue("PF 12%");
        cellHeader = headers.createCell(26);
        cellHeader.setCellValue("PROF TAX");
        cellHeader = headers.createCell(27);
        cellHeader.setCellValue("MLWF");
        cellHeader = headers.createCell(28);
        cellHeader.setCellValue("ADVANCE");
        cellHeader = headers.createCell(29);
        cellHeader.setCellValue("TOTAL DEDUCTION");
        cellHeader = headers.createCell(30);
        cellHeader.setCellValue("Earned NET PAY");


        Row row = sheet.createRow(7);
        Cell cell = row.createCell(0);
        cell.setCellValue((String) fairPayVO.getEmployeeNo());

        cell = row.createCell(1);
        cell.setCellValue((String) fairPayVO.getEsiNumber());

        cell = row.createCell(2);
        cell.setCellValue((String) fairPayVO.getUan());

        cell = row.createCell(3);
        cell.setCellValue((String) fairPayVO.getGender());

        cell = row.createCell(4);
        cell.setCellValue((String) fairPayVO.getName());

        cell = row.createCell(5);
        cell.setCellValue(fairPayVO.getDaysInMonth());

        cell = row.createCell(6);
        cell.setCellValue(fairPayVO.getPresentDays());

        cell = row.createCell(7);
        cell.setCellValue(fairPayVO.getOtHours());

        cell = row.createCell(8);
        cell.setCellValue(""+fairPayVO.getBasicRate());

        cell = row.createCell(9);
        cell.setCellValue(""+fairPayVO.getDaRate());

        cell = row.createCell(10);
        cell.setCellValue(""+fairPayVO.getHraFinalRate());

        cell = row.createCell(11);
        cell.setCellValue(fairPayVO.getEducationRate());

        cell = row.createCell(12);
        cell.setCellValue(fairPayVO.getMedicalRate());

        cell = row.createCell(13);
        cell.setCellValue(fairPayVO.getOtherAllowanceRate());

        cell = row.createCell(14);
        cell.setCellValue(fairPayVO.getEarnedBasic());

        cell = row.createCell(15);
        cell.setCellValue(fairPayVO.getEarnedDa());

        cell = row.createCell(16);
        cell.setCellValue(fairPayVO.getEarnedHra());

        cell = row.createCell(17);
        cell.setCellValue(fairPayVO.getEarnedEducationAllowance());

        cell = row.createCell(18);
        cell.setCellValue(fairPayVO.getEarnedMedicalAllowance());

        cell = row.createCell(19);
        cell.setCellValue(fairPayVO.getEarnedOtherAllowance());

        cell = row.createCell(20);
        cell.setCellValue(fairPayVO.getEarnedOvertime());

        cell = row.createCell(21);
        cell.setCellValue(fairPayVO.getEarnedAttendanceBonus());

        cell = row.createCell(22);
        cell.setCellValue(fairPayVO.getEarnedProductionIncentive());

        cell = row.createCell(23);
        cell.setCellValue(fairPayVO.getEarnedGross());

        cell = row.createCell(24);
        cell.setCellValue(fairPayVO.getEsi0_75());

        cell = row.createCell(25);
        cell.setCellValue(fairPayVO.getPf12());

        cell = row.createCell(26);
        cell.setCellValue(fairPayVO.getProfTax());

        cell = row.createCell(27);
        cell.setCellValue(fairPayVO.getMlwf());

        cell = row.createCell(28);
        cell.setCellValue(fairPayVO.getAdvance());

        cell = row.createCell(29);
        cell.setCellValue(fairPayVO.getTotalDeduction());

        cell = row.createCell(30);
        cell.setCellValue(fairPayVO.getEarnedNetPay());

        return fairworkbook;
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public FairPayVO getFairPayVO() {
        FairPayVO fairPayVO = new FairPayVO();

        //TODO get Salary Master of the employee
        //SalaryMasterService sm = new SalaryMasterService();
        SalaryMaster esm = sm.getSalary("APSPL1037").get();
        System.out.println("$$$$$$$$$ ESM $$$$$$$$$$$ "+esm);

        fairPayVO.setEmployeeNo("APSPL1037");
        fairPayVO.setEsiNumber("ESIAPSPL1037");
        fairPayVO.setUan("UANAPSPL1037");
        fairPayVO.setGender("Male");
        fairPayVO.setName("Pralhad Bharat Ghosh");
        fairPayVO.setDaysInMonth(31);

        // Input fields to calculate fair pay slip
        fairPayVO.setPresentDays(25);
        fairPayVO.setBasicRate(esm.getHandEntryBasic());   //290.0); // TODO need to calculate
        fairPayVO.setDaRate(esm.getHandEntryFullDa());//194.0);
        fairPayVO.setHraFinalRate(esm.getHandEntryFullHra()); //24.5806);
        fairPayVO.setOtHours(47.00);

        fairPayVO.setEducationRate(39.00);
        fairPayVO.setMedicalRate(40.00);
        fairPayVO.setOtherAllowanceRate(235.00);

        fairPayVO.setEarnedEducationAllowance(975.00);
        fairPayVO.setEarnedMedicalAllowance(1000.00);
        fairPayVO.setEarnedOtherAllowance(5875.00);
        fairPayVO.setEarnedOvertime(5687.00);
        fairPayVO.setEarnedAttendanceBonus(0.00);
        fairPayVO.setEarnedProductionIncentive(10969.90);
        fairPayVO.setProfTax(200.00);
        fairPayVO.setMlwf(25.00);
        fairPayVO.setAdvance(2000.00);

        System.out.println("fairPayVO Earned Basic = " + fairPayVO.getEarnedBasic());
        System.out.println("fairPayVO Earned DA = " + fairPayVO.getEarnedDa());
        System.out.println("fairPayVO Earned HRA = " + fairPayVO.getEarnedHra());

        System.out.println("fairPayVO Earned Gross = " + fairPayVO.getEarnedGross());
        System.out.println("fairPayVO ESI = " + fairPayVO.getEsi0_75());
        System.out.println("fairPayVO PF = " + fairPayVO.getPf12());
        System.out.println("fairPayVO Total Deduction = " + fairPayVO.getTotalDeduction());
        System.out.println("fairPayVO Earned NetPay = " + fairPayVO.getEarnedNetPay());
        return fairPayVO;
    }
}
