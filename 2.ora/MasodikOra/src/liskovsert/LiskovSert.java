package liskovsert;

public class LiskovSert {
	public static void main(String[] args) {
		Sas S = new Sas();
		Pingvin Pi = new Pingvin();
		Program P = new Program();
		P.fgv(Pi);
		P.fgv(S);
	}
}