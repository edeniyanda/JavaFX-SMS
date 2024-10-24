package com.example.studentmanagement;

public class Enrollment {
    private Student student;
    private Course course;

    // Constructor
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return student.getFirstName() + " " + student.getLastName() + " enrolled in " + course.getCourseName();
    }
}
