package bbp.parhuzamos;

public class d16SjOsztaly  implements Runnable {
		String name; // name of thread
		Thread t;
		double Sj;
		int d;
		int j;
			d16SjOsztaly(String threadname,int d,int j) {
				name = threadname;
				this.d=d;
				this.j=j;
				t = new Thread(this, name);
				//System.out.println("New thread: " + t);
				t.start(); // Start the thread
	}
			public void run() {
					this.Sj=d16Sj(this.d,j);
					/*System.out.println("dolgozotam.");
					System.out.println(this.Sj);*/
			}
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
}