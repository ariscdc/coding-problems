package com.ariscdc.coding.problem.recursion;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Starts from one pixel then move outwards.
 * All adjacent pixels with the same color as the starting pixel gets the same color.
 * The fill moves outwards till it reaches a different color as the source color.
 *
 * Time Complexity: O(n), where n is the number of cells.
 *
 * 20160212 1145-1235 (50 mins.) - Implemented with visited array.
 * 20160220 1235-1240 (5 mins.) - No longer uses visited array.
 *                    (55 mins.)
 */
public class PaintFill {

    public static void fill(int[][] board, int x, int y, int newColor) {
        System.out.printf("%nFill [%d, %d] with color %d%n", x, y, newColor);
        fill(board, x, y, board[x][y], newColor);
    }

    private static void fill(int[][] board, int x, int y, int sourceColor, int newColor) {

        if (!withinBoard(board, x, y)) return;
        if (board[x][y] != sourceColor) return;

        board[x][y] = newColor;

        fill(board, x - 1, y, sourceColor, newColor);
        fill(board, x + 1, y, sourceColor, newColor);
        fill(board, x, y - 1, sourceColor, newColor);
        fill(board, x, y + 1, sourceColor, newColor);
    }

    private static void printBoard(int[][] board) {

        if (board == null) return;

        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|");
                System.out.printf("%02d", board[i][j]);
            }
            System.out.println("|");
        }
    }

    private static boolean withinBoard(int[][] board, int x, int y) {
        return board != null && x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }

    public static void main(String[] args) {

        int[][] board = {
                { 1, 1, 2 },
                { 1, 1, 2 },
                { 3, 4, 5 }
        };
        printBoard(board);

        fill(board, 0, 0, 6);
        printBoard(board);

        fill(board, 0, 1, 4);
        printBoard(board);

        fill(board, 2, 1, 5);
        printBoard(board);

        fill(board, 2, 2, 2);
        printBoard(board);

        fill(board, 1, 2, 3);
        printBoard(board);

        fill(board, 1, 1, 1);
        printBoard(board);
    }
}
