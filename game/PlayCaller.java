/* 
3/23/13 Main playcalling area and where the "meat" of the game takes shape. Get user
input for which play is called and send to methods to get result of play and display
outcome to user.  Funny story behind only the 4 play choices.  We had a tshirt made up
that said "Cromwell's Playbook" and on the back had these four plays drawn up on them.  
They were probably called 60-70% of the time.
4/4/14 Happy with how this turned out so far. Just added it last night. 
The recursive run method seems to be working fine as far as the downs are concerned.
need to figure out how to get this to run after scoring a touchdown.
4/5/14 Added changePossession to try and get possession changed 
added if statement in run() to check and see if whatYardLine was 0 if so
exiting the method
*/

import java.util.Scanner;
public class PlayCaller{
	Scanner keyboard = new Scanner(System.in);
	private static int whatYardLine;  // to keep track of fieldposition
	private static int yardsToGo;	// to keep track of yards for for first down
	
	private int choice; // For user input
	private boolean result;  // to keep track of a +/- play
	private int playYards;  // to keep track of yards gained or lost on the play
	Dive d1 = new Dive();  // one of the plays that can be called
	Lead l1 = new Lead();  // one of the plays that can be called
	Sweep s1 = new Sweep();  // one of the plays that can be called
	DoubleDump dd1 = new DoubleDump(); // one of the plays that can be called
	DownAndDistance toGo = new DownAndDistance(1,10);  // variable for method to keep track of down and distance
	FieldPosition positionOnField = new FieldPosition(20);  // variable for method to keep track of field position
	ScoreAndPossession changePossession = new ScoreAndPossession();  // variable for score and possession
	
	public void run(){
		// Recursive method for getting user input on which play to call. Will exit out of if loop and display message if
		// you turnover on downs.  No option to punt yet.  Displays yards gained or lost on the play and the new down and
		// distance
		if(toGo.getDown() <= 4){
			// Get user input
			System.out.println("\nSelect which play you would like:");
			System.out.println("1: 23 Dive" + "\n" + "2: 33 Lead" + "\n" + "3: 28 Sweep" + "\n" + "4: Double Dump" + "\n5. Quit");
			System.out.print("Choice: ");
			choice = keyboard.nextInt();
			callPlay(choice);  // send to switch statement below.
		
			whatYardLine = positionOnField.getYardLine(result, playYards);
			yardsToGo = toGo.yardsForFirstDown(result, playYards);
			
		
			
			if(result == false){
				System.out.println("Loss of " + playYards + " yards on the play.");
			}
			else{
				System.out.println("Gain of " + playYards + " yards on the play.");
			}
			
			if(whatYardLine == 0){
				// change possession and get out of method 
				// This works 4/5/13
				changePossession.setAwayPossession();
				return;
			}
			else{
				System.out.println("Ball on the " + whatYardLine + " yard line.");
				if(toGo.getDown() <= 4){
					System.out.println("It is " + toGo.getDown() + " down and " + yardsToGo + " yards for the first down");
				}
				else{
					System.out.println("Turnover on Downs");
				}
			}
			
			run();
		}
		
		else
			// 4/5/14 check this to make sure it is working properly, might need to do something
			// with setting the first down down there.
			
			changePossession.setAwayPossession();
			
			toGo.setFirstDown();
			return;
		
	}// end of run method
	
	public void callPlay(int in) {
		// Send to the play called to get if play is gain or loss and the yards gained on the play
		switch(in){
			case 1:
				d1.positiveNegative();
				result = d1.getResult();
				d1.setYardage();
				playYards = d1.getYardage();
				System.out.println("\nDive called");
				break;
			case 2:
				l1.positiveNegative();
				result = l1.getResult();
				l1.setYardage();
				playYards = l1.getYardage();
				System.out.println("\nLead called");
				break;
			case 3:
				s1.positiveNegative();
				result = s1.getResult();
				s1.setYardage();
				playYards = s1.getYardage();
				System.out.println("\nSweep called");
				break;
			case 4:
				dd1.positiveNegative();
				result = dd1.getResult();
				dd1.setYardage();
				playYards = dd1.getYardage();
				System.out.println("\nDouble Dump called");
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.exit(0);
		}
	}

}