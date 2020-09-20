import javafx.application.Application;
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