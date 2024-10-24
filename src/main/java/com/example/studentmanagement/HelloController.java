package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

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

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToHomeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudentScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Get the controller
        HelloController controller = loader.getController();


        // Manually call the method to initialize the table
        controller.initializeStudentTable(); // This is critical!

        Scene scene = new Scene(root, 720, 590);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    public void initializeStudentTable() {
        System.out.println("Hello Bug");
        // Bind table columns to Student class properties
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        FNColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        LNColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        MobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        // Set the data to the table
        infoTable.setItems(studentList);

        // Add listener to TableView for row selection
        infoTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {  // Optional: Use double-click if desired
                populateTextFields();
            }
        });
    }

    // Populate text fields when a row is selected
    private void populateTextFields() {
        // Get the selected student from the table
        Student selectedStudent = infoTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            // Set the values in the text fields from the selected student
            txtFirstName.setText(selectedStudent.getFirstName());
            txtLastName.setText(selectedStudent.getLastName());
            txtMobileNumber.setText(selectedStudent.getMobileNumber());
            txtDepartment.setText(selectedStudent.getDepartment());
        }
    }

    // A separate initialization for the Welcome Scene
    public void initializeScene2() {
        // Initialize fields or logic for the second scene
        // someOtherField.setText("...");
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
            // Show alert for missing input
            showAlert(Alert.AlertType.WARNING, "Input Error", "All fields are required!");
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
            // Show alert for no selection
            showAlert(Alert.AlertType.WARNING, "Selection Error", "No student selected for deletion.");
        }
    }

    @FXML
    void Update(ActionEvent event) {
        // Get the selected student from the table
        Student selectedStudent = infoTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {

            // Get data from text fields
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String mobileNumber = txtMobileNumber.getText();
            String department = txtDepartment.getText();

            // Validate input
            if (firstName.isEmpty() || lastName.isEmpty() || mobileNumber.isEmpty() || department.isEmpty()) {
                // Show alert for missing input
                showAlert(Alert.AlertType.WARNING, "Input Error", "All fields are required!");
                return;
            }
            // Update the selected student's details
            selectedStudent.setFirstName(txtFirstName.getText());
            selectedStudent.setLastName(txtLastName.getText());
            selectedStudent.setMobileNumber(txtMobileNumber.getText());
            selectedStudent.setDepartment(txtDepartment.getText());

            // Refresh the table view to show updated data
            infoTable.refresh();
            clearFields();
        } else {
            // Show alert for no selection
            showAlert(Alert.AlertType.WARNING, "Selection Error", "No student selected for update.");
        }
    }

    private void clearFields() {
        // Clear the text fields
        txtFirstName.clear();
        txtLastName.clear();
        txtMobileNumber.clear();
        txtDepartment.clear();
    }

    // Utility method to show alert dialogs
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null); // No header for this dialog
        alert.setContentText(message);
        alert.showAndWait();
    }
}
