package lukas.wais.aibooth.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lukas.wais.aibooth.facerecognition.FaceRecognition;

public class PrimaryController {
    @FXML
    private Button button;

    @FXML
    private ImageView currentFrame;

    @FXML
    void initialize() {
        FaceRecognition faceRecognition = new FaceRecognition();
     //   Image image = SwingFXUtils.toFXImage(faceRecognition.play().getDisplayedImage(), null);
      //  System.out.println(image);
        // currentFrame.setImage(image);
    }

    @FXML
    void startCamera(ActionEvent event) {
    }
}
