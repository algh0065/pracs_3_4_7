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
        switch (dir) {
            case LEFT:
                for (int i = 0; i < rows; i++) {
                    int temp[] = new int[cols];
                    System.arraycopy(board[i], 0, temp, 0, cols);
                    temp = applyLeftUp(temp);
                    System.arraycopy(temp, 0, board[i], 0, cols);
                }
                break;
            case RIGHT:
                for (int i = 0; i < rows; i++) {
                    int temp[] = new int[cols];
                    System.arraycopy(board[i], 0, temp, 0, cols);
                    temp = applyRightDown(temp);
                    System.arraycopy(temp, 0, board[i], 0, cols);
                }
                break;
            case UP:
                for (int i = 0; i < cols; i++) {
                    int temp[] = new int[rows];
                    for (int j = 0; j < rows; j++) {
                        temp[j] = board[j][i];
                    }
                    temp = applyLeftUp(temp);
                    for (int j = 0; j < rows; j++) {
                        board[j][i] = temp[j];
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i < cols; i++) {
                    int temp[] = new int[rows];
                    for (int j = 0; j < rows; j++) {
                        temp[j] = board[j][i];
                    }
                    temp = applyRightDown(temp);
                    for (int j = 0; j < rows; j++) {
                        board[j][i] = temp[j];
                    }
                }
                break;
        }
        return this;
    }

    public int[] applyRightDown(int[] line) {
        int i = 0;
        while (i <= line.length - 2) {
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

    public int[] applyLeftUp(int[] line) {
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

    public void print() {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void generateRandom(){
        
        
    }
}
