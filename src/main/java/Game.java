import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
        root.getChildren().addAll(ground.ground, ground.ground1, dino.ground2);
        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.SPACE) {
                    dino.timelineRun.play();
                    ground.timeline.play();
                }
                else if (ke.getCode() == KeyCode.DOWN) {
                    dino.timelineRun.stop();
                    dino.timelineDown.play();
//                    dino.ground2.setY(685);


                }
            }
        });
        gameScene.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
                    if (event.getCode() == KeyCode.DOWN) {
//                        dino.ground2.setLayoutY(668);
                        dino.timelineDown.stop();
                        dino.timelineRun.play();

                    }
                });

        primaryStage.setScene(gameScene);

    }
//    @Override
//    public void keyPressed(KeyEvent e){
//        if (e.getKeyCode()==KeyEvent.VK_SPACE) {
//
//        }
//    }
}
