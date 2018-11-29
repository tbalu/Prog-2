package question2stairs;

public class App {
	public static void main(String[] args) {
		Solution S = new Solution(15);
		/*S.toString();
		Solution V = new Solution(S);
		System.out.println(S.toString());
		System.out.println(V.toString());*/
	
		Algorithm A = new Algorithm();
		A.numOfways( S);
	}
}
