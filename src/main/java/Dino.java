import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Dino {
    public GameOverMenu gameOver;
    public Timeline timelineRun;
    public Timeline timelineDown;
    public Timeline timelineCollision;
    public AnimationTimer jumpTimer;

    final private Image dinoStandImg = new Image("Dino-stand.png");
    final private Image dinoDownImg = new Image("Dino-below-right-up.png");
    public ImageView dinoRun = new ImageView(dinoStandImg);
    public ImageView dinoDown = new ImageView(dinoDownImg);

    public Dino(Obstacles obstacles, Ground ground, Score score, Stage primaryStage, Clouds clouds) {
        gameOver = new GameOverMenu(primaryStage);
        dinoRun.setX(50);
        dinoRun.setY(primaryStage.getHeight() - 85 - dinoStandImg.getHeight());
        dinoDown.setVisible(false);
        dinoDown.setX(50);
        dinoDown.setY(685);
        dinoRun.setStyle("-fx-effect: dropshadow( gaussian , lightcoral , 0.1,0.1,0.1,0.1 );");
        animationDown("Dino-below-left-up.png", "Dino-below-right-up.png");
        animationRun("Dino-stand.png", "Dino-right-up.png", "Dino-left-up.png");
        animationJumpUp();
        collision(obstacles, ground, score, clouds);
    }



    private void animationRun(String img1, String img2, String img3) {
        timelineRun = new Timeline(new KeyFrame(Duration.millis(300),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        dinoRun.setImage(new Image(img1));
                    }
                }), new KeyFrame(Duration.millis(400),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        dinoRun.setImage(new Image(img2));
                    }
                }), new KeyFrame(Duration.millis(600),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        dinoRun.setImage(new Image(img3));
                    }
                }));
        timelineRun.setCycleCount(Timeline.INDEFINITE);
        timelineRun.setRate(2.5);
    }

    private void animationDown(String img1, String img2) {
        timelineDown = new Timeline(new KeyFrame(Duration.millis(400),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        dinoDown.setImage(new Image(img1));
                    }
                }), new KeyFrame(Duration.millis(600),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        dinoDown.setImage(new Image(img2));
                    }
                }));
        timelineDown.setCycleCount(Timeline.INDEFINITE);
        timelineDown.setRate(2.5);
    }

    double gravity = 0;

    private void animationJumpUp() {
        double ypreviousPos = dinoRun.getTranslateY();
        jumpTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                dinoRun.setTranslateY(dinoRun.getTranslateY() - 16 + gravity);
                gravity = gravity + 1;
                if (ypreviousPos == dinoRun.getTranslateY()) {
                    timelineRun.play();
                    jumpTimer.stop();
                    gravity = 0;
                }
            }

        };
    }

    public Image getImage() {
        return dinoStandImg;
    }

    private void collision(Obstacles obstacles, Ground ground, Score score, Clouds clouds) {
        timelineCollision = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (score.timeSeconds != 0 && score.timeSeconds % 100 == 0) {
                    ground.timeline.setRate(ground.timeline.getRate() + 0.0001);
                    obstacles.speed += 0.0004;

                }
                for (ImageView i : obstacles.imageList) {
                    if (dinoRun.getBoundsInParent().intersects(i.getLayoutX() + 10, i.getLayoutY() + 10,
                            i.getBoundsInParent().getWidth() - 15,
                            i.getBoundsInParent().getHeight() - 15)) {
                        obstacles.animationCactus.stop();
                        ground.timeline.stop();
                        timelineDown.stop();
                        jumpTimer.stop();
                        timelineRun.stop();
                        timelineCollision.stop();
                        score.timelineScore.stop();
                        gameOver.buttonsShow();
                        clouds.animation.stop();
                    }
                }

            }
        }));
        timelineCollision.setCycleCount(Timeline.INDEFINITE);
        timelineCollision.play();
    }
}
