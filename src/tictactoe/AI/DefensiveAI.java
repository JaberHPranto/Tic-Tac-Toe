package tictactoe.AI;

public class DefensiveAI implements AI {

    @Override
    public int playWithAI(String[] positionButton, String move) {

        int position=0;

        // checking in columns
        for (int i = 1; i <= 3; i++) {
            int count = 0,index=0;
            for (int j = i; j <= 9; j += 3) {
                if(isHumanPlayer(positionButton[j]))count++;
                else if (isEmptyPosition(positionButton[j]))index=j;
            }
            if(isWin(count,index)) return index;
        }

        // checking in rows
        int k=0;
        for (int i = 1; i <= 9; i+=3) {
            int count = 0,index=0;
            // add +3 just for making it a nested loop to check in rows
            k += 3;
            for (int j = i; j <= k; j++){
                if(isHumanPlayer(positionButton[j]))count++;
                else if (isEmptyPosition(positionButton[j]))index=j;
            }
            if(isWin(count,index))return index;
        }

        // checking in diagonals
        int dig1_count=0,dig1_index=0;
        for(int i=1;i<=9;i+=4){
            if(isHumanPlayer(positionButton[i]))dig1_count++;
            else if (isEmptyPosition(positionButton[i]))dig1_index=i;
        }
        if(isWin(dig1_count,dig1_index))return dig1_index;

        int dig2_count=0,dig2_index=0;
        for(int i=3;i<=7;i+=2){
            if(isHumanPlayer(positionButton[i]))dig2_count++;
            else if (isEmptyPosition(positionButton[i]))dig2_index=i;
        }
        if(isWin(dig2_count,dig2_index)) return dig2_index;


        // if we can't find any position
        position=new RandomAI().playWithAI(positionButton,move);
         return position;
    }

    private boolean isHumanPlayer(String button){
        return button.equals("X");
    }
    private boolean isEmptyPosition(String button){
        return button.equals("");
    }
    private boolean isWin(int count,int index){
        return (count==2 && index!=0);
    }

}
