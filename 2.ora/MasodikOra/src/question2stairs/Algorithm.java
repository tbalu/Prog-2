package question2stairs;

public class Algorithm {
	int[] stepsCanBeTaken = {1,3,5};
	public void numOfways( Solution S) {
		//while( S.stepsRemaining!=0) 
		
			
			Solution Temp1 = new Solution(S);
			Solution Temp2 = new Solution(S);
			Solution Temp3 = new Solution(S);
			if (Temp1.stepsRemaining==0)
				System.out.println(Temp1.toString());
			if(Temp1.stepsRemaining-1<0 == false)
			numOfways(new Solution(Temp1.takeAStep(1)));
			if(Temp2.stepsRemaining-3<0 == false)
			numOfways(new Solution(Temp2.takeAStep(3)));
			if(Temp3.stepsRemaining-5<0 == false)
			numOfways(new Solution(Temp3.takeAStep(5)));
			
		
			//System.out.println(S.takenSteps);
	}
}
