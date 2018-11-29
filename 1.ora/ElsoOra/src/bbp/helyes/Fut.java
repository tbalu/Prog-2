package bbp.helyes;
import bbp.helyes.*;
public class Fut {
	  /*public static void main(String args[]) {        
	        System.out.print(new PiBBP(1000000));
	    }*/
	  public static void main(String args[]) {
	        
	        for(int i=1000000; i<1001000; i+=2) {
	            PiBBP piBBP = new PiBBP(i);
	            System.out.print(piBBP.toString().charAt(0));
	            System.out.print(piBBP.toString().charAt(1));            
	        }        
	    }
}
