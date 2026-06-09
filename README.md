# 🏥 Hospital Management System

A console-based Hospital Management System developed using **Java, JDBC, and MySQL**. This project demonstrates how Java applications interact with relational databases using JDBC by implementing basic hospital operations.

## 📖 Overview

The Hospital Management System is designed to manage hospital records through a menu-driven console application. It allows users to perform CRUD operations and appointment management while maintaining data in a MySQL database.

This project was built as a learning project to strengthen concepts of:
- Java Programming
- JDBC Connectivity
- SQL Queries
- Database Management
- Object-Oriented Programming

---

## ✨ Features

- ➕ Add New Patients
- 👨‍⚕️ View Doctor Details
- 👥 View Patient Records
- 📅 Book Appointments
- ✔️ Check Doctor Availability
- 🔐 Secure database operations using Prepared Statements
- 🚪 Exit application safely by closing database connections

---

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- MySQL Connector/J
- VS Code

---

## 📂 Project Structure

Hospital-management-system-project-in-java-based-on-JDBC/
│
├── lib/
│ └── mysql-connector-j.jar
│
├── src/
│ ├── Doctor.java
│ ├── Patient.java
│ ├── HospitalManagementSystem.java
│ └── Appointment.java
│
├── README.md
└── .gitignore

---

## 🗄️ Database Setup

### Create Database

```sql
CREATE DATABASE hospital;
```

### Use Database

```sql
USE hospital;
```

### Patients Table

```sql
CREATE TABLE patients(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(20) NOT NULL
);
```

### Doctors Table

```sql
CREATE TABLE doctors(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);
```

### Appointments Table

```sql
CREATE TABLE appointments(
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    FOREIGN KEY(patient_id) REFERENCES patients(id),
    FOREIGN KEY(doctor_id) REFERENCES doctors(id)
);
```

---

## ⚙️ Configuration

Update your MySQL credentials inside the Java code:

```java
private static final String url = "jdbc:mysql://localhost:3306/hospital";
private static final String username = "your_username";
private static final String password = "your_password";
```

---

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Gaurav-mandage-1718/Hospital-management-system-project-in-java-based-on-JDBC.git
```

### 2. Open the Project

Open the project using VS Code, IntelliJ IDEA, or Eclipse.

### 3. Add JDBC Driver

Add MySQL Connector/J to the project classpath.

### 4. Compile the Project

```bash
javac -cp ".;lib/mysql-connector-j.jar" src/*.java
```

### 5. Run the Application

```bash
java -cp ".;lib/mysql-connector-j.jar;src" HospitalManagementSystem
```

---

## 📋 Sample Menu

```text
===== Hospital Management System =====

1. Add Patient
2. View Patients
3. View Doctors
4. Book Appointment
5. Exit

Enter your choice:
```

---

## 🎯 Learning Outcomes

Through this project, I learned:

- JDBC Architecture
- Java-MySQL Integration
- CRUD Operations
- Prepared Statements
- SQL Query Execution
- Exception Handling
- Menu-Driven Console Applications

---

## 🚀 Future Enhancements

- Update Patient Records
- Delete Patient Records
- Search Functionality
- Billing Module
- Authentication System
- GUI using Java Swing
- Web Version using Spring Boot

---

## 👨‍💻 Author

**Gaurav Mandage**

Final Year Engineering Student passionate about Java Backend Development.

GitHub:
https://github.com/Gaurav-mandage-1718

---

⭐ If you found this project useful, please consider giving it a Star.
