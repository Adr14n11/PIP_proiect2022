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
	
	static void afisare_lista_tramvaie(Vector<TramvaieDeInteres> tramvaie){
		for (int i = 0; i< tramvaie.size(); i++)
			System.out.println("Vehicle name: " + tramvaie.elementAt(i).vehicleName + ", Latitudine: "+ tramvaie.elementAt(i).latitudine +", Longitudine: "+ tramvaie.elementAt(i).longitudine);
	}
	
	//functie ce creaza o lista cu tramvaiele in functie de distanta fata de o zona de interes
	static Vector<TramvaieDeInteres> TramvaieApropiateDeZona(ZoneDeInteres zona, Vector<TramvaieDeInteres> vTramvaieNeordonate){
		Vector<TramvaieDeInteres> vTramvaieOrdonate = new Vector<TramvaieDeInteres>();
		vTramvaieOrdonate = vTramvaieNeordonate;
			
		System.out.println("\n\tTramvaiele ordonate dupa distanta fata de zona: '" + zona.locatie + "' sunt urmatoarele:\n");
			
		for(int i=0; i < vTramvaieOrdonate.size()-1; i++)
			for(int j=i+1; j < vTramvaieOrdonate.size(); j++)
			{
				if(ZoneDeInteres.Distanta(zona, vTramvaieOrdonate.get(i)) > ZoneDeInteres.Distanta(zona, vTramvaieOrdonate.get(j)))
					Collections.swap(vTramvaieOrdonate, i, j);	
			}
			
			for(int i=0; i < vTramvaieOrdonate.size(); i++){
				vTramvaieOrdonate.get(i).afisare();
			}
			return vTramvaieOrdonate;
		}
		 
		 static Vector<TramvaieDeInteres> convertire_vehicleName(Vector<TramvaieDeInteres> vector_tramv){
			 for (int i = 0; i < vector_tramv.size(); i++){
				 if (vector_tramv.elementAt(i).vehicleName == 2201)
					 vector_tramv.elementAt(i).vehicleName = 13;
				 else if (vector_tramv.elementAt(i).vehicleName == 2213)
					 vector_tramv.elementAt(i).vehicleName = 9;
				 else if (vector_tramv.elementAt(i).vehicleName == 2204)
					 vector_tramv.elementAt(i).vehicleName = 1;
				 
			 }
			 
			 return vector_tramv;
		 }		
}