package tictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import tictactoe.AI.AI;
import tictactoe.AI.AiSetter;
import tictactoe.Theme.ClassicTheme;
import tictactoe.Theme.Theme;
import tictactoe.Theme.ThemeSetting;

import java.util.ArrayList;

public class GameBoardController {
    public Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    public Button randomAI,defensiveAI;
    public RadioButton forrest,classic,highContrast;
    public ToggleGroup themeGroup;
    public AnchorPane gameScene;
    public Line verticalLine1,verticalLine2,horizontalLine1,horizontalLine2;
    public Line verticalWinLine_1,verticalWinLine_2,verticalWinLine_3;
    public Line diagonalWinLine_1,diagonalWinLine_2;
    public Line horizontalWinLine_1, horizontalWinLine_2,horizontalWinLine_3;
    public Label label;

    GameManager gameManager=new GameManager();
    GameEndingMessage gameEndingMessage=new GameEndingMessage();
    WinLineDraw winLineDraw=new WinLineDraw();
    Theme theme=new ClassicTheme();
    AI ai;

    Line[] winLine =new Line[10];
    Line[] gameBoardLine=new Line[5];
    boolean[] isOccupied=new boolean[10];
    String[] boardPosition=new String[10];
    Button[] gameBoardButton=new Button[10];
    ArrayList<Integer> winningCells=new ArrayList<>();

    boolean human_turn = true;
    int numberOfMoves=0;
    boolean game_start=false;
    boolean isGameEnded=false;

    private void initializeGame() {
        initializeGameBoardButtons();
        initializeLines();
    }
    private void startGame(){
        if(!game_start){
            initializeGame();
            game_start=true;
        }
    }

    public void playWithAI(MouseEvent mouseEvent) {
        startGame();
        Button button=(Button)mouseEvent.getSource();
        AiSetter aiSetter=new AiSetter();
        setAI(aiSetter.setAiType(button));
    }
    private void setAI(AI ai){
        this.ai=ai;
    }
    public void setTheme() {
        startGame();
        RadioButton selectedTheme=(RadioButton) themeGroup.getSelectedToggle();
        ThemeSetting themeSetting=new ThemeSetting();
        theme=themeSetting.currentTheme(selectedTheme);
        theme.getTheme(gameScene,boardPosition,gameBoardButton,gameBoardLine);
    }

    public void humanPlayerMove(MouseEvent mouseEvent) {
        if (human_turn && !isGameEnded) {
            Button button = (Button) mouseEvent.getSource();
            int index = getButtonId(button);
            if (!isOccupied[index]) {
                setPlayerPosition(index, "X");
                theme.setHumanPlayerStyle(button);
                if (isWinner("X")) {
                    isGameEnded = true;
                    gameEndingMessage.setGameEndedMessage(label, "human");
                }
                human_turn = false;
                numberOfMoves++;
                gameEndingChecker(numberOfMoves);
            }
        }
    }
    public void aiPlayerMove(){
        int position= ai.playWithAI(boardPosition,"O");
        setPlayerPosition(position,"O");
        theme.setAIPlayerStyle(gameBoardButton[position]);
        if(isWinner("O")){
            isGameEnded=true;
            gameEndingMessage.setGameEndedMessage(label,"ai");
        }
        human_turn=true;
        numberOfMoves++;
    }
    private boolean isWinner(String move){
        if(!gameManager.checkWinner(boardPosition,move).isEmpty()){
            winningCells=gameManager.checkWinner(boardPosition,move);
            winLineDraw.drawWinningLine(winningCells,winLine);
            return true;
        }else {
            winningCells.clear();
            return false;
        }
    }


    private void setPlayerPosition(int position,String move){
        isOccupied[position]=true;
        boardPosition[position]=move;
    }
    private int getButtonId(Button button){
        String buttonId = button.getId();
        String last = buttonId.substring(buttonId.length() - 1);
        return Integer.parseInt(last);
    }
    private void gameEndingChecker(int totalMoves){
        if(totalMoves<9 && !isGameEnded)
            aiPlayerMove();
        else if(totalMoves==9 && !isGameEnded)
            gameEndingMessage.setGameEndedMessage(label,"draw");
    }


    // Initializing objects

    private void initializeLines(){
        winLine[1]=horizontalWinLine_1;
        winLine[2]=horizontalWinLine_2;
        winLine[3]=horizontalWinLine_3;
        winLine[4]=verticalWinLine_1;
        winLine[5]=verticalWinLine_2;
        winLine[6]=verticalWinLine_3;
        winLine[7]=diagonalWinLine_1;
        winLine[8]=diagonalWinLine_2;

        gameBoardLine[1]=horizontalLine1;
        gameBoardLine[2]=horizontalLine2;
        gameBoardLine[3]=verticalLine1;
        gameBoardLine[4]=verticalLine2;
    }

    private void initializeGameBoardButtons(){
        gameBoardButton[1] = button1;
        gameBoardButton[2] = button2;
        gameBoardButton[3] = button3;
        gameBoardButton[4] = button4;
        gameBoardButton[5] = button5;
        gameBoardButton[6] = button6;
        gameBoardButton[7] = button7;
        gameBoardButton[8] = button8;
        gameBoardButton[9] = button9;

        for (int i = 1; i <= 9; i++) {
            gameBoardButton[i].setText("");
            boardPosition[i]="";
            isOccupied[i]=false;
        }
    }


}