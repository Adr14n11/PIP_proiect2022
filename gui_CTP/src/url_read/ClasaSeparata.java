package url_read;

import gui_CTP.GUI;
import java.io.IOException;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
import com.teamdev.jxmaps.LatLng;

/**
 * It's a class that makes the connection between the GUI and the rest of the program
 */

public class ClasaSeparata {
	
	// Creating a vector of TramvaieDeInteres objects, and it is creating 4 ZoneDeInteres objects.
	static Vector<TramvaieDeInteres> vTramvaie_t1 = new Vector<TramvaieDeInteres>();	//vector de tramvaie la momentul 1
	static Vector<TramvaieDeInteres> vTramvaie_t2 = new Vector<TramvaieDeInteres>();	//vector de tramvaie la momentul 2
	static ZoneDeInteres piataUnirii =  new ZoneDeInteres("Piata Unirii", 47.1656266707948 , 27.5808940217326); 				//zona1
	static ZoneDeInteres piataMihEmin = new ZoneDeInteres("Piata Mihai Eminescu", 47.1688202139377, 27.576766289313785);		//zona2
	static ZoneDeInteres palas = new ZoneDeInteres("Palas Mall", 47.1552297978438, 27.5875265897513);							//zona3
	static ZoneDeInteres uaic = new ZoneDeInteres("Universitatea Alexandru Ioan Cuza", 47.1747724305297, 27.5724000042106);		//zona4

	/**
	 * The above function reads the content of the url, filters the content and stores it in a vector of objects.
	 */
	public void functie() throws InterruptedException, IOException{
		
		int counter =0;
    	
    	String url = "https://gps.sctpiasi.ro/json"; 		//URL-ul nostru
        String creare_lista_json_start_I_s ="{ lista:"; 	//Simboluri inceput
        String creare_lista_json_start_E_s =" }"; 			//Simboluri sfarsit
        String concatenat_final_s; 							//Continutul url-ului in varianta lista de json
        String aux = ReadFromWeb.readFromWeb(url); 		     //Continutul url-ului   
        String de_comparat = "22"; 							//String folosit pentru a cauta tramvaiele cu name-ul care ne intereseaza
        
        concatenat_final_s = creare_lista_json_start_I_s + aux;
        concatenat_final_s = concatenat_final_s + creare_lista_json_start_E_s;       
        JSONObject jsnobject = new JSONObject(concatenat_final_s); 		//From string to json       
        JSONArray jsonArray = jsnobject.getJSONArray("lista"); 			//Citim lista    
        
        String[] lista_filtrata = new String[40];		//Lista filtrata dupa id       
        double[] latitudini = new double[40];    
        double[] longitudini = new double[40];
        int[] ID = new int[40];
        	        
        for (int i = 0; i < jsonArray.length(); i++) {
        	JSONObject explrObject = jsonArray.getJSONObject(i);
            String latitudine = explrObject.getString("vehicleLat");
            String longitudine = explrObject.getString("vehicleLong");       	 
            String aux_1 = explrObject.getString("vehicleName");  
            String aux_2 = explrObject.getString("vehicleName");    
            
            aux_2 = aux_2+"-"+latitudine; 		//Concatenare
            aux_2 = aux_2+"-"+longitudine;
            int aux_3 = Compare.stringCompare(aux_2, de_comparat);
                        
            if(aux_3==1){           	
            	lista_filtrata[counter]=aux_2;
            	latitudini[counter] = Double.parseDouble(latitudine);		//Transformam string-ul latitudine in double
            	latitudine+="-";
            	longitudini[counter] = Double.parseDouble(longitudine);		//Transformam string-ul longitudine in double
            	longitudine+="-";
            	ID[counter]= Integer.parseInt(aux_1);						//Transformam string-ul vehicleName in int
            	counter = counter +1;
            }               
        }

        for(int i=0;i<counter;i++){ 
            TramvaieDeInteres tramvai = new TramvaieDeInteres(ID[i], latitudini[i], longitudini[i]);
            vTramvaie_t1.add(tramvai);         		
        }
            	
        System.out.println("\n\tLista initiala de tramvaie:\n");
        TramvaieDeInteres.afisare_lista_tramvaie(vTramvaie_t1);

        int counter2 =0;  
        Thread.sleep(15050);        
        String aux2 =  ReadFromWeb.readFromWeb(url); 		//Continutul url-ului 
        
        String concatenat_final_s2 = creare_lista_json_start_I_s + aux2;
        concatenat_final_s2 = concatenat_final_s2 + creare_lista_json_start_E_s;       
        JSONObject jsnobject2 = new JSONObject(concatenat_final_s2); 		//From string to json       
        JSONArray jsonArray2 = jsnobject2.getJSONArray("lista"); 			//Citim lista    
            
        String[] lista_filtrata2 = new String[40];			//Lista filtrata dupa id       
        double[] latitudini2 = new double[40];    
        double[] longitudini2 = new double[40];
        int[] ID2 = new int[40];

        for (int i = 0; i < jsonArray2.length(); i++) {
        	JSONObject explrObject2 = jsonArray2.getJSONObject(i);
            String latitudine2 = explrObject2.getString("vehicleLat");
            String longitudine2 = explrObject2.getString("vehicleLong");       	 
             
            String aux_12 = explrObject2.getString("vehicleName");  
            String aux_22 = explrObject2.getString("vehicleName");    
            aux_22 = aux_22+"-"+latitudine2; 		//Concatenare
            aux_22 = aux_22+"-"+longitudine2;
            int aux_32 = Compare.stringCompare(aux_22, de_comparat);
                            
            if(aux_32==1){           	
            	lista_filtrata2[counter2]=aux_22;
            	latitudini2[counter2] = Double.parseDouble(latitudine2);	//Transformam string-ul latitudine in double
                latitudine2+="-";
                longitudini2[counter2] = Double.parseDouble(longitudine2);	//Transformam string-ul longitudine in double
                longitudine2+="-";
                ID2[counter2]= Integer.parseInt(aux_12);					//Transformam string-ul vehicleName in int
                counter2 = counter2 +1;
            }               
        }

        for(int i=0;i<counter2;i++){      	        	
       	TramvaieDeInteres tramvai2 = new TramvaieDeInteres( ID2[i], latitudini2[i], longitudini2[i] );
           vTramvaie_t2.add(tramvai2);		
        }
                	
        System.out.println("\n\tLista de tramvaie dupa un timp de 15s:\n");
        TramvaieDeInteres.afisare_lista_tramvaie(vTramvaie_t2);
	}
//clasa separata cu rol de a face legatura intre zona de interes UAIC si un buton de pe GUI
	
	/**
	 * It takes the coordinates of the UAIC and the two vectors of tramvai objects, and returns a string containing the name
	 * of the closest tramvai, its coordinates and whether it's getting closer or further away from the UAIC
	 *
	 * @return the name of the closest tram to the UAIC, the coordinates of the tram and if the tram is getting closer or
	 * further from the UAIC.
	 */
	public String functieUAIC() throws IOException, InterruptedException {

		// The above code is a function that returns a string. The function is called "TramvaieApropiateDeZona" and it takes as
		// parameter a ZoneDeInteres object. The function returns a string that contains the name of the closest tram to the
		// zone, the latitude and longitude of the tram and a message that says if the tram is getting closer or further away
		// from the zone.
		functie();
		 Vector<TramvaieDeInteres> tramvaie_t2_ordonate = TramvaieDeInteres.TramvaieApropiateDeZona(uaic,vTramvaie_t2); //lista de tramvaie ordonata la momentul2 pentru a fi folosita mai departe
	        
	        //returnare date la momentul 1 pentru cel mai apropiat tramvai:
	        TramvaieDeInteres tramvai_t1 = new TramvaieDeInteres(0, 0, 0);
	        for (int i = 0; i < vTramvaie_t1.size(); i++){
	        	if (vTramvaie_t1.elementAt(i).vehicleName == tramvaie_t2_ordonate.elementAt(0).vehicleName)
	        		tramvai_t1 = vTramvaie_t1.elementAt(i);
	        }
        
        //testare daca tramvaiul cel mai apropiat de zona se indeparteaza sau se apropie
        System.out.println("\n\n\t");
        
        LatLng p1 = new LatLng(47.1747724305297, 27.5724000042106);
		GUI.example.generateMarker(p1);
        
        LatLng p = new LatLng(tramvai_t1.latitudine, tramvai_t1.longitudine);

        GUI.example.generateMarker(p);
		try{
		GUI.example.generateSimplePath(p1, p, null);
		}
		catch(NullPointerException e){
		}
		
		System.out.println("\n\t");
        return "Universitate: "+"\nVehicle name: " + tramvai_t1.vehicleName + ", Latitudine: "+ tramvai_t1.latitudine +", Longitudine: "+ tramvai_t1.longitudine+"\n" + ZoneDeInteres.seApropieTramvaiDeZona(uaic, tramvai_t1,tramvaie_t2_ordonate.elementAt(0));      
	}

//clasa separata cu rol de a face legatura intre zona de interes Palas si un buton de pe GUI
	/**
	 * It takes the coordinates of the Palas Mall, the list of tramvai coordinates at the first moment and the list of tramvai
	 * coordinates at the second moment, and returns a string containing the name of the closest tramvai to the Palas Mall,
	 * its coordinates at the first moment and a message saying if the tramvai is getting closer or further away from the
	 * Palas Mall
	 *
	 * @return a string that contains the name of the closest tram to the Palas Mall, its coordinates and if it is getting
	 * closer or further away from the mall.
	 */
	public String functiePalas() throws IOException, InterruptedException {
		
		// The above code is a function that returns a string. The function is called "PalasMall" and it is used to find the
		// closest tram to the Palas Mall.
		functie();
		Vector<TramvaieDeInteres> tramvaie_t2_ordonate = TramvaieDeInteres.TramvaieApropiateDeZona(palas,vTramvaie_t2); //lista de tramvaie ordonata la momentul2 pentru a fi folosita mai departe
        
        //returnare date la momentul 1 pentru cel mai apropiat tramvai:
		
		// Finding the tramvai_t1 that corresponds to the tramvai_t2 that has the smallest distance.
        TramvaieDeInteres tramvai_t1 = new TramvaieDeInteres(0, 0, 0);
        for (int i = 0; i < vTramvaie_t1.size(); i++){
        	if (vTramvaie_t1.elementAt(i).vehicleName == tramvaie_t2_ordonate.elementAt(0).vehicleName)
        		tramvai_t1 = vTramvaie_t1.elementAt(i);
        }
	    
	    //testare daca tramvaiul cel mai apropiat de zona se insdeparteaza sau se apropie
	    System.out.println("\n\n\t");
	    
	    // Creating a marker on the map at the specified coordinates.
	    LatLng p1 = new LatLng(47.1552297978438, 27.5875265897513);
		GUI.example.generateMarker(p1);
        
        LatLng p = new LatLng(tramvai_t1.latitudine, tramvai_t1.longitudine);

        GUI.example.generateMarker(p);
		try{
		GUI.example.generateSimplePath(p1, p, null);
		}
		catch(NullPointerException e){
		}
		
	    System.out.println("\n\t");
	    return "Palas Mall: "+"\nVehicle name: " + tramvai_t1.vehicleName + ", Latitudine: "+ tramvai_t1.latitudine +", Longitudine: "+ tramvai_t1.longitudine+"\n"+ZoneDeInteres.seApropieTramvaiDeZona(palas, tramvai_t1,tramvaie_t2_ordonate.elementAt(0));
}
	
//clasa separata cu rol de a face legatura intre zona de interes Piata Mihai Eminescu si un buton de pe GUI
	/**
	 * It returns a string containing the name of the closest tram to the zone, the coordinates of the tram at the first
	 * moment and a message saying if the tram is getting closer or further away from the zone
	 *
	 * @return a string that contains the name of the closest tram to the zone, the latitude and longitude of the tram at the
	 * first moment, and a message that says if the tram is getting closer or farther from the zone.
	 */
	public String functiePiataMEminescu() throws IOException, InterruptedException {
		
		functie();
		Vector<TramvaieDeInteres> tramvaie_t2_ordonate = TramvaieDeInteres.TramvaieApropiateDeZona(piataMihEmin,vTramvaie_t2); //lista de tramvaie ordonata la momentul2 pentru a fi folosita mai departe
	        
        //returnare date la momentul 1 pentru cel mai apropiat tramvai:
        TramvaieDeInteres tramvai_t1 = new TramvaieDeInteres(0, 0, 0);
        for (int i = 0; i < vTramvaie_t1.size(); i++){
        	if (vTramvaie_t1.elementAt(i).vehicleName == tramvaie_t2_ordonate.elementAt(0).vehicleName)
        		tramvai_t1 = vTramvaie_t1.elementAt(i);
        }
        
        //testare daca tramvaiul cel mai apropiat de zona se indeparteaza sau se apropie
        System.out.println("\n\n\t");
	    
	    LatLng p1 = new LatLng(47.1688202139377, 27.576766289313785);
 		GUI.example.generateMarker(p1);
         
        LatLng p = new LatLng(tramvai_t1.latitudine, tramvai_t1.longitudine);
         
        GUI.example.generateMarker(p);
 		try{
 		GUI.example.generateSimplePath(p1, p, null);
 		}
 		catch(NullPointerException e){
 		}
 		
 		System.out.println("\n\t");
	    return "Piata Mihai Eminescu: "+"\nVehicle name: " + tramvai_t1.vehicleName + ", Latitudine: "+ tramvai_t1.latitudine +", Longitudine: "+ tramvai_t1.longitudine+"\n" + ZoneDeInteres.seApropieTramvaiDeZona(piataMihEmin, tramvai_t1,tramvaie_t2_ordonate.elementAt(0));
}
	
//clasa separata cu rol de a face legatura intre zona de interes Piata Unirii si un buton de pe GUI
	/**
	 * It takes the coordinates of the Piata Unirii station, the list of the vehicles at the first moment and the list of the
	 * vehicles at the second moment, and returns the name of the vehicle that is closest to the station, its coordinates and
	 * if it is getting closer or further away from the station
	 *
	 * @return a string containing the name of the closest tram to the Piata Unirii, its coordinates and if it is getting
	 * closer or further away from the Piata Unirii.
	 */
	public String functiePiataUnirii() throws IOException, InterruptedException {
		
		functie();
		Vector<TramvaieDeInteres> tramvaie_t2_ordonate = TramvaieDeInteres.TramvaieApropiateDeZona(piataUnirii,vTramvaie_t2); //lista de tramvaie ordonata la momentul2 pentru a fi folosita mai departe
	        
        //returnare date la momentul 1 pentru cel mai apropiat tramvai:
        TramvaieDeInteres tramvai_t1 = new TramvaieDeInteres(0, 0, 0);
        for (int i = 0; i < vTramvaie_t1.size(); i++){
        	if (vTramvaie_t1.elementAt(i).vehicleName == tramvaie_t2_ordonate.elementAt(0).vehicleName)
        		tramvai_t1 = vTramvaie_t1.elementAt(i);
        }
        
        //testare daca tramvaiul cel mai apropiat de zona se indeparteaza sau se apropie
        System.out.println("\n\n\t");;
	    
	    LatLng p1 = new LatLng(47.1656266707948 , 27.5808940217326);
 		GUI.example.generateMarker(p1);
         
        LatLng p = new LatLng(tramvai_t1.latitudine, tramvai_t1.longitudine);
         
        GUI.example.generateMarker(p);
 		try{
 		GUI.example.generateSimplePath(p1, p, null);
 		}
 		catch(NullPointerException e){
 		}
 		
 		System.out.println("\n\t");
	    return "Piata Unirii: "+"\nVehicle name: " + tramvai_t1.vehicleName + ", Latitudine: "+ tramvai_t1.latitudine +", Longitudine: "+ tramvai_t1.longitudine+"\n" + ZoneDeInteres.seApropieTramvaiDeZona(piataUnirii, tramvai_t1,tramvaie_t2_ordonate.elementAt(0));
	}
}