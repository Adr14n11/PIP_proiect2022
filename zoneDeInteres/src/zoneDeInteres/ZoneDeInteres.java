package zoneDeInteres;

public class ZoneDeInteres {
	String locatie;
	double latitudine, longitudine;
	
	
	ZoneDeInteres(String locatie, double latitudine, double longitudine){
		this.locatie = locatie;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	void afisare(){
		System.out.println("Locatie: " + locatie + ", Latitudine: "+ latitudine +", Longitudine: "+ longitudine);
	}
}
