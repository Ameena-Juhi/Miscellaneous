package tennis;
import java.util.*;

public class PlayTennis {
	
	Player player1 = new Player("player1",0);
	Player player2 = new Player("player2",0);
	Scanner sc = new Scanner(System.in);
	
	public void playGame()
	{
		System.out.println("Enter true if player missed the serve,\nif player sucessfully utilize their serve, then enter false");
				
		boolean player1Missed, player2Missed;
		Game game = new Game(player1, player2);
		Player winner = null;
		while(winner==null) {
			System.out.println("Enter the serve, \nenter boolean value, the press enter and again enter the boolean value");
			player1Missed = sc.nextBoolean();
			player2Missed = sc.nextBoolean();
			Serve serve = new Serve(player1Missed, player2Missed);
			game.updateScoreBoard(serve);
			System.out.println("Score Board is: \n"+game.getScoreBoard());
			winner = game.hasWinner();
		}

		if(winner!=null)
		{
			System.out.println("Winner is "+winner.name);
		}
		sc.close();	
	}
	
	public void playSet()
	{
		Scanner sc = new Scanner(System.in);
		Player winner = null;
		
		boolean player1GameResult, player2GameResult;
		Set set = new Set(player1, player2);
		while(winner==null) {
			System.out.println("Enter the game result");
			player1GameResult = sc.nextBoolean();
			player2GameResult = sc.nextBoolean();
			set.takeResult(player1GameResult, player2GameResult);
			winner = set.processResult();
			System.out.println("Result of set is: \n"+set.getScoreBoard());
		}

		if(winner!=null)
		{
			System.out.println("Winner is "+winner.name);
		}
		sc.close();	
	}
	
	public void playMatch()
	{
		Scanner sc = new Scanner(System.in);
		Player winner = null;
		
		boolean player1SetResult, player2SetResult;
		Match match = new Match(player1, player2);
		while(winner==null) {
			System.out.println("Enter the game result");
			player1SetResult = sc.nextBoolean();
			player2SetResult = sc.nextBoolean();
			match.takeResult(player1SetResult, player2SetResult);
			winner = match.processResult();
			System.out.println("Result of set is: \n"+match.getScoreBoard());
		}

		if(winner!=null)
		{
			System.out.println("Winner is "+winner.name);
		}
		sc.close();	
	}
	
	
	public static void main(String args[]) {
		
		PlayTennis p =new PlayTennis();
		p.playMatch();
	}

}
