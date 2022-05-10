package url_read;

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


	//functie care determina distanta dintre un tramvai si o zona de interes:
	static double Distanta(ZoneDeInteres zona, TramvaieDeInteres tramvai){
		final double fi1 = zona.latitudine * Math.PI/180;
		final double fi2 = tramvai.latitudine * Math.PI/180;
		final double lambda1 = zona.longitudine * Math.PI/180;
		final double lambda2 = tramvai.longitudine * Math.PI/180;
		double deltafi;
		double deltalambda; 
		double a, c,d;	//d - distanta dintre zona de interes si tramvai in momentul t1 respectiv t2
		final double R=6371000;

		if(fi1 > fi2) 
			deltafi = fi1-fi2;
		else 
			deltafi = fi2-fi1;

		if(lambda1 > lambda2) 
			deltalambda = lambda1 - lambda2;
		else 
			deltalambda = lambda2 - lambda1;

		a = Math.sin(deltafi/2)*Math.sin(deltafi/2) + Math.cos(fi1)*Math.cos(fi2)*Math.sin(deltalambda/2)*Math.sin(deltalambda/2);
		c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		d = R*c;

		return d;
	}
	
	//functie care determina daca un tramvai se aproprie sau nu de o zona de interes:
	public static void seApropieTramvaiDeZona(ZoneDeInteres zona, TramvaieDeInteres tramvai_t1, TramvaieDeInteres tramvai_t2){
		double distanta_t1 = Distanta(zona,tramvai_t1);
		double distanta_t2 = Distanta(zona,tramvai_t2);
				
		if(distanta_t1 > distanta_t2)
			System.out.println("Tramvaiul se aproprie de zona de interes");
		else 
			System.out.println("Tramvaiul se indeparteaza de zona de interes");
	}

}