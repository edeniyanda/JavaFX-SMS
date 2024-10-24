package com.example.studentmanagement;

public class Enrollment {
    private Student student;
    private Course course;
    private String grade;

    // Constructor
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = "Not Assigned"; // Default grade
    }

    // Getters and Setters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return student.getFirstName() + " " + student.getLastName() + " enrolled in " + course.getCourseName() + " - Grade: " + grade;
    }
}
