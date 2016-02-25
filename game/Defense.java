
public class Defense{
	
	/* 4/4/13 Still need a way to track field position as far as for when the other team
	has the ball.  It is reset to the 20 if they do score, odds of them scoring
	are very high right now
	4/5/13 Added method call to ScoreAndPossion to track score and change possession.
	2/25/16 Adding some stuff here
	adding more comments
	*/
	
	ScoreAndPossession opponentScore = new ScoreAndPossession();
	FieldPosition restart = new FieldPosition();
	DownAndDistance reset = new DownAndDistance();

	public void score(){
		double defenseRandomNumber = Math.random();
		if(defenseRandomNumber < .10){
			System.out.println("Other Team Scores");
			opponentScore.awayScore();
			reset.setFirstDown();
			reset.setDistance();
			restart.setTwenty();
			opponentScore.setHomePossession();
			//Other Offense Scores
		}
		else{
			System.out.println("You stopped the other team.");
			restart.setNewPosition(); // added 4/10/13 to try and randomize new location if defense is stopped
			opponentScore.setHomePossession();
			//return to offense
		}
	}


}
