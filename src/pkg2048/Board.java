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

    private int rows;
    private int cols;
    private int board[][];

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new int[rows][cols];
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public Board apply(Direction dir) {
        return this;
    }
}
