package com.spartacommodities.interviews.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {
    @Test
    void emptyBoardIsNotSolved() {
        assertFalse(new SudokuBoard(new int[9][9]).isSolved(), "An empty board should not be solved");
    }

    @Test
    void boardShouldBeWithinSudokuRange() {
        final int[][] boardWithEmptyCells = new int[][]{
                {5, 0, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 0, 0, 4, 999},
                {1, 9, 0, 0, 0, 0, 5, 6, 7},
                {0, 5, 9, 7, 0, 0, 4, 0, 3},
                {4, 2, 6, 8, 5, 3, 0, 0, 0},
                {7, 1, 0, 0, 0, 4, 0, 0, 0},
                {0, 6, 1, 0, -10, 7, 2, 8, 4},
                {2, 8, 7, 0, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 0, 6, 1, 7, 9},
        };

        assertFalse(new SudokuBoard(boardWithEmptyCells).isSolved(), "A board with wrong cells should not be solved");
    }

    @Test
    void invalidBoardWithIncorrectColumnIsNotSolved() {
        final int[][] invalidBoard = new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, /* wrong */ 9, 7 /* wrong */},
        };

        assertFalse(new SudokuBoard(invalidBoard).isSolved(), "A board with an incorrect COLUMN should not be solved");
    }

    @Test
    void invalidBoardIsNotSolved() {
        final int[][] invalidBoard = new int[][]{
                {8, 8, 8, 8, 8, 8, 8, 8, 8},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5, 5, 5, 5, 5},
                {6, 6, 6, 6, 6, 6, 6, 6, 6},
                {7, 7, 7, 7, 7, 7, 7, 7, 7},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {9, 9, 9, 9, 9, 9, 9, 9, 9},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
        };

        assertFalse(new SudokuBoard(invalidBoard).isSolved(), "An incorrect board should not be solved");
    }

    @Test
    void invalidBoardWithIncorrectRowIsNotSolved() {
        final int[][] invalidBoard = new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 9 /* wrong */},
                {3, 4, 5, 2, 8, 6, 1, 7, 5 /* wrong */},
        };

        assertFalse(new SudokuBoard(invalidBoard).isSolved(), "A board with an incorrect ROW should not be solved");
    }

    @Test
    void invalidBoardWithIncorrectSquareIsNotSolved() {
        final int[][] invalidBoard = new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}, /* wrong, should be last row */
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
        };

        assertFalse(new SudokuBoard(invalidBoard).isSolved(), "A board with an incorrect SQUARE should not be solved");
    }

    @Test
    void fullBoardIsSolved() {
        final int[][] solvedBoard = new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9},
        };

        assertTrue(new SudokuBoard(solvedBoard).isSolved(), "A full correct board should be solved");
    }
}