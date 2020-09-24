package tictactoe;
import javafx.scene.control.Label;
public class GameEndingMessage {

    public void setGameEndedMessage(Label label,String message){
        if(message.equals("human"))
            label.setText("Congratulations, You are a Champ !!!");
        else if(message.equals("ai"))
            label.setText("AI won !!!  Better luck next time ");
        else
            label.setText("Match has Drawn");

    }


}
