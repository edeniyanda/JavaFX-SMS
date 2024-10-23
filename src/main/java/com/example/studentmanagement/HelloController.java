package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private TableColumn<Student, String> DepartmentColumn;

    @FXML
    private TableColumn<Student, String> FNColumn;

    @FXML
    private TableColumn<Student, Integer> IDColumn;

    @FXML
    private TableColumn<Student, String> LNColumn;

    @FXML
    private TableColumn<Student, String> MobileColumn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableView<Student> infoTable;

    @FXML
    private TextField txtDepartment;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtMobileNumber;

    // Observable list to hold student data
    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    // Counter to generate unique IDs
    private int studentIdCounter = 1;

    @FXML
    public void initialize() {
        // Bind table columns to Student class properties
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        FNColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        LNColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        MobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        // Set the data to the table
        infoTable.setItems(studentList);
    }

    @FXML
    void Add(ActionEvent event) {
        // Get data from text fields
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String mobileNumber = txtMobileNumber.getText();
        String department = txtDepartment.getText();

        // Validate input
        if (firstName.isEmpty() || lastName.isEmpty() || mobileNumber.isEmpty() || department.isEmpty()) {
            System.out.println("All fields are required!");
            return;
        }

        // Create a new student and add to the list
        Student newStudent = new Student(studentIdCounter++, firstName, lastName, mobileNumber, department);
        studentList.add(newStudent);

        // Clear input fields
        clearFields();
    }

    @FXML
    void Clear(ActionEvent event) {
        // Clear the input fields
        clearFields();
    }

    @FXML
    void Delete(ActionEvent event) {
        // Get the selected student from the table
        Student selectedStudent = infoTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentList.remove(selectedStudent);
        } else {
            System.out.println("No student selected for deletion.");
        }
    }

    @FXML
    void Update(ActionEvent event) {
        // Get the selected student from the table
        Student selectedStudent = infoTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            // Update the selected student's details
            selectedStudent.setFirstName(txtFirstName.getText());
            selectedStudent.setLastName(txtLastName.getText());
            selectedStudent.setMobileNumber(txtMobileNumber.getText());
            selectedStudent.setDepartment(txtDepartment.getText());

            // Refresh the table view to show updated data
            infoTable.refresh();
            clearFields();
        } else {
            System.out.println("No student selected for update.");
        }
    }

    private void clearFields() {
        // Clear the text fields
        txtFirstName.clear();
        txtLastName.clear();
        txtMobileNumber.clear();
        txtDepartment.clear();
    }
}
