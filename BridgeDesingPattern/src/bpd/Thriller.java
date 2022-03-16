package bpd;

/**
 * Subclasa Thriller - ce reprezinta genul unei carti - implementeaza punctual 
 * metoda mostenita din clasa abstracta
 * @author Stefania
 *
 */

public class Thriller extends Carte{
	public Thriller(Caracteristica c, String gC) {
		super(c,gC);
	}

	@Override
	public void afisareCaracteristica() {
		caracteristici.afisareCaracteristica();
	}
}
