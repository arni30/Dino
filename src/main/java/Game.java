import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game {
    public void game(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Image image = new Image("Ground.png");
        ImageView ground = new ImageView(image);
        BorderPane.setMargin(ground, new Insets(0, 0 , 50, 0));
        root.setBottom(ground);
        Scene gameScene = new Scene(root);
        double sceneWidth = gameScene.getWidth();
        double textWidth = image.getWidth();

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.seconds(5);

            KeyValue startKeyValue = new KeyValue(ground.translateXProperty(), 0);
            KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
            KeyValue endKeyValue = new KeyValue(ground.translateXProperty(), -1.0 * textWidth);
            KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

            // Create a Timeline
            Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);
            // Let the animation run forever
            timeline.setCycleCount(Timeline.INDEFINITE);
            // Run the animation
            timeline.play();

        primaryStage.setScene(gameScene);
    }
}
