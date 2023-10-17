package chess;

 

public class Pawn extends Piece {

 

    public Pawn(String colour, int row, String column) {

        super("Pawn", colour, row, column);

    }

 

    @Override

    public boolean canMoveTo(int destinationRow, String destinationCol, Piece[][] chessBoard) {

        int dy = destinationRow - row;

        int dx = Math.abs(ChessBoard.columns.indexOf(column) - ChessBoard.columns.indexOf(destinationCol));

 

        if (Math.abs(dy) == 1 && dx == 0) {

            System.out.println("Here");

            if (colour.equals("white") && dy == 1)

                return chessBoard[destinationRow - 1][ChessBoard.columns.indexOf(destinationCol)] == null;

            if (colour.equals("black") && dy == -1)

                return chessBoard[destinationRow - 1][ChessBoard.columns.indexOf(destinationCol)] == null;

        }

 

        if (Math.abs(dy) == 2 && dx == 0) {

            int midRow = (destinationRow + row) / 2;

            return (chessBoard[destinationRow - 1][ChessBoard.columns.indexOf(column)] == null

                    && chessBoard[midRow - 1][ChessBoard.columns.indexOf(column)] == null

                    && ((colour.equals("white") && row == 2) || (colour.equals("black") && row == 7)));

        }

        return false;

    }

 

    public boolean canCapturePieceAt(int destinationRow, String destinationCol, Piece[][] chessBoard) {

        int dy = destinationRow - row;

        int dx = ChessBoard.columns.indexOf(column) - ChessBoard.columns.indexOf(destinationCol);


        if(Math.abs(dy) != 1 || Math.abs(dx) != 1) {

            return false;

        }


        if(dy == 1) {

            if(colour.equals("white")) {

                return chessBoard[destinationRow - 1][ChessBoard.columns.indexOf(destinationCol)] != null &&

                        chessBoard[destinationRow - 1][ChessBoard.columns.indexOf(destinationCol)].colour.equals("black");

            }

            else {

                return false;

            }

        }

        else {

            if(colour.equals("black")) {

                return chessBoard[destinationRow - 1][ChessBoard.columns.indexOf(destinationCol)] != null &&

                        chessBoard[destinationRow - 1][ChessBoard.columns.indexOf(destinationCol)].colour.equals("white");

            }

            else {

                return false;

            }

        }

    }

 

}