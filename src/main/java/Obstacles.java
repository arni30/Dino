import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Obstacles {
    public ImageView cactus1;
    public ImageView cactus2;
    public ImageView cactus3;
    public ImageView cactus4;
    public ImageView cactus5;
    public AnimationTimer animation1;
    public AnimationTimer animation2;
    public AnimationTimer animation3;
    public AnimationTimer animation4;
    public AnimationTimer animation5;
    Group obstacles = new Group();

    public Obstacles() {
        cactus1 = new ImageView(new Image("Cactus-1.png"));
        cactus2 = new ImageView(new Image("Cactus-2.png"));
        cactus3 = new ImageView(new Image("Cactus-3.png"));
        cactus4 = new ImageView(new Image("Cactus-4.png"));
        cactus5 = new ImageView(new Image("Cactus-5.png"));
        obstacles.getChildren().addAll(cactus1, cactus2, cactus3, cactus4, cactus5);
        obstacles.setLayoutY(670);
        cactus1.setLayoutX(random() + 20);
        cactus2.setLayoutX(random() + 100);
        cactus3.setLayoutX(random() + 222);
        cactus4.setLayoutX(random() + 315);
        cactus5.setLayoutX(random() + 540);
        animation1 = animation(cactus1, cactus1.getLayoutX());
        animation2 = animation(cactus2, cactus2.getLayoutX());
        animation3 = animation(cactus3, cactus3.getLayoutX());
        animation4 = animation(cactus4, cactus4.getLayoutX());
        animation5 = animation(cactus5, cactus5.getLayoutX());
    }
    private double random() {
        return  800 + Math.random() * 3000;
    }
    public AnimationTimer animation(ImageView imgView, double layoutX) {

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                imgView.setTranslateX(imgView.getTranslateX() - 4);
                if (imgView.getTranslateX() < - layoutX - 150) {
                    imgView.setTranslateX(0);
                }
            }
        };
        return animation;
    }
}