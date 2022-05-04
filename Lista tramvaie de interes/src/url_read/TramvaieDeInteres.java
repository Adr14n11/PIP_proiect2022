package url_read;

import java.util.Collections;
import java.util.Vector;

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
	
	//functie ce creaza o lista cu tramvaiele in fucntie de distanta fata de o zona de interes
	static void TramvaieApropiateDeZona(ZoneDeInteres zona, Vector<TramvaieDeInteres> vTramvaieNeordonate){
		Vector<TramvaieDeInteres> vTramvaieOrdonate = new Vector<TramvaieDeInteres>();
		vTramvaieOrdonate = vTramvaieNeordonate;
		
		
		System.out.println("Tramvaiele ordonate dupa distanta fata de zona: ' " + zona.locatie + "' sunt urmatoarele:");
		
		for(int i=0; i < vTramvaieOrdonate.size()-2; i++)
			for(int j=1; j < vTramvaieOrdonate.size()-1; j++)
		{
			if(ZoneDeInteres.Distanta(zona, vTramvaieOrdonate.get(i)) > ZoneDeInteres.Distanta(zona, vTramvaieOrdonate.get(j)))
				Collections.swap(vTramvaieOrdonate, i, j);	
		}
		
		for(int i=0; i < vTramvaieOrdonate.size(); i++){
			vTramvaieOrdonate.get(i).afisare();
		}
	}
}