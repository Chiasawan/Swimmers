
import java.util.Scanner;
import java.util.Date;

/*
3/23/13 Keith Bergstedts Nine Man Football
A text based football game in Java by Seth Aho
Named after my high school football coach. 
4/4/13 Lots of things commented out right now.  I am fairly confident in the program
running properly at this point but just want to keep them commented out for now.
I still need a way to get back into the game after scoring a touchdown.  The recursive
technique seems to be working in the PlayCaller method, just unsure at this point as to
when/how to put it in for touchdown and frankly don't want to think about it at this time.
4/5/13 added new ScoreAndPossession to try and keep track of possession
4/8/13 Thought about having downs as classes, then i could get distance to first down from a
field position class (either side of 50 and goal line as well). Then with the downs I could
set up different odds for different plays that come in.  Look into the thought of having 
downs as classes themselves
4/10/13 Game seems to be working fine. Some things that need to be done before I start messing
around with play odds/thinking about having downs as classes:
1) Need to make sure a safety is acounted for
2) Should check and make sure my scoring system is working(after each touchdown maybe)
3) Need to deal with when the ball is within the 10 yard line to have it state 1st and Goal
also it would be nice on longer plays say it is a 30 yard touchdown but it says the play went for 79
It was nice for testing but it needs to be dealt with.
4) I can maybe think about cleaning up some commented out code?

*/

public class FootballGame{
	
	public static void main(String args[]){
	
		PlayCaller headCoach = new PlayCaller(); // main playcall area
		ScoreAndPossession whoseBall = new ScoreAndPossession(); // Possession tracker
		Defense otherTeam = new Defense(); // for keeping track of other teams score, not implemented yet
		boolean gameOn = true; 	// Master loop boolean now way to exit in main
		boolean offense;	// tracking the offense loop
		boolean defense; 	// tracking the defense loop
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;	
	
		System.out.println("Welcome to Keith Bergstedt's Nine Man Football");

		whoseBall.setHomePossession();	// Set user team to have the ball first
		offense = whoseBall.getPossession();  // to switch between the offense and defense 
		
		
		while(gameOn && elapsedTime < 1*60*1000){
			// Gameplay loop will switch from offense to defense, no plays called on defense
			// just shows if they score or not.  Offense first.  Game exit is taking care of in
			// PlayCaller
			while(offense){
				headCoach.run();
				offense = whoseBall.getPossession();
			}
			// Defensive portion
			while(!offense){
				otherTeam.score();
				offense = whoseBall.getPossession();
			}
	
			elapsedTime = (new Date()).getTime() - startTime;
		}		
		System.out.println("Times up");
		System.exit(0);
	}

}
