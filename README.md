# payroll

Install MySQL
https://dev.mysql.com/downloads/windows/installer/8.0.html
create user root/D!l!p1475

Add below properties to application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/alsama
spring.datasource.username=root
spring.datasource.password=D!l!p1475
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

create database alsama;

show databases;

use alsama

CREATE TABLE Employees (
    employeeID INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15),
    job_title VARCHAR(50),
    department VARCHAR(50),
    hire_date DATE,
    salary DECIMAL(10, 2),
    address_line1 VARCHAR(100),
    address_line2 VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(2),
    zip_code VARCHAR(10)
);


//working

CREATE TABLE Employee_Attendance (
attendance_ID INT PRIMARY KEY AUTO_INCREMENT,
employeeID INT,
attendance_Date DATE,
check_In_Time DATETIME,
check_Out_Time DATETIME,
attendance_Status VARCHAR(50),
notes TEXT,
overtime DECIMAL(5, 2) DEFAULT 0.00
);

DELIMITER //

CREATE TRIGGER CalculateOvertime
BEFORE INSERT ON Employee_Attendance
FOR EACH ROW
BEGIN
DECLARE totalHours DECIMAL(5, 2);

    SET totalHours = TIME_TO_SEC(TIMEDIFF(NEW.check_Out_Time, NEW.check_In_Time)) / 3600.0;

    IF totalHours > 10 THEN
        SET NEW.overtime = totalHours - 10;
    ELSE
        SET NEW.overtime = 0.00;
    END IF;
END //

DELIMITER ;