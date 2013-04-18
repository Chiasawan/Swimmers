/* 4/4/13 This is not really being implemented yet at this point.  
	4/5/13 Added boolean ourBall to try and differentiate possession
*/


public class ScoreAndPossession{
	
	private static boolean ourBall;
	private static int goodGuys;	// Home team score
	private static int badGuys;	// Other team score

	public ScoreAndPossession(){
	}
	
	
	
	public ScoreAndPossession(int gg, int bg){
		goodGuys = gg;
		badGuys = bg;
	}
	
	public void setHomePossession(){
		ourBall = true;
	}
	
	public void setAwayPossession(){
		ourBall = false;
	}
	
	public boolean getPossession(){
		return ourBall;
	}
	
	// Home team scores not attemping e.p. at this time 
	public void homeScore(){
		goodGuys += 7;
	}
	
	// Away team scores
	public void awayScore(){
		badGuys += 7;
	}
	
}