package l334d1c4;

public class LeetChiper {
	String Szoveg;
	StringBuilder Forditas = new StringBuilder("");
	LeetChiper(String Szoveg){
		this.Szoveg=Szoveg;
	}
	
	public void fordit() {
		
		this.kodol();
		
	}
	
	private void kodol(/*char[] dst*/ ) {
		for(int i= 0; i< Szoveg.length();i++) {
			switch(this.Szoveg.charAt(i)) {
			case 'a':  this.Forditas.append("4"); break;
			case 'b':  this.Forditas.append("8"); break;
			case 'c':  this.Forditas.append("<"); break;
			case 'd':  this.Forditas.append("|)"); break;
			case 'e':  this.Forditas.append("3"); break;
			case 'f':  this.Forditas.append("|="); break;
			case 'g':  this.Forditas.append("["); break;
			case 'h':  this.Forditas.append("|-|"); break;
			case 'i':  this.Forditas.append("1"); break;
			case 'j':  this.Forditas.append("_|"); break;
			case 'k':  this.Forditas.append("|<"); break;
			case 'l':  this.Forditas.append("|_"); break;
			case 'm':  this.Forditas.append("|\\/|"); break;
			case 'n':  this.Forditas.append("|\\|"); break;
			case 'o':  this.Forditas.append("0"); break;
			case 'p':  this.Forditas.append("|o"); break;
			case 'q':  this.Forditas.append("O_"); break;
			case 'r':  this.Forditas.append("|2"); break;
			case 's':  this.Forditas.append("5"); break;
			case 't':  this.Forditas.append("7"); break;
			case 'u':  this.Forditas.append("|_|"); break;
			case 'v':  this.Forditas.append(" \\/"); break;
			case 'w':  this.Forditas.append(" \\/\\/"); break;
			case 'x':  this.Forditas.append("%"); break;
			case 'y':  this.Forditas.append("`/"); break;
			case 'z':  this.Forditas.append("2"); break;
			case 'A':  this.Forditas.append("4"); break;
			case 'B':  this.Forditas.append("8"); break;
			case 'C':  this.Forditas.append("<"); break;
			case 'D':  this.Forditas.append("|)"); break;
			case 'E':  this.Forditas.append("3"); break;
			case 'F':  this.Forditas.append("|="); break;
			case 'G':  this.Forditas.append("["); break;
			case 'H':  this.Forditas.append("|-|"); break;
			case 'I':  this.Forditas.append("1"); break;
			case 'J':  this.Forditas.append("_|"); break;
			case 'K':  this.Forditas.append("|<"); break;
			case 'L':  this.Forditas.append("|_"); break;
			case 'M':  this.Forditas.append("|\\/|"); break;
			case 'N':  this.Forditas.append("|\\|"); break;
			case 'O':  this.Forditas.append("0"); break;
			case 'P':  this.Forditas.append("|o"); break;
			case 'Q':  this.Forditas.append("O_"); break;
			case 'R':  this.Forditas.append("|2"); break;
			case 'S':  this.Forditas.append("5"); break;
			case 'T':  this.Forditas.append("7"); break;
			case 'U':  this.Forditas.append("|_|"); break;
			case 'V':  this.Forditas.append(" \\/"); break;
			case 'W':  this.Forditas.append(" \\/\\/"); break;
			case 'X':  this.Forditas.append("%"); break;
			case 'Y':  this.Forditas.append("`/"); break;
			case 'Z':  this.Forditas.append("2"); break;
			
			}
		}
	}
	
}
