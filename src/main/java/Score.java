import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Score {
    public Label score;
    Timeline timelineScore;
    Integer timeSeconds = 0;
    public Score() {
        score = new Label();
        score.setText("Score: " + "00000");
        score.setLayoutX(715);
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

