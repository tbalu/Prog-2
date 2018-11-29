package bbp.log2;
import java.math.*;
public class BBP {
	int d=1000000;
	// konstansok 1000000
	private double s1=0;
	private double s4=0;
	private double s5=0;
	private double s6=0;
	private double piErtek=0;
	
	int expMod(int b, int n, int k) {
			int t=2;
			int p=0;
			while((Math.pow(t,p+1))<n){
				//System.out.println("t^p: "+ (Math.pow(t, p)));
				++p;
				
			}
			//System.out.println(p);
			t=(int) Math.pow(t,p);
			
			//System.out.println("t: " + t);
			int r=1;
			while(t>=1) {
			if(n>=t){
				r=(b*r)%k;
				n-=t;
			}
			t=t/2;
			if(t>=1){
				r=(int) (Math.pow(r, 2)%k);
			}
			}
			return r;
	}
	
	
	private void sjSzamol(){
		for(int k = 0; k<1000000;k++){
			//System.out.println(v1+" "+ this.expMod(16,this.d-k,v1));
			this.s1+=((double)this.expMod(16,(this.d)-k,8*k+1)/(double)(8*k+1));
			this.s4+=((double)this.expMod(16,(this.d)-k,8*k+4)/(double)(8*k+4));
			this.s5+=((double)this.expMod(16,(this.d)-k,8*k+5)/(double)(8*k+5));
			this.s6+=((double)this.expMod(16,(this.d)-k,8*k+6)/(double)(8*k+6));
			/*this.s4+=1/(Math.pow(16,k*(8*k+4)));
			this.s5+=1/(Math.pow(16,k*(8*k+5)));
			this.s6+=1/(Math.pow(16,k*(8*k+6)));*/
			//System.out.println(this);
		}
		this.s1-=StrictMath.floor(this.s1);
		this.s4-=StrictMath.floor(this.s4);
		this.s5-=StrictMath.floor(this.s5);
		this.s6-=StrictMath.floor(this.s6);
		System.out.println(this);
		}
	void piErteketSzamol() {
		this.sjSzamol();
		//{16dπ} = {4{16dS1} − 2{16dS4} − {16dS5} − {16dS6}},
		this.piErtek=this.s1*4d-this.s4*2d-this.s5-this.s6;
		this.piErtek=this.piErtek-StrictMath.floor(this.piErtek);
		/*this.piErtek = this.s1*4.0;
		this.piErtek-=this.s4*2.0;
				this.piErtek=this.piErtek-this.s5;
					this.piErtek-=this.s6;*/
		System.out.println("vegeredmeny: "+this);
	}
	@Override
	public String toString() {
		return "BBP [d=" + d + ", s1=" + s1 + ", s4=" + s4 + ", s5=" + s5 + ", s6=" + s6 + "\npiErtek=" + piErtek + "]";
	}
}
