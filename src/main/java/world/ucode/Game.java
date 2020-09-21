package world.ucode;

import javafx.animation.Animation;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Game {
    final public Pane root = new Pane();
    final private Scene gameScene;
    final private Ground ground;
    final private Obstacles obstacles;
    final private Score score;
    final private Dino dino;
    final private Clouds clouds;

    public Game(Stage primaryStage) {
        gameScene = new Scene(root);
        ground = new Ground(gameScene.getWidth());
        obstacles = new Obstacles(root);
        score = new Score();
        clouds = new Clouds(root);
        dino = new Dino(obstacles, ground, score, primaryStage, clouds);
        game(primaryStage);

    }
    public void game(Stage primaryStage) {
        ImageView sun = new ImageView(new Image("Sun.png"));
        sun.setFitHeight(200);
        sun.setFitWidth(200);
        sun.setX(20);
        sun.setY(20);
        root.getChildren().addAll(ground.ground, ground.ground1,
                dino.dinoRun, dino.dinoDown, score.score, dino.gameOver.vBox, sun);
        root.setStyle("-fx-background-color: linear-gradient(from 1% 20% to 40% 55%, lightpink, #fff)");
        keyPressed();
        keyReleased();
        primaryStage.setScene(gameScene);

    }
    private void keyPressed() {
        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.SPACE && score.timeSeconds == 0) {
                    dino.timelineCollision.play();
                    dino.timelineRun.play();
                    ground.timeline.play();
                    obstacles.animationCactus.start();
                    score.timelineScore.play();
                    dino.dinoRun.setImage(dino.getImage());
                    dino.jumpTimer.start();
                    clouds.animation.start();
                } else if (key.getCode() == KeyCode.SPACE
                        && dino.timelineRun.getStatus() == Animation.Status.RUNNING) {
                    dino.timelineRun.pause();
                    dino.dinoRun.setImage(dino.getImage());
                    dino.jumpTimer.start();
                } else if (key.getCode() == KeyCode.DOWN
                        && dino.timelineRun.getStatus() == Animation.Status.RUNNING) {
                    dino.dinoRun.setVisible(false);
                    dino.dinoDown.setVisible(true);
                    dino.timelineDown.play();
                    dino.timelineRun.pause();
                }
            }
        });
    }

    private void keyReleased() {
        gameScene.addEventFilter(KeyEvent.KEY_RELEASED, key -> {
            if (key.getCode() == KeyCode.DOWN && dino.timelineDown.getStatus() == Animation.Status.RUNNING) {
                dino.dinoRun.setVisible(true);
                dino.dinoDown.setVisible(false);
                dino.timelineDown.pause();
                dino.timelineRun.play();
            }
        });
    }
}
