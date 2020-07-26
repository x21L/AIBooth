package lukas.wais.aibooth.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lukas.wais.aibooth.facerecognition.FaceRecognition;
import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.colour.Transforms;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.FaceDetector;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PrimaryController {
    private final FaceRecognition faceRecognition = new FaceRecognition();
    @FXML
    private Button button;

    @FXML
    private ImageView currentFrame;

    @FXML
    void initialize() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                setImage();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0L, 1L);
    }

    @FXML
    void startCamera(ActionEvent event) {
        setImage();
    }

    private void setImage() {
        // create buffered image
        // System.out.println("fps: " + faceRecognition.getVideo().getFPS());
        MBFImage frame = faceRecognition.getVideo().getCurrentFrame();

        // TODO: add face detection for image

        BufferedImage bufferedImage = ImageUtilities.createBufferedImage(frame);
        // convert to fx image
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        currentFrame.setImage(image);
    }
}
