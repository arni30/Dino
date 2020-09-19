import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class Dino {
    public VBox vBox;
    public Timeline timelineRun;
    public Timeline timelineDown;
    public Timeline collision;
    public TranslateTransition timelineJumpUp;
    public TranslateTransition timelineJumpDown;
    public AnimationTimer jumpTimer;

    final private Image dinoStandImg = new Image("Dino-stand.png");
    final private Image dinoDownImg = new Image("Dino-below-right-up.png");
    public ImageView dinoRun = new ImageView(dinoStandImg);
    public ImageView dinoDown = new ImageView(dinoDownImg);

    public Dino(double height, Obstacles obstacles) {
        dinoRun.setX(50);
        dinoRun.setY(height - 85 - dinoStandImg.getHeight());
        dinoDown.setVisible(false);
        dinoDown.setX(50);
        dinoDown.setY(685);
        animationDown("Dino-below-left-up.png", "Dino-below-right-up.png");
        animationRun("Dino-stand.png", "Dino-right-up.png", "Dino-left-up.png");
        animationJumpUp();
    }

    public void animationRun(String img1, String img2, String img3) {
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

    public void animationDown(String img1, String img2) {
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

    public void animationJumpUp() {
        double ypreviousPos = dinoRun.getTranslateY();
        jumpTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                dinoRun.setTranslateY(dinoRun.getTranslateY() - 18 + gravity);
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

    public void collision(Obstacles obstacles, Ground ground, Dino dino, Score score) {
        collision = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (ImageView i : obstacles.imageList)
//                if (dinoRun.getBoundsInParent().intersects(i.getBoundsInParent())) {
                if (dinoRun.getBoundsInParent().intersects(i.getLayoutX() +10, i.getLayoutY()+10, i.getBoundsInParent().getWidth() - 10, i.getBoundsInParent().getHeight() - 10)) {
//                    System.out.println("ObjectA intersects ObjectB");
                    obstacles.animationCactus.stop();
                    ground.timeline.stop();
                    dino.timelineRun.stop();
                    score.timelineScore.stop();
//                    Button restart = new Button("Restart");
//                    restart.setMinWidth(400);
//                    restart.setStyle("-fx-background-color: transparent;" +
//                            " -fx-font-family: 'Apple Chancery';" +
//                            " -fx-font-size: 50px;" +
//                            " -fx-opacity: .3;");
//                    Button exit = new Button("Main Menu");
//                    vBox = new VBox(restart, exit);
//                    vBox.setAlignment(Pos.CENTER);
                }

            }
        }));
        collision.setCycleCount(Timeline.INDEFINITE);
        collision.play();
    }
}
