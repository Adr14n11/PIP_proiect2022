package bpd;

public class Ghid extends Carte{
	public Ghid(Caracteristica c, String gC) {
		super(c,gC);
	}

	@Override
	public void afisareCaracteristica() {
		caracteristici.afisareCaracteristica();
	}
}