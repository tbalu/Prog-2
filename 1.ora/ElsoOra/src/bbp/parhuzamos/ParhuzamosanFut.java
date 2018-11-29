package bbp.parhuzamos;
import bbp.helyes.PiBBP;
public class ParhuzamosanFut {		
		/*  public static void main(String args[]) {
			 // d16SjOsztaly d = new d16SjOsztaly(" 2" , 1000000, 3);
			 // System.out.println(d.Sj);
		      long t1 = System.nanoTime();  
			  PiBBPParhuzamos pi = new PiBBPParhuzamos(1000000);
		        pi.piErteketSzamol();
		        System.out.println(pi.d16PiHexaJegyek);
		        System.out.println(System.nanoTime()-t1+" nanosekundumba telt");
		        System.out.println("A parhuzamos vagyok.");
		        long t2 = System.nanoTime();
		        System.out.println(new PiBBP(1000000));
		        System.out.println(System.nanoTime()-t2+" nanosekundumba telt");
		    }*/
	  public static void main(String args[]) {
		  long t1 = System.nanoTime();
	        for(int i=1000000; i<1001000; i+=2) {
	            PiBBPParhuzamos piBBP = new PiBBPParhuzamos(i);
	            System.out.print(piBBP.toString().charAt(0));
	            System.out.print(piBBP.toString().charAt(1));            
	        }
	        System.out.println("\n");
	        System.out.println(System.nanoTime()-t1+" nanosekundumba telt\n");
	        long t2 = System.nanoTime();
		        
		        for(int i=1000000; i<1001000; i+=2) {
		            PiBBP piBBP = new PiBBP(i);
		            System.out.print(piBBP.toString().charAt(0));
		            System.out.print(piBBP.toString().charAt(1));            
		        }
		        System.out.println("\n");
		        System.out.println(System.nanoTime()-t2+" nanosekundumba telt\n");
	  }
}
