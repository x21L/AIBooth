package lukas.wais.aibooth.controller;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import lukas.wais.aibooth.facerecognition.FaceRecognition;
import org.openimaj.image.FImage;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.processing.face.detection.CCDetectedFace;
import org.openimaj.image.processing.face.detection.FaceDetector;
import org.openimaj.image.processing.face.detection.SandeepFaceDetector;
import org.openimaj.image.processing.face.tracking.FaceTracker;
import org.openimaj.image.processing.face.tracking.KLTHaarFaceTracker;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrimaryController {
    // private final FaceRecognition faceRecognition = new FaceRecognition();
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button button;

    @FXML
    private ImageView currentFrame;

    @FXML
    void initialize() {
        // create SwingNode
        SwingNode swingNode = new SwingNode();
        setSwingComponent(swingNode);
        borderPane.setCenter(swingNode);
        // animation timer
//        new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                setImage();
//            }
//        }.start();
    }

    @FXML
    void startCamera(ActionEvent event) {
    }

    private void setSwingComponent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            // panel.setSize(640, 480);
            swingNode.setContent(panel);
            // startDetection(new FaceRecognition(panel));
            // startDetection(new FaceRecognition(panel));
            new FaceRecognition(panel);
        });
    }
}
