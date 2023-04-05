/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.ArrayList;

import java.util.*;
import java.io.*;
public class Main
{
    void printBoard(int[][] board, int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]);
                if ((j+1)%3 == 0) {
                    System.out.print("|");
                }
            }
            if ((i+1)%3 == 0) {
                System.out.println();
            }
            System.out.println();
        }
    }
    boolean isValid(int[][] board, int row, int col, int c) {
        for (int i=0; i<9; i++) {
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }
            if (board[3*(row/3) + i/3][3*(col/3)+i%3] == c) {
                return false;
            }
        }
        
        
        return true;
    }
    boolean solveSudoku(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // /System.out.println("sjfoi");
                if (board[i][j] == 0) {
                    
                            // System.out.println("sjfoi");
                    for (int c = 1; c<= 9; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudoku(board, n)) {
                                return true;
                            }
                            else {
                                
                            board[i][j] = 0;
                            }
                        }
                    }
                return false;
                }
            }
            
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 9;
        // char[][] board = new char[n][n];
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<n; j++) {
        //         board[i][j]='.';
        //     }
        // }
        int board[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        Main ob = new Main();
        if (ob.solveSudoku(board, n)) {
            System.out.println("Done");
        }
        ob.printBoard(board, n);
	}
}
