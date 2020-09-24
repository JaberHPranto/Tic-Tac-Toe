package unitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tictactoe.GameManager;

public class WinnerCheckerTest {

    GameManager gameManager=new GameManager();

    // ROW WINNER TESTING
    @Test
    public void winnerInRow_1(){
        String[] boardPosition={"", "X","X","X","","","","","",""};
        boolean result=winnerTest(boardPosition,"X");
        Assertions.assertTrue(result);
    }
    @Test
    public void winnerInRow_2(){
        String[] boardPosition={"", "","","","O","O","O","","",""};
        boolean result=winnerTest(boardPosition,"O");
        Assertions.assertTrue(result);
    }
    @Test
    public void winnerInRow_3(){
        String[] boardPosition={"", "","","","","","","X","X","X"};
        boolean result=winnerTest(boardPosition,"X");
        Assertions.assertTrue(result);
    }

    // COLUMN WINNER TESTING
    @Test
    public void winnerInColumn_1(){
        String[] boardPosition={"", "X","","","X","","","X","",""};
        boolean result=winnerTest(boardPosition,"X");
        Assertions.assertTrue(result);
    }
    @Test
    public void winnerInColumn_2(){
        String[] boardPosition={"", "","O","","","O","","","O",""};
        boolean result=winnerTest(boardPosition,"O");
        Assertions.assertTrue(result);
    }
    @Test
    public void winnerInColumn_3(){
        String[] boardPosition={"", "","","X","","","X","","","X"};
        boolean result=winnerTest(boardPosition,"X");
        Assertions.assertTrue(result);
    }

    // DIAGONAL WINNER TESTING
    @Test
    public void winnerInDiagonal_1(){
        String[] boardPosition={"", "X","","","","X","","","","X"};
        boolean result=winnerTest(boardPosition,"X");
        Assertions.assertTrue(result);
    }
    @Test
    public void winnerInDiagonal_2(){
        String[] boardPosition={"", "","","O","","O","","O","",""};
        boolean result=winnerTest(boardPosition,"O");
        Assertions.assertTrue(result);
    }

    // Miscellaneous Test
    @Test
    public void miscellaneousTest_1(){
        String[] boardPosition={"", "X","","O", "O","O","", "X","X","X"};
        boolean result=winnerTest(boardPosition,"X");
        Assertions.assertTrue(result);
    }
    @Test
    public void miscellaneousTest_2(){
        String[] boardPosition={"", "X","X","O", "X","O","O", "O","X","X"};
        boolean result=winnerTest(boardPosition,"O");
        Assertions.assertTrue(result);
    }


    private boolean winnerTest(String[] boardPosition,String move){
        return (!gameManager.checkWinner(boardPosition,move).isEmpty());
    }
}
