package proj.qr_attendance_system;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        try {
            String email = FacultyEmailField.getText();
            String password = FacultyPasswordField.getText();

            String result = ApiClient.addFaculty(email, password);
            System.out.println("Backend response: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        try {
            String email = StudentEmailField.getText();
            String password = StudentPasswordField.getText();

            String result = ApiClient.addStudent(email, password);
            System.out.println("Backend response: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
