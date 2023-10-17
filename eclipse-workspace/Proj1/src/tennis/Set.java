package tennis;

import Pair;

public class Set {
	Pair<Boolean> gameWinners = new Pair<Boolean>(false,false);
	Pair<Integer> thisSetWinners = new Pair<Integer>(0,0);
	Player player1,player2;
	public Set(Player p1, Player p2)
	{
		this.player1 = p1;
		this.player2 = p2;
	}
	
	public void takeResult(boolean res1, boolean res2)
	{
		gameWinners.setValue1(res1);
		gameWinners.setValue2(res2);
	}
	
	public Player processResult()
	{
		if(gameWinners.getValue1()==true)
			thisSetWinners.setValue1(thisSetWinners.getValue1()+1);
		
		else if(gameWinners.getValue2()==true)
			thisSetWinners.setValue2(thisSetWinners.getValue2()+1);
		
		else {}
		
		if(thisSetWinners.getValue1() == 6 && thisSetWinners.getValue2() <= 4)
		{
			return player1;
		}
		
		else if(thisSetWinners.getValue1() <= 4 && thisSetWinners.getValue2() == 6)
		{
			return player2;
		}
		
		else if(thisSetWinners.getValue1() == 7)
		{
			return player1;
		}
		
		else if(thisSetWinners.getValue2() == 7)
		{
			return player2;
		}
		return null;
	}
	
	public String getScoreBoard()
	{
		return player1.name+" "+player2.name+"\n"+thisSetWinners.getValue1()+"     "+thisSetWinners.getValue2();
	}
}
