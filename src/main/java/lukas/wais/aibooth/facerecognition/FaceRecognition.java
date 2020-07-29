package lukas.wais.aibooth.facerecognition;

import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.colour.Transforms;
import org.openimaj.image.processing.edges.CannyEdgeDetector;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.FaceDetector;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.capture.VideoCaptureException;

import javax.swing.*;
import java.util.List;

/**
 * @author Lukas Wais
 */
public class FaceRecognition {
    Video<MBFImage> video;
    VideoDisplay<MBFImage> display;

    public FaceRecognition(JComponent frame) {
        try {
            this.video = new VideoCapture(640, 480);
            this.display = VideoDisplay.createVideoDisplay(video, frame);
        } catch (VideoCaptureException ex) {
            System.out.println("Error during video capture \n" + ex.getMessage());
        }
    }

    public FaceRecognition() {
        try {
            this.video = new VideoCapture(640, 480);
            this.display = VideoDisplay.createVideoDisplay(video);
        } catch (VideoCaptureException ex) {
            System.out.println("Error during video capture \n" + ex.getMessage());
        }
    }

    public Video<MBFImage> getVideo() {
        return video;
    }

    public VideoDisplay<MBFImage> getDisplay() {
        return display;
    }

    public void play() {
        // Video listener
        display.addVideoListener(
                new VideoDisplayListener<>() {
                    public void beforeUpdate(MBFImage frame) {

                        FaceDetector<DetectedFace, FImage> fd = new HaarCascadeDetector(40);
                        List<DetectedFace> faces = fd.detectFaces(Transforms.calculateIntensity(frame));
                        for (DetectedFace face : faces) {
                            frame.drawShape(face.getBounds(), RGBColour.RED);
                        }
                    }

                    public void afterUpdate(VideoDisplay<MBFImage> display) {
                    }
                });
    }

    public static void main(String[] args) {
        new FaceRecognition().play();
    }
}


