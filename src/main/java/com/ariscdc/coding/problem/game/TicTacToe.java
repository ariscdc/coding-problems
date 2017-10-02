package com.ariscdc.coding.problem.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151001 17:20-18:00 (40 mins.)
 * 20151002 06:50-08:00 (70 mins.)
 * 20151002 09:45-10:40 (55 mins.)
 * 20151002 11:30-12:30 (60 mins.)
 *                      (225 mins.)
 */
public class TicTacToe {

    private static final int DEFAULT_GRID_SIZE = 3;
    private static final Pattern pattern = Pattern.compile("[0-9] [0-9]");

    private static final char EMPTY = '-';
    private static final char PLAYER_1 = 'O';
    private static final char PLAYER_2 = 'X';

    private char[][] board;
    private int gridSize;
    private int moves;
    private int maxMoves;

    public TicTacToe() {
        this(DEFAULT_GRID_SIZE);
    }

    public TicTacToe(int gridSize) {
        this.gridSize = gridSize;
        maxMoves = gridSize * gridSize;
        board = new char[gridSize][gridSize];
        reset();
    }

    public int getMaxMoves() {
        return maxMoves;
    }

    private boolean hasWon(Player player, int row, int column) {
        return isRowWin(player, row) ||
                isColumnWin(player, column) ||
                isSlashWin(player) ||
                isBackslashWin(player);
    }

    public boolean move(Player player, int row, int column) {

        if (validCell(row, column)) {
            board[row][column] = player.marker;
            moves++;
            return true;
        } else {
            return false;
        }
    }

    private boolean isBackslashWin(Player player) {
        for (int i = 0; i < gridSize; i++) {
            if (board[i][i] != player.marker) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnWin(Player player, int column) {
        for (int i = 0; i < gridSize; i++) {
            if (board[i][column] != player.marker) return false;
        }
        return true;
    }

    private boolean isRowWin(Player player, int row) {
        for (int i = 0; i < gridSize; i++) {
            if (board[row][i] != player.marker) return false;
        }
        return true;
    }

    private boolean isSlashWin(Player player) {
        for (int i = gridSize - 1; i >= 0; i--) {
            if (board[(gridSize - 1) - i][i] != player.marker) {
                return false;
            }
        }
        return true;
    }

    private void print() {

        System.out.print("+");
        for (int i = 0; i < gridSize; i++) {
            System.out.print("---+");
        }
        System.out.println();
        for (int i = 0; i < gridSize; i++) {
            System.out.print("|");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.print("+");
        for (int i = 0; i < gridSize; i++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    private void reset() {

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = EMPTY;
            }
        }
        moves = 0;
    }

    private boolean validCell(int row, int column) {
        return row >= 0 && column >= 0 &&
                row < gridSize && column < gridSize &&
                board[row][column] == EMPTY;
    }

    private static boolean parseAsBoolean(String action) {
        return action.equalsIgnoreCase("Y");
    }

    private static int[] parseAsMove(String action) {

        Matcher matcher = pattern.matcher(action);
        if (matcher.matches()) {
            String[] actions = action.split(" ");
            int[] move = new int[2];

            move[0] = Integer.parseInt(actions[0]);
            move[1] = Integer.parseInt(actions[1]);
            return move;
        }
        return null;
    }

    private static void startNewGame(TicTacToe game) {
        game.reset();
        System.out.println("\nNew Game\n");
    }

    private enum Player {

        ONE(PLAYER_1),
        TWO(PLAYER_2);

        char marker;

        Player(char marker) {
            this.marker = marker;
        }
    }

    private static class ScoreBoard {

        private Map<Player, Integer> board = new HashMap<>();

        public ScoreBoard(Player[] players) {
            for (Player player: players) {
                board.put(player, 0);
            }
        }

        public void addScore(Player player) {
            board.put(player, board.containsKey(player) ? board.get(player) + 1 : 1);
        }

        public void print() {
            System.out.println("=============== SCORE ===============");
            for (Map.Entry entry: board.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("=====================================");
        }
    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        ScoreBoard scoreBoard = new ScoreBoard(Player.values());

        Player[] players = Player.values();
        boolean player1Turn = true;
        boolean continueGame = true;
        int[] move;

        Scanner scanner = new Scanner(System.in);
        System.out.println("New Game\n");
        game.print();

        while (continueGame) {
            Player player = players[player1Turn ? 0 : 1];
            player1Turn = !player1Turn;
            System.out.println("Player " + player.name() + " move: ");
            move = parseAsMove(scanner.nextLine());

            while (move == null || !game.move(player, move[0], move[1])) {
                System.out.println("Move is invalid.");
                System.out.println("Player " + player.name() + " move: ");
                move = parseAsMove(scanner.nextLine());
            }
            game.print();

            if (game.hasWon(player, move[0], move[1])) {
                System.out.println("\nPlayer " + player.name() + " Wins!");
                scoreBoard.addScore(player);
                scoreBoard.print();
                System.out.println("Next Game (Y/N)? ");
                if (parseAsBoolean(scanner.nextLine())) {
                    startNewGame(game);
                } else {
                    continueGame = false;
                    System.out.println("Thank you for playing. Bye!");
                }
            }
            if (game.moves == game.getMaxMoves()) {
                System.out.println("\nGame is tied. Restarting game ...");
                startNewGame(game);
            }
        }
    }
}
