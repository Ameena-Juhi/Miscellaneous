package chess;

public class Bishop extends Piece {
	
    public Bishop(String colour, int row, String column) {
        super("Bishop", colour, row, column);
    }

 

    @Override
    public boolean canMoveTo(int newRow, String newCol, Piece[][] chessBoard) {
        int currentRow = this.row;
        String currentCol = this.column;
        int currentColIndex = getCol(currentCol);
        int newColIndex = getCol(newCol);

        // Check if the new position is within the board bounds
        if (newRow <= 0 || newRow > 8) {
            return false;
        }

        // Check if the bishop is moving diagonally
        int rowDistance = Math.abs(newRow - currentRow);
        int colDistance = Math.abs(newColIndex - currentColIndex);
        
        if (rowDistance == colDistance) {
            // Check if the path is clear
            int rowDirection = newRow > currentRow ? 1 : -1;
            int colDirection = newColIndex > currentColIndex ? 1 : -1;
            
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

        return false; // Invalid move
    }
    
    public boolean canCapturePieceAt(int destinationRow,String destinationCol,Piece[][] chessboard) {
    	int currentRow = this.row;
        String currentCol = this.column;
        int currentColIndex = getCol(currentCol);
        int newColIndex = getCol(destinationCol);
       
        Piece tempPiece = chessboard[destinationRow-1][newColIndex];
        if(tempPiece == null || tempPiece.colour.equals(tempPiece))
        	return false;
        
        chessboard[destinationRow-1][newColIndex] = null;
        
        if(canMoveTo(destinationRow,destinationCol,chessboard) == true) {
        	return true;
        }
        
        else {
        	chessboard[destinationRow-1][newColIndex] = tempPiece;
        	return false;
        }

    }
}
















