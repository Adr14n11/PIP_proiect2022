package url_read;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    
        
    public static void main(String[] args) throws IOException {
    	
    	int counter =0;
        String url = "https://gps.sctpiasi.ro/json"; //URL-ul nostru
        String creare_lista_json_start_I_s ="{ lista:"; //Simboluri inceput
        String creare_lista_json_start_E_s =" }"; //Simboluri sfarsit
        String concatenat_final_s; //Continutul url-ului in varianta lista de json
        String aux;
        String de_comparat = "22"; //String folosit pentru a cauta tramvaiele cu name-ul care ne intereseaza
        aux =  ReadFromWeb.readFromWeb(url); //Continutul url-ului            
        concatenat_final_s = creare_lista_json_start_I_s + aux;
        concatenat_final_s = concatenat_final_s + creare_lista_json_start_E_s;       
        JSONObject jsnobject = new JSONObject(concatenat_final_s); //From string to json       
        JSONArray jsonArray = jsnobject.getJSONArray("lista"); //Citim lista        
        String[] lista_filtrata = new String[18];//Lista filtrata dupa id       
        double[] latitudini = new double[18];    
        double[] longitudini = new double[18];
        int[] ID = new int[18];
        
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            String latitudine = explrObject.getString("vehicleLat");
        	String longitudine = explrObject.getString("vehicleLong");       	 
         
        	String aux_1 = explrObject.getString("vehicleName");  
            String aux_2 = explrObject.getString("vehicleName");    
            aux_2 = aux_2+"-"+latitudine; //Concatenare
            aux_2 = aux_2+"-"+longitudine;
            int aux_3 = Compare.stringCompare(aux_2, de_comparat);
                        
            if(aux_3==1){           	
            	lista_filtrata[counter]=aux_2;
            	latitudini[counter] = Double.parseDouble(latitudine);//Transformam string-ul latitudine in double
            	latitudine+="-";
            	longitudini[counter] = Double.parseDouble(longitudine);//Transformam string-ul longitudine in double
            	longitudine+="-";
            	ID[counter]= Integer.parseInt(aux_1);//Transformam string-ul vehicleName in int
            	counter = counter +1;
            }               
        }

        for(int i=0;i<counter;i++){      	        	
        	TramvaieDeInteres tramvai = new TramvaieDeInteres( ID[i], latitudini[i], longitudini[i] );
        	tramvai.afisare();
        }		        
    }

	
}