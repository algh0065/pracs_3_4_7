/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg2048.tests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pkg2048.Board;
import pkg2048.Direction;

/**
 *
 * @author Al-Safa Tech
 */
public class WhiteBoxTest {
    
    public WhiteBoxTest() {
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
    public void isFinished_path1(){
        // This test covers the execution path for the first return statement in the function.
        // This function has four exit points and it has a non-reachable return statement at run time.
        Board b = new Board(4,4);
        b.setBoard(new int[][]{{0, 2, 4, 4}, {8, 4, 8, 8}, {16, 32, 64, 128}, {256, 512, 1024, 2048}});
        assertFalse(b.isFinished());
    }
    
    @Test
    public void isFinished_path2(){
        // This test covers the execution path for the second return statement in the function.
        Board b = new Board(4,4);
        b.setBoard(new int[][]{{4, 4, 8, 4}, {8, 4, 8, 8}, {16, 32, 64, 128}, {256, 512, 1024, 2048}});
        assertFalse(b.isFinished());
        
    }
    @Test
    public void isFinished_path3(){
        // This test covers the execution path for the third return statement in the function.
        Board b = new Board(4,4);
        b.setBoard(new int[][]{{2, 2, 4, 4}, {2, 4, 8, 8}, {16, 32, 64, 128}, {256, 512, 1024, 2048}});
        assertFalse(b.isFinished());
    }
    
    @Test
    public void isFinished_path4(){
        // This test covers the execution path for the fifth return statement in the function.
        Board b = new Board(4,4);
        b.setBoard(new int[][]{{2, 4, 2, 4}, {4, 8, 4, 8}, {16, 32, 64, 128}, {256, 512, 1024, 2048}});
        assertTrue(b.isFinished());
    }
    
    @Test
    public void applyRightDown_path1(){
        // This test covers the execution path for the path 1 mentioned in the code.
        Board b = new Board(4,4);
        int[] result = b.applyRightDown(new int[]{2, 4, 8, 16, 32});
        assertArrayEquals(result, new int[]{2, 4, 8, 16, 32});
    }
    
    @Test
    public void applyRightDown_path2(){
        // This test covers the execution path for the path 2 mentioned in the code.
        Board b = new Board(4,4);
        int[] result = b.applyRightDown(new int[]{2, 2, 2, 2});
        assertArrayEquals(result, new int[]{0, 0, 4, 4});
    }
    @Test
    public void applyRightDown_path1_path2(){
        // This test covers the execution path for the path1 and path 2 together mentioned in the code.
        Board b = new Board(4,4);
        int[] result = b.applyRightDown(new int[]{2, 2, 2, 4});
        assertArrayEquals(result, new int[]{0, 4, 2, 4});
    }
    @Test
    public void applyRightDown_path3(){
        // This test covers the execution path for the path3 mentioned in the code.
        Board b = new Board(4,4);
        int[] result = b.applyRightDown(new int[]{4, 2, 2, 0});
        assertArrayEquals(result, new int[]{0, 0, 4, 4});
    }
    
    @Test
    public void apply_path1_path3(){
        // This test covers the execution path for the path1 and path3 mentioned in the code.
        Board b = new Board(4,4);
        b.setBoard(new int[][]{{0,0,2,0},{0,0,0,2},{0,4,0,0},{0,0,0,0}});
        b.apply(Direction.LEFT);
        assertArrayEquals(b.getBoard(), new int[][]{{2,0,0,0},{2,0,0,0},{4,0,0,0},{0,0,0,0}});
        b.apply(Direction.UP);
        assertArrayEquals(b.getBoard(), new int[][]{{4,0,0,0},{4,0,0,0},{0,0,0,0},{0,0,0,0}});
    }
    @Test
    public void apply_path2_path4(){
        // This test covers the execution path for the path2 and path4 mentioned in the code.
        Board b = new Board(4,4);
        b.setBoard(new int[][]{{0,0,2,0},{0,0,0,2},{0,4,0,0},{0,0,0,0}});
        b.apply(Direction.DOWN);
        assertArrayEquals(b.getBoard(), new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,4,2,2}});
        b.apply(Direction.RIGHT);
        assertArrayEquals(b.getBoard(), new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,4,4}});
    }
}
