/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048.tests;

import java.util.Arrays;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg2048.Board;
import pkg2048.Direction;

/**
 *
 * @author Al-Safa Tech
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void sizeOneBoard() {
        Board b = new Board(1, 1);
        b.setBoard(new int[][]{{2}});
        b.apply(Direction.UP);
        b.apply(Direction.LEFT);

        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{2}}));

    }

    @Test
    public void simpleMergeUp() {
        Board b = new Board(2, 1);
        b.setBoard(new int[][]{{2}, {2}});
        b.apply(Direction.UP);

        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{4}, {0}}));

    }

    @Test
    public void simpleMergeDown() {
        Board b = new Board(2, 1);
        b.setBoard(new int[][]{{2}, {2}});
        b.apply(Direction.DOWN);

        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{0}, {4}}));

    }

    @Test
    public void simpleNonMergeUp() {
        Board b = new Board(2, 1);
        b.setBoard(new int[][]{{2}, {8}});
        b.apply(Direction.UP);

        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{2}, {8}}));

    }

    @Test
    public void simpleNonMergeDown() {
        Board b = new Board(2, 1);
        b.setBoard(new int[][]{{2}, {8}});
        b.apply(Direction.DOWN);

        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{2}, {8}}));

    }

    @Test
    public void twoByTwoMergeUp() {
        Board b = new Board(2, 2);
        b.setBoard(new int[][]{{2, 4}, {2, 4}});
        b.apply(Direction.UP);

        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{4, 8}, {0, 0}}));

    }

    @Test
    public void twoByTwoHalfMergeUp() {
        Board b = new Board(2, 2);
        b.setBoard(new int[][]{{2, 4}, {2, 8}});
        b.apply(Direction.UP);

        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{4, 4}, {0, 8}}));

    }

    @Test
    public void singleRowLeftUPTest() {
        Board b = new Board(1, 4);
        int[] result = b.applyLeftUp(new int[]{2, 2, 2, 2});
        assertTrue(result[0] == 4);
        assertTrue(result[1] == 4);
        assertTrue(result[2] == 0);
        assertTrue(result[3] == 0);
    }

    @Test
    public void singleRowRightDownTest() {
        Board b = new Board(1, 4);
        int[] result = b.applyRightDown(new int[]{2, 2, 2, 2});
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 0);
        assertTrue(result[2] == 4);
        assertTrue(result[3] == 4);
    }

    @Test
    public void printTest() {
        Board b = new Board(4, 4);
        b.setBoard(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        b.print();
        // I verfied the result in the output
    }

    @Test
    public void randomGenerateTest() {
        Board b = new Board(4, 4);
        int temp[][] = new int[][]{{2, 2, 0, 4}, {0, 0, 0, 4}, {4, 0, 0, 16}, {0, 4, 128, 0}};
        int original[][] = new int[temp.length][];
        for (int i = 0; i < original.length; i++) {
            original[i] = new int[temp[i].length];
            for (int j = 0; j < original[i].length; j++) {
                original[i][j] = temp[i][j];
            }
        }
        b.setBoard(temp);
        b.print();
        b.generateRandom();
        b.print();
        int result[][] = b.getBoard();
        boolean flag = false;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (original[i][j] != result[i][j]) {
                    assertFalse(flag);
                    if (original[i][j] != 0) {
                        assertTrue(false);
                    }
                    flag = true;

                }
            }
        }
        assertTrue(flag);
    }

    @Test
    public void finishedTest() {
        Board b = new Board(4, 4);
        int temp[][] = new int[][]{{2, 4, 2, 4}, {4, 2, 4, 2}, {2, 4, 2, 4}, {4, 2, 4, 2}};
        b.setBoard(temp);
        assertTrue(b.isFinished());
        temp = new int[][]{{2, 4, 2, 4}, {2, 2, 4, 2}, {4, 4, 2, 4}, {4, 2, 4, 2}};
        b.setBoard(temp);
        assertFalse(b.isFinished());
    }

    public boolean assertState(int[][] b1, int[][] b2) {
        if (b1.length != b2.length) {
            return false;
        }
        for (int i = 0; i < b1.length; i++) {
            if (b1[i].length != b2[i].length) {
                return false;
            }
            for (int j = 0; j < b1[i].length; j++) {
                if (b1[i][j] != b2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
