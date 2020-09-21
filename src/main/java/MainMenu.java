import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {
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
    public void mainMenuRender(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Database m = new Database();
//        Mongo mongo = new Mongo("localhost", 27017);
//        MongoClient mongoClient = new MongoClient();
//        DB database = mongoClient.getDB("myMongoDb");
        dinoLable(root);
        buttonRender(primaryStage, root);
        Scene mainMenu = new Scene(root);
        root.setStyle("-fx-background-color: linear-gradient(from 50% 25% to 100% 100%, #fff, #661a33)");
        primaryStage.setScene(mainMenu);
    }

    private void dinoLable(BorderPane root) {
        Text dinoLable = new Text("Dino");

        dinoLable.setFont(Font.font("Apple Chancery", 150));
        dinoLable.setFill(Color.LIGHTCORAL);
        BorderPane.setAlignment(dinoLable, Pos.TOP_CENTER);
        root.setTop(dinoLable);
        dinoLable.setStyle("-fx-padding: 30px");
    }
    private void buttonRender(Stage primaryStage, BorderPane root) {
        VBox menuBox = new VBox();
        Button newGame = new Button();
        Button exit = new Button("Exit");
        newGame.setText("New Game");
        newGame.setStyle(buttons);
        newGame.setOnMouseEntered(e -> newGame.setStyle(buttonsHover));
        newGame.setOnMouseExited(e -> newGame.setStyle(buttons));
        exit.setStyle(buttons);
        exit.setOnMouseEntered(e -> exit.setStyle(buttonsHover));
        exit.setOnMouseExited(e -> exit.setStyle(buttons));
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.getChildren().add(newGame);
        newGame(newGame, primaryStage);
        exitGame(exit);
        menuBox.getChildren().add(exit);
        root.setCenter(menuBox);
        BorderPane.setMargin(menuBox, new Insets(50));
    }
    private void exitGame(Button exit) {
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });
    }
    private void newGame(Button newGame, Stage primaryStage) {
        newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Game game = new Game(primaryStage);
            }
        });
    }
}
