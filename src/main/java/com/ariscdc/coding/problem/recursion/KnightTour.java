package com.ariscdc.coding.problem.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Gets all the possible solutions for the Knight Tour problem.
 * This solution would run well only on 5x5 board. Having more than this will take a huge amount of time.
 *
 * Sample output:
 * Finding one path - boardSize=8, startingRow=0, startingColumn=0 ...
 * Found path - boardSize=8, startingRow=0, startingColumn=0
 *
 * |01|12|09|06|03|14|17|20|
 * |10|07|02|13|18|21|04|15|
 * |31|28|11|08|05|16|19|22|
 * |64|25|32|29|36|23|48|45|
 * |33|30|27|24|49|46|37|58|
 * |26|63|52|35|40|57|44|47|
 * |53|34|61|50|55|42|59|38|
 * |62|51|54|41|60|39|56|43|
 *
 * 20160312 1945-2110 (85 mins.)
 * 20160312 2210-2240 (30 mins.)
 * 20160313 1145-1255 (70 mins.)
 *                    (185 mins.)
 */
public class KnightTour {

    private static final int BOARD_SIZE = 5;

    private static final int[] ROW_MOVES = { -2, -2, -1, -1, 1, 1, 2, 2 };
    private static final int[] COLUMN_MOVES = { -1, 1, -2, 2, -2, 2, -1, 1 };

    public static int[][] showOnePath(int boardSize, int startingRow, int startingColumn) {

        if (startingRow < 0 || startingRow >= BOARD_SIZE) {
            throw new IllegalArgumentException("startingRow=" + startingRow + " is invalid.");
        }
        if (startingColumn < 0 || startingColumn >= BOARD_SIZE) {
            throw new IllegalArgumentException("startingColumn=" + startingColumn + " is invalid.");
        }

        int[][] board = new int[boardSize][boardSize];

        List<Object> solutions = new LinkedList<>();
        System.out.printf("Finding one path - boardSize=%d, startingRow=%d, startingColumn=%d ...%n",
                boardSize, startingRow, startingColumn);
        if (startTour(board, startingRow, startingColumn, 1, solutions, true)) {
            int[][] solution = (int[][]) solutions.get(0);
            System.out.printf("Found path - boardSize=%d, startingRow=%d, startingColumn=%d%n",
                    boardSize, startingRow, startingColumn);
            printBoard(solution);
        } else {
            System.out.printf("No solution found on boardSize=%d, startingRow=%d, startingColumn=%d%n",
                    boardSize, startingRow, startingColumn);
        }
        return null;
    }

    public static void showAllPaths(int boardSize) {

        List<Object> solutions = new LinkedList<>();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int[][] board = new int[boardSize][boardSize];
                System.out.println("Finding solutions starting at row=" + i + ", column=" + j + " ...");
                startTour(board, i, j, 1, solutions, false);
            }
        }
        System.out.println("Found " + solutions.size() + " Solutions.");
        for (Object solution: solutions) {
            printBoard((int[][]) solution);
        }
    }

    private static int[][] clone(int[][] board) {

        int[][] clone = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                clone[i][j] = board[i][j];
            }
        }
        return clone;
    }

    private static boolean startTour(int[][] board, int row, int column, int moveCount,
                                     List<Object> solutions, boolean findOneOnly) {

        board[row][column] = moveCount;

        if (moveCount == BOARD_SIZE * BOARD_SIZE) {
            solutions.add(clone(board));
            board[row][column] = 0;
            return true;
        }

        List<Cell> moves = getValidMoves(board, row, column);

        if (moves.size() > 0) {
            for (Cell move: moves) {
                boolean hasSolution = startTour(
                        board, move.getRow(), move.getColumn(), moveCount + 1,
                        solutions, findOneOnly);
                if (hasSolution && findOneOnly) {
                    return true;
                } else {
                    board[move.getRow()][move.getColumn()] = 0;
                }
            }
        }
        return false;
    }

    private static List<Cell> getValidMoves(int[][] board, int row, int column) {

        // S - Source Cell
        //
        // | | | | | | | | |
        // | | |1| |2| | | | 1 = (-2, -1), 2 = (-2, +1)
        // | |8| | | |3| | | 8 = (-1, -2), 3 = (-1, +2)
        // | | | |S| | | | |
        // | |7| | | |4| | | 7 = (+1, -2), 4 = (+1, +2)
        // | | |6| |5| | | | 6 = (+2, -1), 5 = (+2, +1)
        // | | | | | | | | |
        // | | | | | | | | |

        List<Cell> validMoves = new LinkedList<>();

        for (int i = 0; i < ROW_MOVES.length; i++) {
            int rowMove = row + ROW_MOVES[i];
            int columnMove = column + COLUMN_MOVES[i];
            if (isValidCell(rowMove, columnMove) && board[rowMove][columnMove] == 0) {
                validMoves.add(new Cell(rowMove, columnMove));
            }
        }
        return validMoves;
    }

    private static boolean isValidCell(int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE;
    }

    private static void printBoard(int[][] board) {

        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|");
                System.out.printf("%02d", board[i][j]);
            }
            System.out.println("|");
        }
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
        public String toString() {
            return "Cell{row=" + row + ", column=" + column + "}";
        }
    }

    public static void main(String[] args) {

        showOnePath(BOARD_SIZE, 2, 2);
        System.out.println();

        showAllPaths(BOARD_SIZE);
    }
}
