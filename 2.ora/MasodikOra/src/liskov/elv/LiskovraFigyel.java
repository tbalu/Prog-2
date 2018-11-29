package liskov.elv;

public class LiskovraFigyel {
	public static void main(String[] args) {
		Sas S;
		Pingvin Pg;
		Program P;
		P.fgv(Pg); // Az fgv a madar absztrakt osztályból származtatott egyedeket fogadja el
		P.fgv(S); // A madár nem tud repülni. Csak a repülőmadár.
	}
}
