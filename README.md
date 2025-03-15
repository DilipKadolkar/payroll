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


