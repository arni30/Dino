import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game {
    public Group root = new Group();

    public void game(Stage primaryStage) {

        Scene gameScene = new Scene(root);
        Ground ground = new Ground(gameScene.getWidth());
        Dino dino = new Dino(primaryStage.getHeight());
        Obstacles obstacles = new Obstacles();

        root.getChildren().addAll(ground.ground, ground.ground1, dino.dinoRun, dino.dinoDown, obstacles.obstacles);
//        root.addEventHandler(DragEvent.DRAG_ENTERED,
//                new EventHandler<DragEvent>() {
//                    @Override
//                    public void handle(DragEvent) {
//                        Shape intersect = Shape.intersect(objectA, objectB);
//
//                        if (intersect.getBoundsInParent().getWidth() > 0) {
//                            label.setText("ObjectA intersects ObjectB");
//                        } else {
//                            label.setText("ObjectA does not intersect ObjectB");
//                        }
//                    };
//                });

        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.ENTER) {
                    dino.timelineRun.play();
                    ground.timeline.play();
                    obstacles.animation1.start();
                    obstacles.animation2.start();
                    obstacles.animation3.start();
                    obstacles.animation4.start();
                    obstacles.animation5.start();
                }
                if (key.getCode() == KeyCode.SPACE) {
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
    private void colision() {

    }
}
