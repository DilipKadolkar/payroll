package com.example.payroll.controller;

import com.example.payroll.entity.EmployeeAttendance;
import com.example.payroll.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Get all attendance records
    @GetMapping
    public ResponseEntity<List<EmployeeAttendance>> getAllAttendance() {
        List<EmployeeAttendance> attendanceRecords = attendanceRepository.findAll();
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

    // Get attendance record by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeAttendance> getAttendanceById(@PathVariable Long id) {
        Optional<EmployeeAttendance> attendanceRecord = attendanceRepository.findById(id);
        if (attendanceRecord.isPresent()) {
            return new ResponseEntity<>(attendanceRecord.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new attendance record
    @PostMapping
    public ResponseEntity<EmployeeAttendance> createAttendance(@RequestBody EmployeeAttendance attendance) {
        EmployeeAttendance savedAttendance = attendanceRepository.save(attendance);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    // Update an existing attendance record
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeAttendance> updateAttendance(@PathVariable Long id, @RequestBody EmployeeAttendance updatedAttendance) {
        Optional<EmployeeAttendance> attendanceRecord = attendanceRepository.findById(id);
        if (attendanceRecord.isPresent()) {
            updatedAttendance.setAttendanceID(id); // Ensure the ID is set
            EmployeeAttendance savedAttendance = attendanceRepository.save(updatedAttendance);
            return new ResponseEntity<>(savedAttendance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an attendance record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        if (attendanceRepository.existsById(id)) {
            attendanceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get attendance records by employee ID
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeAttendance>> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
        List<EmployeeAttendance> attendanceRecords = attendanceRepository.findByEmployeeID(employeeId);
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

    // Get attendance records by date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<EmployeeAttendance>> getAttendanceByDate(@PathVariable Date date) {
        List<EmployeeAttendance> attendanceRecords = attendanceRepository.findByAttendanceDate(date);
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

    //Get attendance records by date range
    @GetMapping("/dateRange")
    public ResponseEntity<List<EmployeeAttendance>> getAttendanceByDateRange(
            @RequestParam("startDate") Date startDate,
            @RequestParam("endDate") Date endDate) {
        List<EmployeeAttendance> attendanceRecords = attendanceRepository.findByAttendanceDateBetween(startDate, endDate);
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

    //Get attendance records by employee and date range
    @GetMapping("/employeeDateRange")
    public ResponseEntity<List<EmployeeAttendance>> getAttendanceByEmployeeDateRange(
            @RequestParam("employeeID") Long employeeID,
            @RequestParam("startDate") Date startDate,
            @RequestParam("endDate") Date endDate) {
        List<EmployeeAttendance> attendanceRecords = attendanceRepository.findByEmployeeIDAndAttendanceDateBetween(employeeID, startDate, endDate);
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

}