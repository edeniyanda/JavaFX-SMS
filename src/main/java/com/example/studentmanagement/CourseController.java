package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CourseController {

    @FXML
    private TableColumn<Course, String> CourseCodeCol;

    @FXML
    private TableColumn<Course, Integer> CourseSizeCol;

    @FXML
    private TableColumn<Course, String> CourseTitleCol;

    @FXML
    private Button btnHome;

    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TextField txtCourseCode;

    @FXML
    private TextField txtCourseTitle;

    @FXML
    private TextField txtMaxCap;

    // ObservableList to store course data
    private ObservableList<Course> courseList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind the columns to the Course class properties
        CourseTitleCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        CourseCodeCol.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        CourseSizeCol.setCellValueFactory(new PropertyValueFactory<>("currentSize"));

        // Set the data for the table
        courseTable.setItems(courseList);
    }

    @FXML
    void addCourse(ActionEvent event) {
        // Get input values from the text fields
        String courseTitle = txtCourseTitle.getText();
        String courseCode = txtCourseCode.getText();
        String maxCapacityStr = txtMaxCap.getText();

        // Validate input
        if (courseTitle.isEmpty() || courseCode.isEmpty() || maxCapacityStr.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "All fields are required!");
            return;
        }

        int maxCapacity;
        try {
            maxCapacity = Integer.parseInt(maxCapacityStr);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Max Capacity must be a number!");
            return;
        }

        // Create a new Course object and add it to the list
        Course newCourse = new Course(courseCode, courseTitle, maxCapacity);
        courseList.add(newCourse);

        // Clear the input fields after adding the course
        clearFields();

        // Refresh the table view to reflect the new course
        refreshTable();
    }

    private void clearFields() {
        txtCourseTitle.clear();
        txtCourseCode.clear();
        txtMaxCap.clear();
    }

    private void refreshTable() {
        courseTable.refresh(); // Refresh the table to reflect any changes
    }

    // Utility method to show alert dialogs
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
