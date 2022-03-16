package bpd;

public class Istorie extends Carte{
	public Istorie(Caracteristica c, String gC) {
		super(c,gC);
	}


	@Override
	public void afisareCaracteristica() {
		caracteristici.afisareCaracteristica();
	}
}