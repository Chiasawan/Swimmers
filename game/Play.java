/* 4/4/13 Happy with how this is working so far.  Hope to get the odds into the different
plays themselves along with tweaking them for down and distance and that sort of thing.
*/


import java.util.Random;

public class Play{
	
	private boolean gainLoss;
	private int yardsOnThePlay;
	Random rand = new Random();
	
	public Play(){
		gainLoss = true;
		yardsOnThePlay = 0;
	}
	
	public Play(boolean gainLoss, int yardsOnThePlay){
		this.gainLoss = gainLoss;
		this.yardsOnThePlay = yardsOnThePlay;
	}
	
	public void setGain(){
		gainLoss = true;
	}
	
	public void setLoss(){
		gainLoss = false;
	}
	
	// Testing purposes??
	public boolean getResult(){
		return gainLoss;
	}
	
	public void setYardage(){
		yardsOnThePlay = bigPlayOdds(getResult());
	}
	
	public int getYardage(){
		return yardsOnThePlay;
	}
	
	public void positiveNegative(){
		double posNeg = Math.random();
		if(posNeg < .10)
			setLoss();//false
		else
			setGain();//true
	}
	
	public int bigPlayOdds(boolean in){
		double bgpOdds = randomGenerator();
		int bigPlayOddsYards;
		
		if(in == true){
			if(bgpOdds >= .97){
				bigPlayOddsYards = rand.nextInt(21) + 75;
				return bigPlayOddsYards;
				//System.out.println("Big One 75-95" + " Yards gained " + randomNum + " Random # " + bgpOdds);
			}
				else if(bgpOdds >= .93){
				bigPlayOddsYards= rand.nextInt(36) + 40;
				return bigPlayOddsYards;
				//System.out.println("Big One 40-75" + " Yards gained " + randomNum + " Random # " + bgpOdds);
			}
			else if(bgpOdds >= .90){
				bigPlayOddsYards = rand.nextInt(11) + 30;
				return bigPlayOddsYards;
				//System.out.println("Big One 30-40" + " Yards gained " + randomNum + " Random # " + bgpOdds);
			}
			else if(bgpOdds >= .87){
				bigPlayOddsYards = rand.nextInt(11) + 20;
				return bigPlayOddsYards;
				//System.out.println("Big One 20-30" + " Yards gained " + randomNum + " Random # " + bgpOdds);
			}
			else if(bgpOdds >= .85){
				bigPlayOddsYards = rand.nextInt(11) + 10;
				return bigPlayOddsYards;
				//System.out.println("Big One 10-20" + " Yards gained " + randomNum + " Random # " + bgpOdds);
			}
			else{
				bigPlayOddsYards = rand.nextInt(11) + 1;
				return bigPlayOddsYards;
				//System.out.println("Normal" + " Yards gained " + randomNum + " Random # " + bgpOdds);
			}
		}
		else{
			if(bgpOdds >= .95){
				bigPlayOddsYards = rand.nextInt(6) + 10;
				return bigPlayOddsYards;
			}
			else{
				bigPlayOddsYards = rand.nextInt(11) + 1;
				return bigPlayOddsYards;
			}
		}
	}	
	
	public double randomGenerator(){
		double randomNumber = Math.random();
		return randomNumber;
	}
	
	public String toString(){
		return " " + gainLoss;
	}
	
	
}