package tennis;

//import divmod.Pair;


public class Serve {
	
	
	Pair<Boolean> missed;
	int counter=0;
	
	public Pair<Boolean> getMissed() {
		return missed;
	}
	
	public Serve(boolean play1, boolean play2)
	{
		this.missed = new Pair<Boolean>(play1, play2);
	}
}

