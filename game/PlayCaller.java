/* 4/4/14 Happy with how this turned out so far. Just added it last night. 
The recursive run method seems to be working fine as far as the downs are concerned.
need to figure out how to get this to run after scoring a touchdown.
4/5/14 Added changePossession to try and get possession changed 
added if statement in run() to check and see if whatYardLine was 0 if so
exiting the method
*/

import java.util.Scanner;
public class PlayCaller{
	Scanner keyboard = new Scanner(System.in);
	private static int whatYardLine;
	private static int yardsToGo;
	
	private int choice;
	private boolean result;
	private int playYards;
	Dive d1 = new Dive();
	Lead l1 = new Lead();
	Sweep s1 = new Sweep();
	DoubleDump dd1 = new DoubleDump();
	DownAndDistance toGo = new DownAndDistance(1,10);
	FieldPosition positionOnField = new FieldPosition(20);
	ScoreAndPossession changePossession = new ScoreAndPossession();
	
	public void callPlay(int in) {
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
	
	
	
	public void run(){
		if(toGo.getDown() <= 4){
		
			System.out.println("\nSelect which play you would like:");
			System.out.println("1: 23 Dive" + "\n" + "2: 33 Lead" + "\n" + "3: 28 Sweep" + "\n" + "4: Double Dump" + "\n5. Quit");
			System.out.print("Choice: ");
			choice = keyboard.nextInt();
			callPlay(choice);
		
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

}