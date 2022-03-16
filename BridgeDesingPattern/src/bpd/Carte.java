package bpd;

/**
 * Clasa abstracta defineste o referinta la un obiect de tip Caracteristica, la unul de tip String, 
 * si 2 metode - una abstracta, ce va fi implementata specific in subclasele ce o mostenesc si una neabstracta
 * @author Stefania
 *
 */
public abstract class Carte {
	public Caracteristica caracteristici; 
	public String genCarte;
	
	public Carte(Caracteristica c, String gC){
		this.caracteristici = c;
		this.genCarte = gC;
	}
	
	public abstract void afisareCaracteristica();
	public void afiseazaDetalii(){
		System.out.println("Cartea aleasa este o carte: " +  genCarte);
	}
	
	
}
