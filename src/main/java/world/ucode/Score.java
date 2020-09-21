package world.ucode;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Score {
    public Label score;
    Timeline timelineScore;
    Integer timeSeconds = 0;
    public Score() {
        score = new Label();
        score.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
        score.setStyle("-fx-font-family:'Press Start 2P'; -fx-font-size: 15;" +
                " -fx-effect: dropshadow( gaussian , red , 1,1,1,1 );-fx-opacity: .3");
        score.setText("Score: " + "00000");
        score.setLayoutY(10);
        score.setLayoutX(620);
        timelineScore = new Timeline();
        timelineScore.setCycleCount(Timeline.INDEFINITE);

        timelineScore.getKeyFrames().add(
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                        @Override
                            public void handle(ActionEvent event) {
                                timeSeconds++;
                                String scoreStr = timeSeconds.toString();
                                String nulls = "";
                                for (int i = 5; i > scoreStr.length(); i--)
                                    nulls += "0";
                                score.setText("Score: " + nulls + scoreStr);
                            }
                        }));
    }
}

