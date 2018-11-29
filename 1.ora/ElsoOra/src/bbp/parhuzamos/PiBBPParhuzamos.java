package bbp.parhuzamos;

public class PiBBPParhuzamos {
    /** A Pi hexa kifejtésében a d+1. hexa jegytől néhány hexa jegy.*/
    String d16PiHexaJegyek;
    int d;
    /**
     * Létrehoz egy <code>PiBBP</code>, a BBP algoritmust a Pi-hez
     * alkalmazó objektumot. A [BBP ALGORITMUS] David H. Bailey: The
     * BBP Algorithm for Pi. alapján a
     * {16^d Pi} = {4*{16^d S1} - 2*{16^d S4} - {16^d S5} - {16^d S6}}
     * kiszámítása, a {} a törtrészt jelöli.
     *
     * @param   d   a Pi hexa kifejtésében a d+1. hexa jegytől
     * számoljuk a hexa jegyeket
     */
    public PiBBPParhuzamos(int d) {
    	this.d=d;
    	//
    	piErteketSzamol();
    }
    public void piErteketSzamol() {
        double d16Pi = 0.0d;
        d16SjOsztaly S1 = new d16SjOsztaly("S1",d,1);
        d16SjOsztaly S4 = new d16SjOsztaly("S4",d,4);
        d16SjOsztaly S5 = new d16SjOsztaly("S5",d,5);
        d16SjOsztaly S6 = new d16SjOsztaly("S6",d,6);
        try {
			S1.t.join();
			S4.t.join();
			S5.t.join();
			S6.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        double d16S1t = S1.Sj;
        double d16S4t = S4.Sj;
        double d16S5t = S5.Sj;
        double d16S6t = S6.Sj;
       // System.out.println("Sj irok"+d16S1t);
        /*double d16S1t = d16Sj(d, 1);
        double d16S4t = d16Sj(d, 4);
        double d16S5t = d16Sj(d, 5);
        double d16S6t = d16Sj(d, 6);*/
        
        d16Pi = 4.0d*d16S1t - 2.0d*d16S4t - d16S5t - d16S6t;
        
        d16Pi = d16Pi - StrictMath.floor(d16Pi);
        //System.out.println(d16Pi);
        StringBuilder sb = new StringBuilder();
        
        Character hexaJegyek[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        
        while(d16Pi != 0.0d) {
            
            int jegy = (int)StrictMath.floor(16.0d*d16Pi);
            
            if(jegy<10)
                sb.append(jegy);
            else
                sb.append(hexaJegyek[jegy-10]);//216641020866
            
            d16Pi = (16.0d*d16Pi) - StrictMath.floor(16.0d*d16Pi);
        }
        
        d16PiHexaJegyek = sb.toString();
    }
    /**
     * BBP algoritmus a Pi-hez, a [BBP ALGORITMUS] David H. Bailey: The
     * BBP Algorithm for Pi. alapján a {16^d Sj} részlet kiszámítása.
     *
     * @param   d   a d+1. hexa jegytől számoljuk a hexa jegyeket
     * @param   j   Sj indexe
     */
    public double d16Sj(int d, int j) {
        
        double d16Sj = 0.0d;
        
        for(int k=0; k<=d; ++k)
            d16Sj += (double)n16modk(d-k, 8*k + j) / (double)(8*k + j);
        
        /* (bekapcsolva a sorozat elejen az első utáni jegyekben növeli pl.
            a pontosságot.)
        for(int k=d+1; k<=2*d; ++k)
            d16Sj += StrictMath.pow(16.0d, d-k) / (double)(8*k + j);
         */
        
        return d16Sj - StrictMath.floor(d16Sj);
    }
    /**
     * Bináris hatványozás mod k, a 16^n mod k kiszámítása.
     *
     * @param   n   kitevő
     * @param   k   modulus
     */
    public long n16modk(int n, int k) {
        
        int t = 1;
        while(t <= n)
            t *= 2;
        
        long r = 1;
        
        while(true) {
            
            if(n >= t) {
                r = (16*r) % k;
                n = n - t;
            }
            
            t = t/2;
            
            if(t < 1)
                break;
            
            r = (r*r) % k;
            
        }
        
        return r;
    }
    /**
     * A kiszámolt néhány hexa jegy visszaadása. A használt lebegőpontos
     * aritmentia függvényében mondjuk az első 6 pontos peldául
     * d=1000000 esetén.
     *
     * @return String a kiszámolt néhány hexa jegy
     */
    public String toString() {
        
        return d16PiHexaJegyek;
    }
    /** Példányosít egy BBP algoritmust implementáló obektumot.*/
  
}
