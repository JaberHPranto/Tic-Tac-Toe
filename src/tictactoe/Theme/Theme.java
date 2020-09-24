package tictactoe.Theme;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public interface Theme {

    void getTheme(AnchorPane gameScene,String[] position,Button[] button, Line[] line);
    void setHumanPlayerStyle(Button button);
    void setAIPlayerStyle(Button button);
}
