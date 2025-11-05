package proj.qr_attendance_system;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FacultyControls {
    @FXML
    private Button logoutbt;

    @FXML
    private TextField courseCodeField;

    @FXML
    private TextField courseNameField;

    @FXML
    private ImageView qrImageView;

    @FXML
    private Button generateQRButton;

    @FXML
    private void initialize() {
        generateQRButton.setOnAction(e -> generateQR());
        logoutbt.setOnAction(this::LogoutHandler);
    }

    private void LogoutHandler(ActionEvent event){
        SceneManager.changeScene(event, "loginPage.fxml");
    }

    private void generateQR() {
        String courseCode = courseCodeField.getText();
        String courseName = courseNameField.getText();

        if (courseCode.isEmpty() || courseName.isEmpty()) {
            System.out.println("Course code is empty");
            return;
        }

        String qrData = courseName + ":" + courseCode;

        try{
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrData, BarcodeFormat.QR_CODE, 250, 250);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", java.nio.file.Paths.get("qr_" + courseCode + ".png"));
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            Image fxImage = SwingFXUtils.toFXImage(qrImage, null);
            qrImageView.setImage(fxImage);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}