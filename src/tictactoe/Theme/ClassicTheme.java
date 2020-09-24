package tictactoe.Theme;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ClassicTheme implements Theme {
    @Override
    public void getTheme(AnchorPane gameScene,String[] position,Button[] button, Line[] line) {

        for(int i=1;i<=4;i++){
            line[i].setStroke(Color.BLACK);
        }

        gameScene.setStyle("-fx-background-color: white");

        // changing all the buttons that are already present on the board
        for(int i=1;i<=9;i++){
            if(position[i].equals("X"))setHumanPlayerStyle(button[i]);
            else if(position[i].equals("O"))setAIPlayerStyle(button[i]);
            button[i].setGraphic(null);
        }
    }

    @Override
    public void setHumanPlayerStyle(Button button) {
        button.setStyle("-fx-background-color: white");
        button.setText("X");
    }

    @Override
    public void setAIPlayerStyle(Button button) {
         button.setStyle("-fx-background-color: white");
         button.setText("O");
    }

}
