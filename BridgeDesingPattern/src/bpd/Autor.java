package bpd;
/**
 * Metoda afisareCaracteristica() afiseaza numele caracteristicii, 
 * informand utilizatorul cand aceasta este selectata
 *
 */
public class Autor implements Caracteristica{

	@Override
	public void afisareCaracteristica() {
		System.out.println("Autorul ales este: ");
		}
	
	public String numeAutor(){
		return "Jane Austen";
	}
	}		

