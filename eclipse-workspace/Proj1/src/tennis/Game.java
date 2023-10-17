package tennis;

import divmod.Pair;

public class Game {
	
	Pair<Integer> scoreBoard;
	Player[] players = new Player[2];
	int turn1,turn2;
	int count1=0;
	int count2=0;
	
	static int[] turnScore = {15,30,40,60};
	public Game(Player player1, Player player2)
	{
		this.players[0] = player1;
		this.players[1] = player2;
		
		this.scoreBoard = new Pair<Integer>(0,0);
		this.turn1 = 0;
		this.turn2 = 0;
	}
	
	public void updateScoreBoard(Serve serve)
	{
		if(!bothScoresForty())
		{
			if(serve.getMissed().getValue1())
			{
				// getValue1 returns true if player1 misses a serve
				scoreBoard.setValue2((Integer)turnScore[turn1]);
				players[1].score  = turnScore[turn1];
				turn1++;
			}
			
			if(serve.getMissed().getValue2())
			{
				// getValue1 returns true if player1 misses a serve
				scoreBoard.setValue1((Integer)turnScore[turn2]);
				players[0].score  = turnScore[turn2];
				turn2++;
			}
		}
		else {
			//enters ADVANTAGE mode
			ADVMode(serve);
		}
	}
		
	private void ADVMode(Serve serve)
	{		
		if((serve.getMissed().getValue1() && serve.getMissed().getValue2()) || (count1==1 && count2==1))
		{
			count1=0;
			count2=0;
		}
		if(serve.getMissed().getValue1()==false && serve.getMissed().getValue2()==true)
		{
			if(count1==0) {
				count1++;	
			}
			else {
				scoreBoard.setValue1(60);
			}
		}
		if(serve.getMissed().getValue2()==false && serve.getMissed().getValue1()==true)
		{
			if(count2==0) {
				count2++;
			}
			else {
				count2++;
				scoreBoard.setValue2(60);
			}
		}
	}
	
	private boolean bothScoresForty()
	{
		return scoreBoard.getValue1()==40 && scoreBoard.getValue2()==40;
	}
	
	public Player hasWinner()
	{
		if(scoreBoard.getValue1()==60)
		{
			return players[0];
		}
		else if(scoreBoard.getValue2()==60)
		{
			return players[1];
		}
		else
		{
			return null;
		}	
	}
	
	public String getScoreBoard()
	{
		return players[0].name+" "+players[1].name+"\n"+scoreBoard.getValue1()+"     "+scoreBoard.getValue2();
	}

}
