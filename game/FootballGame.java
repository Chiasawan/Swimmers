
import java.util.Scanner;

/*4/4/13 Lots of things commented out right now.  I am fairly confident in the program
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
	//private static int whatYardLine;
	//private static int yardsToGo;

	public static void main(String args[]){
	
		PlayCaller headCoach = new PlayCaller();
		ScoreAndPossession whoseBall = new ScoreAndPossession();
		Defense teamDefense = new Defense();
		boolean gameOn = true; 	// Master loop boolean 
		boolean offense;	// tracking the offense loop
		boolean defense; 	// tracking the defense loop
		
		/*
		
		Dive d1 = new Dive();
		Lead l1 = new Lead();
		Sweep s1 = new Sweep();
		DoubleDump dd1 = new DoubleDump();
		DownAndDistance toGo = new DownAndDistance(1,10);
		FieldPosition positionOnField = new FieldPosition(20);
		boolean result;
		int playYards;
		*/
		
		Scanner keyboard = new Scanner(System.in);
		int choice;
		
		System.out.println("Welcome to Keith Bergstedt's Nine Man Football");
		//do{
		/*
		System.out.println("\nSelect which play you would like:");
		System.out.println("1: 23 Dive" + "\n" + "2: 33 Lead" + "\n" + "3: 28 Sweep" + "\n" + "4: Double Dump" + "\n5. Quit");
		System.out.print("Choice: ");
		choice = keyboard.nextInt();
		headCoach.callPlay(choice);
		*/
		
		whoseBall.setHomePossession();	// testing 4/5/2013
		offense = whoseBall.getPossession();  // added 4/10/2013
		//System.out.println("The value of test is " + test);  // added 4/10/2013 for testing
		/*4/5/13 Need to figure out a way to get out of the while loop.  If i do score a touchdown
		I am still getting the offensive play calls.
		*/
		
		while(gameOn){
		
			
			while(offense){
				headCoach.run();
				offense = whoseBall.getPossession();
				//System.out.println("The value of test is " + test); // added 4/10/13 for testing
			}
		
			//test = whoseBall.getPossession();
			//System.out.println("The value of test is " + test);  // added 4/10/2013 for testing
		
			while(!offense){
				teamDefense.score();
				offense = whoseBall.getPossession();
			}
		
			//test = whoseBall.getPossession();
			//System.out.println("The value of test is " + test);  // added 4/10/2013 for testing
		
		
		}
		//headCoach.run();
		
		//}while(test);
		
		
		/*
		for(int i = 0; i < 25; i++){ // test purpose loop
		d1.positiveNegative();
		result = d1.getResult();
		d1.setYardage();
		playYards = d1.getYardage();
		//System.out.println(playYards);
		whatYardLine = positionOnField.getYardLine(result, playYards);
		yardsToGo = toGo.yardsForFirstDown(result, playYards);
		
		if(result == false){
			System.out.println("Loss of " + playYards + " yards on the play.");
		}
		else{
			System.out.println("Gain of " + playYards + " yards on the play.");
		}
		
		System.out.println("Ball on the " + whatYardLine + " yard line.");
		System.out.println("It is " + toGo.getDown() + " down and " + yardsToGo + " yards for the first down");
		//System.out.println("It is " + toGo.getDown() + " down.");
		System.out.println();
		
		*/
		//System.out.println(dive.getResult());
		//System.out.println(dive.yardage());
		//}
		
		//dive.setLoss();
		//System.out.println(dive);
		//System.out.println(togo);
		//System.out.println(ym);
	}

}