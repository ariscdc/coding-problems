package com.ariscdc.coding.problem.recursion;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Place N Queens on a chessboard so they don't attack each other.
 * Queens can move along their rows, columns, and both diagonals.
 *
 * Place one Queen at a time and check if it is a safe move.
 * Check if the remaining Queens can also be placed safely.
 *
 * Base Case:
 * All Queens have been placed and beyond the boundary.
 *
 * Recursive Case:
 * Place Queens in different positions.
 * Check if the remaining Queens can be placed safely.
 *
 * 20160221 1555-1600 (5 mins.)
 * 20160221 1850-1855 (5 mins.)
 * 20160221 1915-2130 (195 mins.)
 * 20160225 2300-2340 (40 mins.)
 *                    (245 mins.)
 */
public class NQueens {

    private static final char QUEEN = 'Q';
    private static final char EMPTY = ' ';

    public static boolean placeQueens(char[][] board, int row, Set<Cell> placedQueens, List<Set<Cell>> solutions) {

        if (row == board.length) {
            return true;
        }
        for (int j = 0; j < board[row].length; j++) {
            if (isSafeMove(placedQueens, row, j)) {
                Cell queen = new Cell(row, j);
                placedQueens.add(queen);
                board[row][j] = QUEEN;

                if (placedQueens.size() == 8) {
                    printBoard(board);
                    solutions.add(copySolution(placedQueens));
                }
                placeQueens(board, row + 1, placedQueens, solutions);
                placedQueens.remove(queen);
                board[row][j] = EMPTY;
            }
        }
        return false;
    }

    private static Set<Cell> copySolution(Set<Cell> solution) {
        // TODO Copy Solution
        return null;
    }

    private static boolean isSafeMove(Set<Cell> placedQueens, int row, int column) {

        for (Cell placedQueen: placedQueens) {
            if (placedQueen.getRow() == row) return false;
            if (placedQueen.getColumn() == column) return false;
            if (placedQueen.getRow() - placedQueen.getColumn() == row - column) return false;  // Backslash diagonal
            if (placedQueen.getRow() + placedQueen.getColumn() == row + column) return false;  // Slash diagonal
        }
        return true;

        // 00 01 02 03 04
        // 10 11 12 13 14
        // 20 21 22 23 24
        // 30 31 32 33 34
        // 40 41 42 43 44
    }

    private static void printBoard(char[][] board) {

        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = EMPTY;
            }
        }
        Set<Cell> placedQueens = new LinkedHashSet<>();
        List<Set<Cell>> solutions = new LinkedList<>();
        placeQueens(board, 0, placedQueens, solutions);

        System.out.println("\nNumber of Solutions: " + solutions.size());
    }

    private static class Cell {

        private int row;
        private int column;

        Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        int getRow() {
            return row;
        }
        int getColumn() {
            return column;
        }

        @Override
        public boolean equals(Object other) {

            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;

            Cell cell = (Cell) other;
            return row == cell.row && column == cell.column;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + column;
            return result;
        }

        @Override
        public String toString() {
            return String.format("Cell{row=%d, column=%d}", row, column);
        }
    }
}
