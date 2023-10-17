package chess;

public class Rook extends Piece {
	
    public Rook(String colour, int row, String column) {
        super("Rook", colour, row, column);
    }

 

    @Override
    public boolean canMoveTo(int newRow, String newCol, Piece[][] chessBoard) {
        int currentRow = row;
        String currentCol = column;
        int currentColIndex = getCol(currentCol);
        int newColIndex = getCol(newCol);

        // Check if the new position is within the board bounds
        if (newRow <= 0 || newRow > 8) {
            return false;
        }

        int rowDistance = newRow - currentRow;
        int colDistance = newColIndex - currentColIndex;

 

        // A rook can move either horizontally or vertically any number of squares
        if(rowDistance == 0 || colDistance == 0) {
        	int rowDirection = rowDistance > 0 ? 1 : (rowDistance < 0 ? -1 : 0);
            int colDirection = colDistance > 0 ? 1 : (colDistance < 0 ? -1 : 0);
            
            int r = currentRow + rowDirection;
            int c = currentColIndex + colDirection;
            
            if(chessBoard[r - 1][c] != null) {
            	return false;
            }

            while (r != newRow && c != newColIndex) {
                if (chessBoard[r - 1][c] != null) {
                    return false; // Path is blocked
                }
                r += rowDirection;
                c += colDirection;
            }
            
            return true;
        }
        
        return false;

    }

}