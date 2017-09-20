package com.ariscdc.coding.problem.array;

/**
 * @author ariscdc
 *
 * Given NxN cells that can be either alive and dead, determine the next generation
 * state based on the following conditions:
 *     1. If an alive cell has more than 2 alive neighbors, it will die due to starvation.
 *     2. If an alive cell has less than 2 alive neighbors, it will die due to loneliness.
 *     3. If a dead cell has exactly 2 alive neighbors, it will be revived in the next generation.
 *
 * 20160130 2340-0040 (60 mins.)
 * 20160131 0110-0125 (15 mins.)
 *                    (75 mins.)
 */
public class GameOfLife {

    private static final int ALIVE = 1;
    private static final int DEAD = 0;

    private static final int[] rowOps = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] colOps = { -1, 0, 1, -1, 1, -1, 0, 1 };

    private int[][] prevGeneration;

    public GameOfLife(int[][] prevGeneration) {
        this.prevGeneration = prevGeneration;
        printGeneration(this.prevGeneration);
    }

    public void printNextGeneration() {

        int[][] nextGeneration = new int[prevGeneration.length][prevGeneration[0].length];

        for (int i = 0; i < prevGeneration.length; i++) {
            for (int j = 0; j < prevGeneration[i].length; j++) {
                nextGeneration[i][j] = getNextState(i, j, prevGeneration[i][j]);
            }
        }
        System.out.println();
        prevGeneration = nextGeneration;
        printGeneration(nextGeneration);
    }

    private int getNeighborCount(int row, int column, int status) {

        int count = 0;
        for (int i = 0; i < rowOps.length; i++) {
            int rowIdx = row + rowOps[i];
            int colIdx = column + colOps[i];
            if (isValidCell(rowIdx, colIdx) && prevGeneration[rowIdx][colIdx] == status) {
                count++;
            }
        }
        return count;
    }

    private int getNextState(int row, int column, int prevState) {

        int aliveNeighborCount = getNeighborCount(row, column, ALIVE);

        if (prevState == ALIVE && aliveNeighborCount != 2) {
            return DEAD;
        } else if (prevState == DEAD && aliveNeighborCount == 2) {
            return ALIVE;
        } else {
            return prevState;
        }
    }

    private boolean isValidCell(int row, int column) {
        return row >= 0 && row < prevGeneration.length && column >= 0 && column < prevGeneration[row].length;
    }

    private void printGeneration(int[][] generation) {

        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                System.out.print("|" + generation[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {

        int[][] prevGeneration = {
                { 1, 1, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 0, 1 },
                { 0, 0, 1, 0 }
        };

        GameOfLife gameOfLife = new GameOfLife(prevGeneration);

        gameOfLife.printNextGeneration();
        gameOfLife.printNextGeneration();
        gameOfLife.printNextGeneration();
        gameOfLife.printNextGeneration();
        gameOfLife.printNextGeneration();
    }
}
