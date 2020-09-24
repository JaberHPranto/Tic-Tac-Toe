package tictactoe.AI;

import javafx.scene.control.Button;
import tictactoe.AI.AI;
import tictactoe.AI.DefensiveAI;
import tictactoe.AI.RandomAI;

public class AiSetter {

    public AI setAiType(Button button){
        button.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-border-color: black");
        if(button.getId().equals("randomAI")){
            return new RandomAI();
        }else{
            return new DefensiveAI();
        }
    }
}
