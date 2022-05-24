/**
 * It contains the data of the tram vehicles that are of interest to us, and it also contains a function that sorts the
 * tram vehicles by distance from a certain area of interest
 */
package url_read;

import java.util.Collections;
import java.util.Vector;

/**
 * This class is used to store the data related to the vehicle name, latitude and longitude
 */
public class TramvaieDeInteres  {
	//in TramvaieDeInteres stocam datele legate de numele locatiei, latitudinea locatiei si longitudinea locatiei 
	public int vehicleName;						
	public double latitudine;
	public double longitudine;

	//am creat un constructor care va atribui campurilor valorile transmise prin argumente
     public TramvaieDeInteres(int vehicleName, double latitudine, double longitudine){
		this.vehicleName = vehicleName;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
     /**
 	 * The function `afisare()` prints the name of the vehicle, the latitude and the longitude
 	 */
	public void afisare(){

		System.out.println("Vehicle name: " + vehicleName + ", Latitudine: "+ latitudine +", Longitudine: "+ longitudine);
	}
	
	/**
	 * It prints the name of the tram, its latitude and longitude
	 *
	 * @param tramvaie the vector of tramvai objects
	 */
	public static void afisare_lista_tramvaie(Vector<TramvaieDeInteres> tramvaie){
		for (int i = 0; i< tramvaie.size(); i++)
			System.out.println("Vehicle name: " + tramvaie.elementAt(i).vehicleName + ", Latitudine: "+ tramvaie.elementAt(i).latitudine +", Longitudine: "+ tramvaie.elementAt(i).longitudine);
	}
	
	//functie ce creaza o lista cu tramvaiele in functie de distanta fata de o zona de interes
	/**
	 * It sorts the tramvai vector by distance from the zone of interest
	 *
	 * @param zona the zone of interest
	 * @param vTramvaieNeordonate a vector of TramvaieDeInteres objects
	 * @return A vector of TramvaieDeInteres objects.
	 */
	public static Vector<TramvaieDeInteres> TramvaieApropiateDeZona(ZoneDeInteres zona, Vector<TramvaieDeInteres> vTramvaieNeordonate){
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
}