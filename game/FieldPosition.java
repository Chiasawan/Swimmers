/* 4/4/13 Faily confident with how this is working.  Just need a way
to figure out how to get back into the game after scoring a touchdown
4/5/13 Added spTracker to try and get possession changed and keep track of scoring which
is not happening yet.  Still returning a zero to please the method.  Not sure what to do
about it yet at this point. 
4/5/13 Adding changeDown to set the down to get out of my recursive loop in PlayCaller
after a touchdown is scored.
*/

import java.util.Random;

public class FieldPosition{
	
	private static int yardMarker = 20;
	ScoreAndPossession spTracker = new ScoreAndPossession();
	DownAndDistance changeDown = new DownAndDistance();
	
	
	public FieldPosition(){
	}
	
	public FieldPosition(int yardMarker){
		this.yardMarker = yardMarker;
	}

	public void setTwenty(){
		yardMarker = 20;
	}
	
	public int getYardLine(boolean in, int yards){
		int temp;
		if(in == true){
			yardMarker += yards;
			temp = whichSideofFifty(yardMarker);
			//System.out.println(temp);
			return temp;
		}
		else{
			yardMarker -= yards;
			temp = whichSideofFifty(yardMarker);
			//System.out.println(temp);
			return temp;
		}
	}
	
	public int whichSideofFifty(int yards){
		int midfield = 50;
		int temp;
		int otherSideofFifty;
		
		if(yards <= 50){
			return yards;
		}
		else{
			temp = yards - midfield;
			otherSideofFifty = midfield - temp;
			if(otherSideofFifty > 0)
				return otherSideofFifty;
			else{
				// 4/5/14 I believe this to be working properly I may have too much going on down there
				// should be able to get rid of setting the down and changing possession. I might have that
				// taken care of in PlayCaller
				
				System.out.println("Touchdown!");
				spTracker.homeScore();
				spTracker.setAwayPossession();
				setOpposingTwenty();
				changeDown.setDown(5); // 4/10/13 I should be able to get rid of this, returning zero below defeats this
				return 0;	// Just testing for now, not sure what to put in here 4/5/2103
			}
		}
	}
	
	// 4/10/13 Setting field position to opposing 20 after a touchdown is scored
	public void setOpposingTwenty(){
		yardMarker = 80;
	}
	
	// 4/10/13 Trying to get the field postion moved after the defense is stopped to some random location
	public void setNewPosition(){
		int temp;
		temp = yardMarker;
		Random rand = new Random();
		int defYards = rand.nextInt((temp - 0));
		yardMarker = temp - defYards;
	}
	
}