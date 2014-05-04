/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048.tests;

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
        Board b = new Board(1,1);
        b.setBoard(new int[][]{{2}});
        b.apply(Direction.UP);
        b.apply(Direction.LEFT);
        
        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{2}}));
    
    }
    
    @Test 
    public void simpleMergeUp () {
        Board b = new Board(2,1);
        b.setBoard(new int[][]{{2},{2}});
        b.apply(Direction.UP);
        
        Assert.assertTrue(assertState(b.getBoard(), new int[][]{{4}, {0}}));
        
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
