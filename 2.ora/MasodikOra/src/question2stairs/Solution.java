package question2stairs;

public class Solution {
	Solution(Solution S){
		this.stepsRemaining=S.stepsRemaining;
		/*for(int i = 0; i<n ; i++) {
			this.takenSteps[i]=S.takenSteps[i];
		}*/
		this.n=S.n;
		this.takenSteps = new StringBuilder(S.takenSteps.toString());
		//System.out.println("Copy Constructor");
	}
	Solution(int n){
		this.stepsRemaining = n;
		this.n = n;
		this.takenSteps= new StringBuilder("");
		//this.takenSteps = new int[n];
		//System.out.println("Constructor");
		this.toString();
	}
	@Override
	public String toString() {
		return "Solution [n=" + n + ", stepsRemaining=" + stepsRemaining + ", takenSteps=" + takenSteps + "]";
	}
	int n;
	//int counter=0;
	
	//int[] takenSteps;
	int stepsRemaining;
	StringBuilder takenSteps;
	Solution takeAStep(int n) {
		
		//this.takenSteps[this.counter]= n;
		//counter++;
		takenSteps.append(Integer.toString(n));
		this.stepsRemaining-=n;
		return this;
	}
}
