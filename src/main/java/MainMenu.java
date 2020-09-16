import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu {
    public void mainMenuRender(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Label dinoLable = new Label("Dino");
        dinoLable.setFont(Font.font(100));
        BorderPane.setAlignment(dinoLable, Pos.TOP_CENTER);
        root.setTop(dinoLable);
        dinoLable.setStyle("-fx-padding: 30px");


        VBox menuBox = new VBox();
        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setFont(Font.font("Arial Italic",50));
        newGame.setMinWidth(400);
        newGame.setStyle("-fx-background-color: transparent;" +
                " -fx-font-family: 'Apple Chancery';" +
                " -fx-font-size: 50px;" +
                " -fx-opacity: .3;");
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.getChildren().add(newGame);
        newGame(newGame, primaryStage);
        root.setCenter(menuBox);
//        BorderPane.setAlignment(menuBox, Pos.TOP_CENTER);
        BorderPane.setMargin(menuBox, new Insets(50));

        Scene mainMenu = new Scene(root);
        root.setStyle("-fx-background-color: linear-gradient(from 50% 25% to 100% 100%, #fff, #661a33)");
        primaryStage.setScene(mainMenu);
    }

    private void newGame(Button newGame, Stage primaryStage) {
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game game = new Game();
                game.game(primaryStage);
            }
        });
    }
}
