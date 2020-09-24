package tictactoe.AI;
import java.util.Random;

public class RandomAI implements AI {

    public int playWithAI(String[] positionButton, String  move){
        int index;
        do{
            index= new Random().nextInt(9)+1;
        }while(!positionButton[index].equals(""));
         return index;
    }
}
