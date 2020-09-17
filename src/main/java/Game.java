import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game {
    final private Group root = new Group();

    public void game(Stage primaryStage) {

        Scene gameScene = new Scene(root);
        Ground ground = new Ground(gameScene.getWidth());
        Dino dino = new Dino(primaryStage.getHeight());
        Rectangle2D rectangle2D = new Rectangle2D(0, 0, 64, 64);
        root.getChildren().addAll(ground.ground, ground.ground1, dino.ground2);
        primaryStage.setScene(gameScene);

    }
//    @Override
//    public void keyPressed(KeyEvent e){
//        if (e.getKeyCode()==KeyEvent.VK_SPACE) {
//
//        }
//    }
}
