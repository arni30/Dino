import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Ground {
    public ImageView ground;
    public ImageView ground1;
    final private double sceneWidth;
    final private double imgWidth;
    public Timeline timeline;

    public Ground(double width) {
        Image groundImg = new Image("Ground.png");

        this.ground = new ImageView(groundImg);
        this.ground1 = new ImageView(groundImg);
        this.sceneWidth = width;
        this.imgWidth = groundImg.getWidth();
        ground1.setLayoutY(700);
        ground.setLayoutY(700);
        animation();
    }
    public void animation() {
        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.seconds(5);
        System.out.println(sceneWidth);

        KeyValue startKeyValue = new KeyValue(ground.translateXProperty(), sceneWidth);
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(ground.translateXProperty(), -1.0 * imgWidth);
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        KeyValue startKeyValue1 = new KeyValue(ground1.translateXProperty(), imgWidth);
        KeyFrame startKeyFrame1 = new KeyFrame(startDuration, startKeyValue1);
        KeyValue endKeyValue1 = new KeyValue(ground1.translateXProperty(), -1.0 * sceneWidth);
        KeyFrame endKeyFrame1 = new KeyFrame(endDuration, endKeyValue1);

        timeline = new Timeline(startKeyFrame, endKeyFrame, startKeyFrame1, endKeyFrame1);

        timeline.setCycleCount(Timeline.INDEFINITE);
    }

}

