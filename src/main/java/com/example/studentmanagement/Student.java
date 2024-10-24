package com.example.studentmanagement;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String department;
    private Map<Course, Double> enrolledCourses;

    public Student(int id, String firstName, String lastName, String mobileNumber, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.department = department;
        this.enrolledCourses = new HashMap<>();
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

    // Enroll in a course
    public void enrollInCourse(Course course) {
        if (!this.enrolledCourses.containsKey(course)) {
            course.addStudent();
            enrolledCourses.put(course, null);  // Initialize grade as null
        } else {
            System.out.println("Student already enrolled in this course.");
        }
    }

    // Assign a grade for a specific course
    public void assignGrade(Course course, Double grade) {
        if (this.enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
        } else {
            System.out.println("Student is not enrolled in the course: " + course.getCourseName());
        }
    }

    // Retrieve the enrolled courses and grades
    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }
}
