package tictactoe;

import javafx.scene.shape.Line;

import java.util.ArrayList;

public class WinLineDraw {

    public void drawWinningLine(ArrayList<Integer>winCombo,Line[] winLine){
        if(isHorizontalWin(winCombo)!=0)winLine[isHorizontalWin(winCombo)].setVisible(true);
        if(isVerticalWin(winCombo)!=0)winLine[isVerticalWin(winCombo)].setVisible(true);
        if(isDiagonalWin(winCombo)!=0)winLine[isDiagonalWin(winCombo)].setVisible(true);

    }

    private int isHorizontalWin(ArrayList<Integer>winCombo){
        for(int i=1,k=1;i<10;i+=3,k++){
              if(isWin(i,i+1,i+2,winCombo))return k;

        }
        return 0;
    }

    private int isVerticalWin(ArrayList<Integer>winCombo){
        for(int i=1,k=4;i<4;i++,k++){
            if(isWin(i,i+3,i+6,winCombo))return k;
        }
        return 0;
    }

    private int isDiagonalWin(ArrayList<Integer>winCombo){
        if(isWin(1,5,9,winCombo))return 7;
        else if (isWin(3,5,7,winCombo))return 8;
        else return 0;
    }

    private boolean isWin(int position_1,int position_2,int position_3,ArrayList<Integer>cell){
        return (position_1==cell.get(0) && position_2==cell.get(1) && position_3==cell.get(2));
    }
}
