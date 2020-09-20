import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOverMenu {
    public String buttonsHover = "-fx-background-color: transparent;" +
            "-fx-font-family: 'Apple Chancery';" +
            " -fx-font-size: 50px;" +
            " -fx-opacity: .3;" +
            "-fx-padding: 0";
    public String buttons = "-fx-background-color: transparent;" +
            "-fx-font-family: 'Apple Chancery';" +
            " -fx-font-size: 50px;" +
            " -fx-opacity: .3;" +
            "-fx-effect: dropshadow( gaussian , red , 1,1,1,1 );" +
            "-fx-padding: 0";
    public VBox vBox;

    public GameOverMenu(Stage primaryStage) {
        gamOver(primaryStage);
    }
    private void gamOver(Stage primaryStage) {
        Button restart = new Button("Restart");
        Button exit = new Button("Main Menu");
        vBox = new VBox(restart, exit);
        restart.setStyle(buttons);
        exit.setStyle(buttons);
        restart.setOnMouseEntered(e -> restart.setStyle(buttonsHover));
        restart.setOnMouseExited(e -> restart.setStyle(buttons));
        exit.setOnMouseEntered(e -> exit.setStyle(buttonsHover));
        exit.setOnMouseExited(e -> exit.setStyle(buttons));

        vBox.setLayoutY(225);
        vBox.setLayoutX(250);
        vBox.setAlignment(Pos.CENTER);
        vBox.setOpacity(0);
        newGame(restart, primaryStage);
        mainMenu(exit, primaryStage);
    }
    public void buttonsShow() {
        KeyValue initKeyValue = new KeyValue(vBox.opacityProperty(), 0.0);
        KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);
        KeyValue endKeyValue = new KeyValue(vBox.opacityProperty(), 1.0);
        KeyFrame endFrame = new KeyFrame(Duration.seconds(3), endKeyValue);
        // Create a Timeline object
        Timeline timelineShow = new Timeline(initFrame, endFrame);
        // Let the animation run forever
        timelineShow.setCycleCount(1);
        // Start the animation
        timelineShow.play();
    }
    private void newGame(Button restart, Stage primaryStage) {
        restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (vBox.getOpacity() > 0) {
                    Game game = new Game(primaryStage);
                }
            }
        });
    }
    private void mainMenu(Button exit, Stage primaryStage) {
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (vBox.getOpacity() > 0) {
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.mainMenuRender(primaryStage);
                }
            }
        });
    }
}
