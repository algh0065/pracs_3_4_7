/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048;

/**
 *
 * @author Al-Safa Tech
 */
public class Board {

    private int size;
    private int board[][];

    public Board(int size) {
        this.size = size;
        board = new int[size][size];
    }

    public Board apply(Direction dir) {
        throw new UnsupportedOperationException();
    }
}
