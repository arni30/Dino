import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dino {
    final private Image dinoStandImg = new Image("Dino-stand.png");
    public ImageView ground2 = new ImageView(dinoStandImg);
    public Dino(double height) {
        ground2.setLayoutX(50);
        ground2.setLayoutY(height - 87 - dinoStandImg.getHeight());
        ground2.setViewport(new Rectangle2D(0, 0, 87, 93));
//        Animation animation = new Animation() {
//
//        }


    }
}
