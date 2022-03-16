package bpd;

public class Filosofie extends Carte{
	public Filosofie(Caracteristica c, String gC) {
		super(c,gC);
	}


	@Override
	public void afisareCaracteristica() {
		caracteristici.afisareCaracteristica();
	}
}
