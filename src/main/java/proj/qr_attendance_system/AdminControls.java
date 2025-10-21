package proj.qr_attendance_system;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminControls {
    @FXML
    private Button logoutbt;

    @FXML
    public void initialize() {
        logoutbt.setOnAction(this::LogoutHandler);
    }

    private void LogoutHandler(ActionEvent event){
        SceneManager.changeScene(event, "loginPage.fxml");
    }

    @FXML
    private TextField FacultyEmailField;
    @FXML
    private PasswordField FacultyPasswordField;
    @FXML
    private TextField StudentEmailField;
    @FXML
    private PasswordField StudentPasswordField;

    public void addFaculty() {
        String email = FacultyEmailField.getText();
        String password = FacultyPasswordField.getText();
        addUser("faculty_data", email, password);
    }

    public void addStudent() {
        String email = StudentEmailField.getText();
        String password = StudentPasswordField.getText();
        addUser("student_data", email, password);
    }

    private void addUser(String table, String email, String password) {
        System.out.println("Email: " + email + ", Password: " + password);


        String query = "INSERT INTO " + table + " (email, password) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(true);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.executeUpdate();
            System.out.println("Insert successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
