import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Dino {
    public Timeline timelineRun;
    public Timeline timelineDown;
    final private Image dinoStandImg = new Image("Dino-stand.png");
    public ImageView ground2 = new ImageView(dinoStandImg);

    public Dino(double height) {
        ground2.setLayoutX(50);
        ground2.setY(height - 87 - dinoStandImg.getHeight());
        System.out.println(ground2.getY());
        animationDown("Dino-below-left-up.png", "Dino-below-right-up.png");
//        animationDown("Cactus-3.png", "Cactus-2.png");
        animationRun("Dino-stand.png", "Dino-right-up.png", "Dino-left-up.png");



    }

    public void animationRun(String img1, String img2, String img3) {
        timelineRun = new Timeline(new KeyFrame(Duration.millis(300),
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ground2.setImage(new Image(img1));
            }
        }), new KeyFrame(Duration.millis(400),
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ground2.setImage(new Image(img2));
            }
        }), new KeyFrame(Duration.millis(600),
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ground2.setImage(new Image(img3));
            }
        }));
        timelineRun.setCycleCount(Timeline.INDEFINITE);
        timelineRun.setRate(2);
    }
    public void animationDown(String img1, String img2) {
        timelineDown = new Timeline(new KeyFrame(Duration.millis(200),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        ground2.setImage(new Image(img1));
                    }
                }), new KeyFrame(Duration.millis(300),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        ground2.setImage(new Image(img2));
                    }
                }));
        timelineDown.setCycleCount(Timeline.INDEFINITE);
    }
}
