package chess;

public class Knight extends Piece{
	public Knight(String colour, int row, String column) {
	    super("Knight", colour, row, column);
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
	
	    // Check if the knight is moving in an L-shape
	    int rowDistance = Math.abs(newRow - currentRow);
	    int colDistance = Math.abs(newColIndex - currentColIndex);
	
	    if ((rowDistance == 2 && colDistance == 1) || (rowDistance == 1 && colDistance == 2)) {
	        return chessBoard[newRow - 1][newColIndex] == null;
	    }
	
	    return false; // Invalid move
	}
	
	@Override
	public String toString() {
		return "N(" + colour.substring(0, 1) + ")";
	}
}