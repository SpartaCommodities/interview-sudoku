package com.spartacommodities.interviews.sudoku;

import java.util.Arrays;

public class SudokuBoard {
    private final int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public void setNumber(int x, int y, int number) {
        board[x][y] = number;
    }

    public boolean isSolved() {
        return false; //todo
    }
}
