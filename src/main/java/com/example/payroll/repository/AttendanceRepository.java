package com.example.payroll.repository;

import com.example.payroll.entity.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {
    List<EmployeeAttendance> findByEmployeeID(Long employeeID);
    List<EmployeeAttendance> findByAttendanceDate(Date attendanceDate);
    List<EmployeeAttendance> findByAttendanceDateBetween(Date startDate, Date endDate);
    List<EmployeeAttendance> findByEmployeeIDAndAttendanceDateBetween(Long employeeID, Date startDate, Date endDate);
}