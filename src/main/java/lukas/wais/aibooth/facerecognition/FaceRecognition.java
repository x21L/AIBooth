package lukas.wais.aibooth.facerecognition;


import org.openimaj.image.MBFImage;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.capture.VideoCaptureException;

import javax.swing.*;


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

    public void start() {
        // Video listener
        display.addVideoListener(
                new VideoDisplayListener<>() {
                    public void beforeUpdate(MBFImage frame) {
                        // FaceDetector<KEDetectedFace, FImage> faceDetector = new FKEFaceDetector(30);
                        // faceDetector.detectFaces(frame.flatten()).parallelStream().forEach(face -> frame.drawShape(face.getBounds(), RGBColour.RED));
                    }

                    public void afterUpdate(VideoDisplay<MBFImage> display) {
                    }
                });
    }
}


