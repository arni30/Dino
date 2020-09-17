import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dino");
        primaryStage.setResizable(true);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenuRender(primaryStage);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}