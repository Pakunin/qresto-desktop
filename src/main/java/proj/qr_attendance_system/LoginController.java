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
        String db_password = passwordField.getText();

        if (!emailField.isVisible() && db_password != null && Objects.equals(db_password, "test")){
            SceneManager.changeScene(event, "AdminLogin.fxml");
        }
    }


}