package proj.qr_attendance_system;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class SceneManager {

    public static void changeScene(ActionEvent event, String fxmlFile) {


//        if (DBPass != null) {
            try{
                FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlFile));
                Parent root = loader.load();
                System.out.println("FXML loaded successfully!");
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setMaximized(true);

            } catch (IOException e) {
                e.printStackTrace();
//            }
        }
    }
}