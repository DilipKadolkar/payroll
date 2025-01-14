package com.example.payroll.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class DownloadExcelController {

    @GetMapping("/downloadExcel")
    public ResponseEntity<byte[]> downloadExcel(@RequestParam String company,@RequestParam String month) throws IOException {
        // Create a workbook and a sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Payroll Statement");

        // Create a row and put some cells in it
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Employee ID");
        headerRow.createCell(1).setCellValue("Employee Name");
        headerRow.createCell(2).setCellValue("Salary");

        // Add some sample data
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("1");
        dataRow.createCell(1).setCellValue("John Doe");
        dataRow.createCell(2).setCellValue("5000");

        // Write the output to a byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        workbook.close();

        // Create the response entity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", company + "_Payroll_Statement.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(bos.toByteArray());
    }
}