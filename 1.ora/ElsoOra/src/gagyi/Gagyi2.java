package gagyi;

public class Gagyi2 {
	public static void main (String[]args)
	{

	Integer x = -120;
	Integer t = -120;

	System.out.println (x);
	System.out.println (t);

	while (x <= t && x >= t && t != x);	// Nem lesz v�gtelen a ciklus mert -128-t�l 128-ig poolban minden Integer
										//l�tre van hozva �gy a k�t referencia ugyanarra az objektumra mutat. 

	}
}
