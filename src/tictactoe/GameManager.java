package tictactoe;
import java.util.ArrayList;

public class GameManager {

    ArrayList<Integer> winningCombination= new ArrayList<>();
    public ArrayList<Integer> checkWinner(String[] boardPosition,String move){
        if (!checkInColumn(boardPosition, move) && !checkInRows(boardPosition, move) && !checkInDiagonals(boardPosition, move)) {
            winningCombination.clear();
        }
        return winningCombination;
    }

/*
My board positions ->1D
    1 2 3
    4 5 6
    7 8 9
for rows -> checking in positions -- 1 4 7, 2 5 8, 3 6 7
for cols -> checking in positions -- 1 2 3, 4 5 6, 7 8 9
for digs -> checking in positions -- 1 5 9, 3 5 7
 */
    private boolean checkInColumn(String[] position,String move) {
        boolean foundWinner=false;
        for (int i = 1; i <= 3; i++) {
            int count = 0;
            for (int j = i; j <= 9; j += 3) {
                if (position[j].equals(move)) {
                    count++;
                    winningCombination.add(j);
                }
            }
            if(count==3)return true;
            else winningCombination.clear();
        }
        return false;
    }

    private boolean checkInRows(String[] position,String move){
        int k=0;
        boolean foundWinner=false;
        for (int i = 1; i <= 9; i+=3) {
            int count = 0;
            // add 3 in inner loop every time just for making it a nested loop to check in rows
            k+=3;
            for (int j = i; j <=k; j ++) {
                if (position[j].equals(move)){
                    count++;
                    winningCombination.add(j);
                }
            }
            if(count==3)return true;
            else winningCombination.clear();
        }
        return false;
    }

   private boolean checkInDiagonals(String[] positions,String move){
        if(positions[1].equals(move)&&positions[5].equals(move)&&positions[9].equals(move)){
            winningCombination.add(1);winningCombination.add(5);winningCombination.add(9);
            return true;
        }
        else if(positions[3].equals(move) && positions[5].equals(move) && positions[7].equals(move)){
            winningCombination.add(3);winningCombination.add(5);winningCombination.add(7);
            return true;
        }
        else {
            winningCombination.clear();
            return false;
        }
    }


}
