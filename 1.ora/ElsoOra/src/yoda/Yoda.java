package yoda;

public class Yoda {
	public static void main(String[] args){
		String S = null;
		try{
		if("szo" == S){
			System.out.println("Igaz");
		}else System.out.println("Hamis");
		} catch(NullPointerException e){
			System.out.println("Nem k�veti a Yoda conditions-t");
		}
		try{
		if(S.equals("szo")!=true){
			System.out.println("S != sz�");
		}
		} catch(NullPointerException e){
			System.out.println("Nem k�veti a Yoda conditions-t");
			System.exit(0);
		}
	}
}
