package url_read;

public class TramvaieDeInteres  {
	//in TramvaieDeInteres stocam datele legate de numele locatiei, latitudinea locatiei si longitudinea locatiei 
	int locatie;						
	double latitudine, longitudine;

	//am creat un constructor care va atribui campurilor valorile transmise prin argumente
     TramvaieDeInteres(int locatie, double latitudine, double longitudine){
		this.locatie = locatie;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	void afisare(){

		System.out.println("Locatie: " + locatie + ", Latitudine: "+ latitudine +", Longitudine: "+ longitudine);
	}
}