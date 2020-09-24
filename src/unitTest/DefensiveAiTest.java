package unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tictactoe.AI.AI;
import tictactoe.AI.DefensiveAI;

public class DefensiveAiTest {

      AI ai=new DefensiveAI();
      // ignore 1st position of boardPosition Array.Haven't use 0th index

    // ROW TESTING
    @Test
    public void testRow_1() {
        String[] boardPosition = {"", "X", "X", "", "", "", "", "", "", ""};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testRow_2() {
        String[] boardPosition = {"", "", "", "", "X", "", "X", "", "", ""};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testRow_3() {
        String[] boardPosition = {"", "", "", "", "", "", "", "", "X", "X"};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 7;
        Assertions.assertEquals(expected, actual);
    }

    // COLUMN TESTING
    @Test
    public void testColumn_1() {
        String[] boardPosition = {"", "X", "", "", "", "", "", "X", "", ""};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testColumn_2() {
        String[] boardPosition = {"", "", "", "", "", "X", "", "", "X", ""};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testColumn_3() {
        String[] boardPosition = {"", "", "", "X", "", "", "X", "", "", ""};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    // DIAGONAL TEST
    @Test
    public void testDiagonal_1() {
        String[] boardPosition = {"", "", "", "", "", "X", "", "", "", "X"};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testDiagonal_2() {
        String[] boardPosition = {"", "", "", "X", "","X", "", "", "", ""};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 7;
        Assertions.assertEquals(expected, actual);
    }


    // Miscellaneous Test
    @Test
    public void miscellaneousTest_1() {
        String[] boardPosition = {"", "X", "O", "X", "O","O", "X", "", "X", ""};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void miscellaneousTest_2() {
        String[] boardPosition = {"", "X", "", "O", "","X", "X", "", "", "O"};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void miscellaneousTest_3() {
        String[] boardPosition = {"", "O", "O", "X", "X","", "", "X", "O", "X"};
        int actual = ai.playWithAI(boardPosition, "O");
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }


    }

