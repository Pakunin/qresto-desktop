package proj.qr_attendance_system;

import javafx.fxml.FXML;

import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.util.Objects;

public class LoginController {
    @FXML
    private Button adminbt;

    @FXML
    private Button facultybt;

    @FXML
    private VBox loginForm;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginbt;


    @FXML
    public void initialize() {
        adminbt.setOnAction(e -> {
            emailField.setVisible(false);
            emailField.setManaged(false);
            passwordField.setPromptText("DB PASSWORD");
        });

        facultybt.setOnAction(e -> {
            emailField.setVisible(true);
            emailField.setManaged(true);
            passwordField.setPromptText("PASSWORD");
        });

        loginbt.setOnAction(this::LoginHandler);
    }

    private void LoginHandler(ActionEvent event){
        try {
            String db_password = passwordField.getText();
            String email = emailField.getText();

            if (!emailField.isVisible()){
                if (db_password.equals("qradmin")) {
                    SceneManager.changeScene(event, "AdminLogin.fxml");
                }
            } else if(emailField.isVisible() && passwordField.isVisible()) {
                String result = ApiClient.facultyLogin(email, db_password);
//                System.out.println(result);
                if(result.equals("success")){
                    SceneManager.changeScene(event, "FacultyLogin.fxml");
                }

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}