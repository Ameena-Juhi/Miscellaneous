package projectGUI;
import java.util.Scanner;
 
 
public class ArraysConnectFour {
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[6][7];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                board[i][j]='E';
            }
        }
        printBoard(board);
        int player1=1;
        int player2=2;
        System.out.print("\nRed Player Please Enter a Column Number from 1 to 7: ");
        int c1 = input.nextInt();
        board = addDisk(board,c1,player1);
        printBoard(board);
        System.out.print("\nYellow Player Please Enter a Column Number from 1 to 7: ");
         int c2 = input.nextInt();
        board = addDisk(board,c2,player2);
        printBoard(board);
    }
 
     
    private static char[][] addDisk(char[][] board, int c, int player) {
        // TO place new disk
          
            for (int i=5 ; i==0 ; i--){
                if (board[i][c-1]== 'E'){
                    if (player == 1)
                        board[i][c-1] = 'R';
                    if (player == 2)
                        board[i][c-1] = 'Y';
                    return board;
                        //break;
                    }
            }
        return board;
    }
 
     
    private static void printBoard(char[][] board) {
        // TO create an empty connect four board
        //char[][] board = new char[6][7];
        int i=0;
        for (;i<board.length;i++){
            System.out.print("|");
            for (int j=0;j<board[0].length;j++){
                //if (board[i][j]=='E'){
                    //System.out.print(" |");
                //}
                 System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
 
}