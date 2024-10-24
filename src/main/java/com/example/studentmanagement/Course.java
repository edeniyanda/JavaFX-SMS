package com.example.studentmanagement;

public class Course {
    private String courseCode;
    private String courseName;
    private int maximumCapacity;
    private int currentSize;
    private static int totalEnrolledStudents = 0;

    // Constructor
    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximumCapacity = maxCapacity;
        this.currentSize = 0;
    }

    // Getters (Important for JavaFX TableView PropertyValueFactory)
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    // Enroll a student in the course
    public void addStudent() {
        if (this.currentSize < this.maximumCapacity) {
            this.currentSize++;
            totalEnrolledStudents++;
            System.out.println("Student successfully enrolled!");
        } else {
            System.out.println("The course has reached its maximum capacity.");
        }
    }

    // Static method to retrieve the total number of students enrolled across all courses
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}
