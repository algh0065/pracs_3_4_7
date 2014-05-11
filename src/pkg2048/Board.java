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

    private int[] applyRightDown(int[] line, Direction dir) {
        int i = 0;
        while (i <= line.length - 3) {
            int a = line[i];
            int b = line[i + 1];
            if (a == b) {
                line[i + 1] = a + b;
                line[i] = 0;
                i += 2;
            } else {
                i++;
            }
        }
        int result[] = new int[line.length];
        i = line.length - 1;
        for (int j = line.length - 1; j >= 0; j--) {
            if (line[j] != 0) {
                result[i] = line[j];
                i--;
            }
        }
        return result;
    }

    private int[] applyLeftUp(int[] line, Direction dir) {
        int i = line.length - 1;
        while (i >= 1) {
            int a = line[i];
            int b = line[i - 1];
            if (a == b) {
                line[i - 1] = a + b;
                line[i] = 0;
                i -= 2;
            } else {
                i--;
            }
        }
        int result[] = new int[line.length];
        i = 0;
        for (int j = 0; j < line.length; j++) {
            if (line[j] != 0) {
                result[i] = line[j];
                i++;
            }
        }
        return result;
    }

}
