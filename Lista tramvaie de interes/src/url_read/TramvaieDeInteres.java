package url_read;

public class TramvaieDeInteres  {
	//in TramvaieDeInteres stocam datele legate de numele locatiei, latitudinea locatiei si longitudinea locatiei 
	int vehicleName;						
	double latitudine, longitudine;

	//am creat un constructor care va atribui campurilor valorile transmise prin argumente
     TramvaieDeInteres(int vehicleName, double latitudine, double longitudine){
		this.vehicleName = vehicleName;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	void afisare(){

		System.out.println("Vehicle name: " + vehicleName + ", Latitudine: "+ latitudine +", Longitudine: "+ longitudine);
	}
}