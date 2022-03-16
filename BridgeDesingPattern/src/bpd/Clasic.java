package bpd;

public class Clasic extends Carte{
	public Clasic(Caracteristica c, String gC) {
		super(c,gC);
	}

	@Override
	public void afisareCaracteristica() {
		caracteristici.afisareCaracteristica();
	}

}
