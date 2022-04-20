package zoneDeInteres;

public class ZoneDeInteres {
	//in ZoneDeInteres stocam datele legate de numele locatiei, latitudinea locatiei si longitudinea locatiei 
	String locatie;						
	double latitudine, longitudine;
	
	
	//am creat un constructor care va atribui campurilor valorile transmise prin argumente
	ZoneDeInteres(String locatie, double latitudine, double longitudine){
		this.locatie = locatie;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	// functie de afisare:
	void afisare(){
		System.out.println("Locatie: " + locatie + ", Latitudine: "+ latitudine +", Longitudine: "+ longitudine);
	}
}
