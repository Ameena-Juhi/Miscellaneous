package practice.TicTacToe;

public class Board {
    private char[][] board;
    private static final int SIZE = 3; // 3x3 board size

    public Board() {
        board = new char[SIZE][SIZE];
        // Initialize the board with empty cells
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        // Display the current state of the board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("---------");
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        // Check if a cell is empty
        return board[row][col] == ' ';
    }

    public void placeCoin(int row, int col, char player) {
        // Place a coin (X or O) on the board
        if (isCellEmpty(row, col)) {
            board[row][col] = player;
        } else {
            System.out.println("This cell is already occupied. Try again.");
        }
    }

    public boolean isFull() {
        // Check if the board is full
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false; // There is an empty cell
                }
            }
        }
        return true; // The board is full
    }

    public char getCell(int row, int col){
        return board[row][col];
    }
}
