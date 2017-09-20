package com.ariscdc.coding.problem.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ariscdc
 *
 * 20160228 1940-2040 (60 mins.)
 */
public class SudokuBoardValidator {

    private static final int BLOCK_SIZE = 3;
    private static final int BOARD_SIZE = 9;

    public static boolean validate(int[][] board) {
        return validateRowsAndColumns(board) && validateBlocks(board);
    }

    private static boolean isValidValue(int value) {
        return value > 0 && value <= BOARD_SIZE;
    }

    private static boolean validateRowsAndColumns(int[][] board) {

        List<Set<Integer>> rows = new ArrayList<>(BOARD_SIZE);
        List<Set<Integer>> columns = new ArrayList<>(BOARD_SIZE);

        for (int i = 0; i < BOARD_SIZE; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isValidValue(board[i][j])) {
                    if (rows.get(i).contains(board[i][j])) {
                        return false;
                    } else {
                        rows.get(i).add(board[i][j]);
                    }
                    if (columns.get(j).contains(board[i][j])) {
                        return false;
                    } else {
                        columns.get(j).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    private static boolean validateBlock(int[][] board, int blockRow, int blockColumn) {

        Set<Integer> block = new HashSet<>(BOARD_SIZE);

        for (int i = blockRow; i < blockRow + BLOCK_SIZE; i++) {
            for (int j = blockColumn; j < blockColumn + BLOCK_SIZE; j++) {
                if (isValidValue(board[i][j])) {
                    if (block.contains(board[i][j])) {
                        return false;
                    } else {
                        block.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    private static boolean validateBlocks(int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i += 3) {
            for (int j = 0; j < BOARD_SIZE; j += 3) {
                if (!validateBlock(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] board = {
                { 1, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 3, 0, 0, 0, 0, 0, 2},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                //--------------------------
                { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                //--------------------------
                { 9, 8, 7, 0, 0, 0, 3, 0, 0},
                { 6, 5, 4, 0, 0, 0, 0, 0, 0},
                { 3, 2, 1, 0, 0, 0, 0, 0, 5}
        };
        System.out.println(SudokuBoardValidator.validate(board));
    }
}
