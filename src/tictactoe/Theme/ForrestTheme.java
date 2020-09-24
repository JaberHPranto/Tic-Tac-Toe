package tictactoe.Theme;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ForrestTheme implements Theme {
    @Override
    public void getTheme(AnchorPane gameScene,String[] position,Button[] button, Line[] line){
        for(int i=1;i<=4;i++){
            line[i].setStroke(Color.DARKGREEN);
        }

        gameScene.setStyle("-fx-background-color: lightgreen");

        // changing all the buttons that are already present on the board
        for(int i=1;i<=9;i++){
            if(position[i].equals("X")){
                button[i].setText("");
                button[i].setStyle("-fx-background-color: white");
                setHumanPlayerStyle(button[i]);
            }
            else if(position[i].equals("O")){
                button[i].setText("");
                setAIPlayerStyle(button[i]);
            }
        }
    }

    @Override
    public void setHumanPlayerStyle(Button button) {
        Image image=new Image("/image/humanPlayer.png");
        ImageView view=new ImageView(image);
        setImageView(button,view);
    }

    @Override
    public void setAIPlayerStyle(Button button) {
        Image image=new Image("/image/botPlayer.jpg");
        ImageView view=new ImageView(image);
        setImageView(button,view);
    }

    private void setImageView(Button button,ImageView view){
        view.setFitHeight(140);
        view.setFitWidth(85);
        button.setGraphic(view);
    }
}
