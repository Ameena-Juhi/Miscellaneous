package practice.TicTacToe;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private char currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = 'X'; // X starts the game
    }

    public void startGame() {
        
        boolean gameIsRunning = true;
        int i = 0;

        while (gameIsRunning || i<9) {

            
            // Path path = Paths.get("tictactoe.txt");
            // List<String> data = Files.readAllLines(path);
            Scanner sc = new Scanner(System.in);
            board.displayBoard();
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2):");

            int row = sc.nextInt();
            int col = sc.nextInt();

            if (isValidMove(row, col)) {
                board.placeCoin(row, col, currentPlayer);

                if (checkForWinner()) {
                    board.displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameIsRunning = false;
                    break;
                } else if (board.isFull()) {
                    board.displayBoard();
                    System.out.println("It's a draw!");
                    gameIsRunning = false;
                } else {
                    // Switch to the other player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        // Check if the move is within bounds and the cell is empty
        return row >= 0 && row < 3 && col >= 0 && col < 3 && this.board.isCellEmpty(row, col);
    }

    private boolean checkForWinner() {
        // Check rows for a winner
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) == currentPlayer && board.getCell(i, 1) == currentPlayer && board.getCell(i, 2) == currentPlayer) {
                return true; // Player wins in a row
            }
        }
    
        // Check columns for a winner
        for (int j = 0; j < 3; j++) {
            if (board.getCell(0, j) == currentPlayer && board.getCell(1, j) == currentPlayer && board.getCell(2, j) == currentPlayer) {
                return true; // Player wins in a column
            }
        }
    
        // Check diagonals for a winner
        if ((board.getCell(0, 0) == currentPlayer && board.getCell(1, 1) == currentPlayer && board.getCell(2, 2) == currentPlayer) ||
            (board.getCell(0, 2) == currentPlayer && board.getCell(1, 1) == currentPlayer && board.getCell(2, 0) == currentPlayer)) {
            return true; // Player wins in a diagonal
        }
    
        return false; // No winner found
    }
    

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        
    }
}
