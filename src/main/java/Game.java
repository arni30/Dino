import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Game {
    public Pane root = new Pane();
    public void game(Stage primaryStage) {

        Scene gameScene = new Scene(root);
        Ground ground = new Ground(gameScene.getWidth());
        Obstacles obstacles = new Obstacles(root);
        Dino dino = new Dino(primaryStage.getHeight(), obstacles);
        Score score = new Score();
        root.getChildren().addAll(ground.ground, ground.ground1, dino.dinoRun, dino.dinoDown, score.score);
        root.setStyle("-fx-background-color: linear-gradient(from 50% 25% to 100% 100%, #fff, #661a33)");

        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.SPACE && score.timeSeconds == 0) {
                    dino.timelineRun.play();
                    dino.collision(obstacles,ground, dino, score);
                    ground.timeline.play();
                    obstacles.animationCactus.start();
                    score.timelineScore.play();
                    dino.dinoRun.setImage(dino.getImage());
                    dino.jumpTimer.start();
                }
                else if (key.getCode() == KeyCode.SPACE) {
                    dino.timelineRun.pause();
                    dino.dinoRun.setImage(dino.getImage());
                    dino.jumpTimer.start();
                }
                else if (key.getCode() == KeyCode.DOWN) {
                    dino.dinoRun.setVisible(false);
                    dino.dinoDown.setVisible(true);
                    dino.timelineDown.play();
                    dino.timelineRun.pause();
                }
            }
        });
        gameScene.addEventFilter(KeyEvent.KEY_RELEASED, key -> {
                    if (key.getCode() == KeyCode.DOWN) {
                        dino.dinoRun.setVisible(true);
                        dino.dinoDown.setVisible(false);
                        dino.timelineDown.pause();
                        dino.timelineRun.play();
                    }
                });
        primaryStage.setScene(gameScene);

    }
}
