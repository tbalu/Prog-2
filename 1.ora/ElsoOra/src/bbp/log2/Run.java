package bbp.log2;

public class Run {
	public static void main(String[] arg)
		{
			BBP b= new BBP();
			//b.piErteketSzamol();
			
			System.out.println(b.expMod(7,6,3));
			b.piErteketSzamol();
			System.out.println(StrictMath.floor(-2.00011123));
		}
}
