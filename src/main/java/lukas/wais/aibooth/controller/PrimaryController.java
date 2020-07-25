package lukas.wais.aibooth.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lukas.wais.aibooth.facerecognition.FaceRecognition;
import org.openimaj.image.ImageUtilities;

import java.awt.image.BufferedImage;

public class PrimaryController {
    @FXML
    private Button button;

    @FXML
    private ImageView currentFrame;

    @FXML
    void initialize() {
        Thread recognition = new Thread(() -> {
            // create buffered image
            FaceRecognition faceRecognition = new FaceRecognition();
            BufferedImage bufferedImage = ImageUtilities.createBufferedImage(faceRecognition.getVideo().getCurrentFrame());
            // convert to fx image
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            //  System.out.println(image);
            currentFrame.setImage(image);
        });
        recognition.start();
    }

    @FXML
    void startCamera(ActionEvent event) {
    }
}
