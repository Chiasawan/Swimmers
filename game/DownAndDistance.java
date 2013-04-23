/* 4/4/13 Fairly confident with how this is working.  I was able to get rid of 
the loop and the system exit by putting the recursive method into Play Caller
so I should be able to get rid of those comments.  
4/5/13 Added setDown method to try and help out FieldPosition class to get out of recursive
method in PlayCaller.  Not sure if this is needed
*/


public class DownAndDistance{
	
	private static int down = 1;
	private static int distance = 10;
	
	public DownAndDistance(){}
	
	public DownAndDistance(int down, int distance){
		this.down = down;
		this.distance = distance;
	}
	
	public void setFirstDown(){
		down = 1;
	}
	public void addDown(){
		down++;
	}
	
	public void setDistance(){
		distance = 10;
	}
	
	public int getFirstDown(){
		distance = 10;
		return distance;
	}
	public int getDown(){
		return down;
	}
	
	public void setDown(int i){
		down = i;
	}
	
	// Method sets the down and the distance.
	public int yardsForFirstDown(boolean in, int yards){
			// Positivie yards
			if(in == true){
				// Greater than 10 yards automatic first down
				if(yards >= 10 && distance <= 10){
					setFirstDown();
					return getFirstDown();
				}
				//return yards left to go
				else{
					if(distance >= 0){
						// check to see if result of play is first down
						// if so return a fresh 10 or the new distance
						distance -= yards;
						if(distance <= 0){
							setFirstDown();
							return getFirstDown();
						}
						// Add a down
						else{
							addDown();
							return distance;
						}
					}
					else{
						setFirstDown();
						return getFirstDown();
					}		
				}
			}
			// Loss on the play
			else{
				// add a down
				addDown();
				return distance += yards;
			}
		
	}

}