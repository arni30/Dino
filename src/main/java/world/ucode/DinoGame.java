package world.ucode;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DinoGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dino");
        primaryStage.getIcons().add(new Image("Dino-stand.png"));
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