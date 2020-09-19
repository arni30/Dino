import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Obstacles {
    public Image cactus1;
    public Image cactus2;
    public Image cactus3;
    public Image cactus4;
    public Image cactus5;
    public ImageView cactus;
    public AnimationTimer animationCactus;
    ArrayList<ImageView> imageList;

    public Obstacles(Pane root) {
        cactus1 = new Image("Cactus-1.png");
        cactus2 = new Image("Cactus-2.png");
        cactus3 = new Image("Cactus-3.png");
        cactus4 = new Image("Cactus-4.png");
        cactus5 = new Image("Cactus-5.png");
        ArrayList <Image> images = new ArrayList<Image>();
        images.add(cactus1);
        images.add(cactus2);
        images.add(cactus3);
        images.add(cactus4);
        images.add(cactus5);
        imageList = new ArrayList<ImageView>();
        double rand = 0;
        for (int i =0; i < 5; i++) {
            cactus = new ImageView();
            cactus.setImage(images.get(i));
            cactus.setLayoutY(670);
             rand = random();
            System.out.println(rand);
            cactus.setLayoutX(rand);
            root.getChildren().addAll(cactus);
            imageList.add(cactus);
        }
        cactus = imageList.get((int)(Math.random() * 5));
        animationCactus = animation();
    }
    private double random() {
        double result = 800 + (int)(Math.random() * 15) * 100;
        System.out.println(result);

        for (ImageView y : imageList) {
            if (Math.abs(result - y.getLayoutX()) < 150)
                result += 1600;
        }

        return result;
    }
    public AnimationTimer animation() {

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (ImageView i : imageList) {
                    i.setLayoutX(i.getLayoutX() - 4);
                    if (i.getLayoutX() < -50) {
//                        cactus = imageList.get((int) (Math.random() * 5));
                        i.setLayoutX(random());
                    }
                }
            }
        };
        return animation;
    }
}