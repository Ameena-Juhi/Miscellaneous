package chess;

public class Piece {

    public String name;
    public String colour;
    public int row;
    public String column;
    public boolean isCaptured;

    public Piece(String name, String colour, int row, String column){
        this.name = name;
        this.colour = colour;
        this.row = row;
        this.column = column;
        isCaptured = false;
    }
    
    // This Method must be overridden in child class
    public boolean canMoveTo(int destinationRow, String destinationCol, Piece[][] chessBoard) {
    	System.out.println("Invalid Move");
    	return false;
    }
    
    
    public int getCol() {
    	return ChessBoard.columns.indexOf(column);
    }
    
    public static int getCol(String col) {
    	return ChessBoard.columns.indexOf(col);
    }

    @Override
    public String toString() {
        return (this.name).substring(0,1)+"("+(this.colour).substring(0,1)+")";
    }
}