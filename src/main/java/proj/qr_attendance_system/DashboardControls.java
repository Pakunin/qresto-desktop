package proj.qr_attendance_system;

import javafx.fxml.FXML;

import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.util.Objects;

public class DashboardControls {
    @FXML
    private Button logoutbt;

    @FXML
    public void initialize() {
        logoutbt.setOnAction(this::LogoutHandler);
    }

    private void LogoutHandler(ActionEvent event){
        SceneManager.changeScene(event, "loginPage.fxml");
    }
}
