/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048;

import java.util.ArrayList;
import java.util.List;

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
                //path 1
                for (int i = 0; i < rows; i++) {
                    int temp[] = new int[cols];
                    System.arraycopy(board[i], 0, temp, 0, cols);
                    temp = applyLeftUp(temp);
                    System.arraycopy(temp, 0, board[i], 0, cols);
                }
                break;
            case RIGHT:
                // path 2
                for (int i = 0; i < rows; i++) {
                    int temp[] = new int[cols];
                    System.arraycopy(board[i], 0, temp, 0, cols);
                    temp = applyRightDown(temp);
                    System.arraycopy(temp, 0, board[i], 0, cols);
                }
                break;
            case UP:
                // path 3
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
                // path 4
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
                // path 2
                line[i + 1] = a + b;
                line[i] = 0;
                i += 2;
            } else {
                // path 1
                i++;
            }
        }
        int result[] = new int[line.length];
        i = line.length - 1;
        for (int j = line.length - 1; j >= 0; j--) {
            if (line[j] != 0) {
                // path 3
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void generateRandom() {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 0) {
                    l1.add(i);
                    l2.add(j);
                }
            }
        }

        int index = (int) (Math.random() * l1.size());
        board[l1.get(index)][l2.get(index)] = 2;
    }

    public boolean isFinished() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (board[i][j] * board[i][j + 1] == 0) {
                    // First return statement
                    return false;
                }
                if (board[i][j] == board[i][j + 1]) {
                    // Second return statement
                    return false;
                }
            }
        }
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows - 1; j++) {
                if (board[j][i] * board[j + 1][i] == 0) {
                    // Third return statement 
                    return false;
                }
                if (board[j][i] == board[j + 1][i]) {
                    // Fourth return statement
                    return false;
                }
            }
        }
        // Fifth return statemnt 
        return true;
    }
}
