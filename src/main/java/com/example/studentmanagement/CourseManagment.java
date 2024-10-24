package com.example.studentmanagement;

import java.util.ArrayList;
import java.util.List;

class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    // Add a new course to the system
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        courses.add(new Course(courseCode, courseName, maxCapacity));
    }

    // Add a new student to the system
    public static void storeStudent(Student student) {
        students.add(student);
    }

    // Enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
    }

    // Assign a grade to a student for a specific course
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }


    // Retrieve the list of all courses
    public static List<Course> getCourses() {
        return courses;
    }

    // Retrieve the list of all students
    public static List<Student> getStudents() {
        return students;
    }

    // Find a course by its course code
    public static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    // Find a student by their ID
    public static Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}