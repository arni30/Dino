import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Clouds {
    public AnimationTimer animation;
    ImageView cloud;
    public Clouds(Pane root) {
        animation(root);
    }
    private double random(ArrayList<ImageView> images) {
        double result = 800 + (int)(Math.random() * 15) * 100;
        System.out.println(result);

        for (ImageView y : images) {
            if (Math.abs(result - y.getLayoutX()) < 150)
                result += 1600;
        }

        return result * 1.5;
    }
    public AnimationTimer animation(Pane root) {
        Image cloudImg = new Image("cloud.png");
        ArrayList<ImageView> images = new ArrayList<ImageView>();
        for (int i =0; i < 5; i++) {
            ImageView cloud = new ImageView(cloudImg);
            cloud.setFitHeight(50);
            cloud.setFitWidth(70);
            cloud.setLayoutX(800);
            cloud.setLayoutY(130);
            cloud.setStyle("-fx-effect: dropshadow( gaussian , lightcoral , 1, 1, 1, 1);");
            images.add(cloud);
            root.getChildren().add(cloud);
        }
        animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (ImageView i : images) {
                    i.setLayoutX(i.getLayoutX() - 1);
                    if (i.getLayoutX() < -50) {
                        i.setLayoutX(random(images));
                        i.setLayoutY(100 + (int)(Math.random() * 30));
                    }
                }
            }
        };
        return animation;
    }
}
