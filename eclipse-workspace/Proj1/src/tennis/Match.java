package tennis;

import divmod.Pair;

public class Match {
	Pair<Boolean> setWinners = new Pair<Boolean>(false,false);
	Pair<Integer> matchWinners = new Pair<Integer>(0,0);
	
	Player player1,player2;
	public Match(Player p1, Player p2)
	{
		this.player1 = p1;
		this.player2 = p2;
	}
	
	public void takeResult(boolean res1, boolean res2)
	{
		setWinners.setValue1(res1);
		setWinners.setValue2(res2);
	}
	
	public Player processResult()
	{
		if(setWinners.getValue1()==true)
			matchWinners.setValue1(matchWinners.getValue1()+1);
		
		else if(setWinners.getValue2()==true)
			matchWinners.setValue2(matchWinners.getValue2()+1);
		
		else {}
		
		if(matchWinners.getValue1()==3)
			return player1;
		else if(matchWinners.getValue1()==3)
			return player2;
		else
			return null;
	}
	
	public String getScoreBoard()
	{
		return player1.name+" "+player2.name+"\n"+matchWinners.getValue1()+"     "+matchWinners.getValue2();
	}
	

}
