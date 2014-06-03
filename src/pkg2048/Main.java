/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg2048;

import java.util.Scanner;

/**
 *
 * @author Al-Safa Tech
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private static Board init() {
        Board b = new Board(4, 4);
        b.setBoard(new int[][]{{0, 0, 0, 0}, {2, 0, 0, 0}, {0, 4, 0, 0}, {0, 0, 0, 0}});
        return b;
    }
    
    private Direction getNextMove(Scanner s){
        switch(s.nextInt()){
            case 1:
                return Direction.UP;
            case 2:
                return Direction.DOWN;
            case 3:
                return Direction.RIGHT;
            case 4:
                return Direction.LEFT;
        }
        return null;
    }
    
}
