package gagyi;

public class Gagyi2 {
	public static void main (String[]args)
	{

	Integer x = -120;
	Integer t = -120;

	System.out.println (x);
	System.out.println (t);

	while (x <= t && x >= t && t != x);	// Nem lesz végtelen a ciklus mert -128-tól 128-ig poolban minden Integer
										//létre van hozva így a két referencia ugyanarra az objektumra mutat. 

	}
}
