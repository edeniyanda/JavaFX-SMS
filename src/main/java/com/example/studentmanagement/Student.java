package com.example.studentmanagement;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String department;

    public Student(int id, String firstName, String lastName, String mobileNumber, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.department = department;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
