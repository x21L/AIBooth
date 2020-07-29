package lukas.wais.aibooth.controller;

import javafx.animation.AnimationTimer;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import lukas.wais.aibooth.facerecognition.FaceRecognition;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

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

//    private void setImage() {
//        // create buffered image
//        // System.out.println("fps: " + faceRecognition.getVideo().getFPS());
//        MBFImage frame = faceRecognition.getVideo().getCurrentFrame();
//
//        // TODO: add face detection for image
//
//        BufferedImage bufferedImage = ImageUtilities.createBufferedImage(frame);
//        // convert to fx image
//        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
//        currentFrame.setImage(image);
//    }

    private void setSwingComponent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setSize(640, 480);
            swingNode.setContent(panel);
            new FaceRecognition(panel);
        });
    }
}
