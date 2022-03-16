package bpd;

/**
 * Subclasa Actiune - ce reprezinta genul unei carti - implementeaza punctual 
 * metodele mostenite din clasa abstracta
 *
 */

public class Actiune extends Carte{
	public Actiune(Caracteristica c, String gC) {
		super(c,gC);
	}

	@Override
	public void afisareCaracteristica() {
		caracteristici.afisareCaracteristica();
	}
	public void afiseazaDetalii(){
		System.out.println("Cartea aleasa este o carte: " +genCarte);
	}
}
