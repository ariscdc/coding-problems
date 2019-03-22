package com.ariscdc.coding.problem.game;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Given a board with letters and a word, determine if the word can be assembled by
 * using the letters on the board.
 *     - Each letter of the word must be next to each other.
 *     - Each letter can only be used once.
 *
 * 20190204 0046-0124 (38 mins.) - Initial implementation
 * 20190204 0130-0144 (14 mins.) - Fixed character can only be used once (Sample word: TET)
 * 20190204 0145-0149 (04 mins.) - Print path if word is found
 *                    (56 mins.)
 */
public class MiniBoggle {

    private boolean hasWord(char[][] board, String word) {
        // Iterate board.
        // For each character in word, if char is same in cell, visit each neighbor to check next char.
        // Repeat until there is a valid path. If path is invalid, go back to previous loop.
        Set<Cell> currentPath = new LinkedHashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (hasPath(board, word, i, j, currentPath)) {
                    showPath(board, currentPath);
                    return true;
                }
            }
        }
        return false;
    }

    private void showPath(char[][] board, Set<Cell> currentPath) {
        System.out.println("\nPath:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (currentPath.contains(new Cell(i, j))) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    private boolean hasPath(char[][] board, String word, int row, int column, Set<Cell> currentPath) {
        // Check boundaries
        if (row < 0 || column < 0 || row >= board.length || column >= board[row].length) {
            return false;
        }
        System.out.println(String.format("Visiting [%d][%d] - %s %s", row, column, board[row][column], currentPath));
        // Check if current character is equal and not yet used
        if (word.charAt(0) == board[row][column] && !currentPath.contains(new Cell(row, column))) {
            Cell candidatePath = new Cell(row, column);
            currentPath.add(candidatePath);
            if (word.length() == 1) {
                System.out.println("Path = " + currentPath);
                return true;
            }
            // For each neighbor, check if it has path
            String nextWord = word.substring(1);
            if (hasPath(board, nextWord, row - 1, column -1, currentPath) ||  // top-left
                    hasPath(board, nextWord, row - 1, column, currentPath) ||  // top
                    hasPath(board, nextWord, row - 1, column + 1, currentPath) ||  // top-right
                    hasPath(board, nextWord, row, column - 1, currentPath) ||  // left
                    hasPath(board, nextWord, row, column + 1, currentPath) ||  // right
                    hasPath(board, nextWord, row + 1, column - 1, currentPath) ||  // bottom-left
                    hasPath(board, nextWord, row + 1, column, currentPath) ||  // bottom
                    hasPath(board, nextWord, row + 1, column + 1, currentPath)) {  // bottom-right
                return true;
            } else {
                currentPath.remove(candidatePath);
            }
        }
        return false;
    }

    private static class Cell {

        private int row;
        private int column;

        Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (row != cell.row) return false;
            return column == cell.column;
        }
        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + column;
            return result;
        }
        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }

    public static void main(String[] args) {

        MiniBoggle miniBoggle = new MiniBoggle();
        char[][] board = {
                { 'T', 'R', 'A', 'B' },
                { 'C', 'E', 'E', 'D' },
                { 'F', 'G', 'S', 'H' },
                { 'I', 'J', 'K', 'L' }
        };
        String word = "GEAR";
        boolean found = miniBoggle.hasWord(board, word);
        System.out.println("\nWord [" + word + "] found: " + found);
    }
}
