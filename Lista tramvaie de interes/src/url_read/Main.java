package url_read;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.Thread; // Sleep pentru timp 
import java.util.Arrays;

public class Main {
    
        
    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	int variabila =1;
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
        
        while(true){
        	
        	String[] lista_filtrata = new String[40];//Lista filtrata dupa id       
            double[] latitudini = new double[40];    
            double[] longitudini = new double[40];
            int[] ID = new int[40];
        	
        	String[] lista_filtrata_2 = new String[40];      
            double[] latitudini_2 = new double[40];    
            double[] longitudini_2 = new double[40];
            int[] ID_2 = new int[40];
        	
        
        if(variabila == 1)
        {
        
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
        System.out.println("A facut primul if");
        variabila++;
        
        	lista_filtrata_2 = null;
        	latitudini_2 = null;
        	longitudini_2 = null;
        	ID_2 = null;
        	
        }
        Thread.sleep(31000);
        if(variabila == 2){
        	
        	aux =  ReadFromWeb.readFromWeb(url); //Continutul url-ului            
            concatenat_final_s = creare_lista_json_start_I_s + aux;
            concatenat_final_s = concatenat_final_s + creare_lista_json_start_E_s;       
            JSONObject jsnobject_2 = new JSONObject(concatenat_final_s); //From string to json       
            JSONArray jsonArray_2 = jsnobject_2.getJSONArray("lista"); //Citim lista  
        	
        	 for (int i = 0; i < jsonArray_2.length(); i++) {
                 JSONObject explrObject = jsonArray_2.getJSONObject(i);
                 String latitudine = explrObject.getString("vehicleLat");
             	String longitudine = explrObject.getString("vehicleLong");       	 
              
             	String aux_1 = explrObject.getString("vehicleName");  
                 String aux_2 = explrObject.getString("vehicleName");    
                 aux_2 = aux_2+"-"+latitudine; //Concatenare
                 aux_2 = aux_2+"-"+longitudine;
                 int aux_3 = Compare.stringCompare(aux_2, de_comparat);
                             
                 if(aux_3==1){           	
                 	lista_filtrata_2[counter]=aux_2;
                 	latitudini_2[counter] = Double.parseDouble(latitudine);//Transformam string-ul latitudine in double
                 	latitudine+="-";
                 	longitudini_2[counter] = Double.parseDouble(longitudine);//Transformam string-ul longitudine in double
                 	longitudine+="-";
                 	ID_2[counter]= Integer.parseInt(aux_1);//Transformam string-ul vehicleName in int
                 	counter = counter +1;
                 }               
             }

             for(int i=0;i<counter;i++){      	        	
             	TramvaieDeInteres tramvai = new TramvaieDeInteres( ID_2[i], latitudini_2[i], longitudini_2[i] );
             	tramvai.afisare();
             
             }
             System.out.println("A facut al doilea if");
             variabila --;
             Thread.sleep(15000);
             
            	lista_filtrata = null;
             	latitudini = null;
             	longitudini = null;
             	ID = null;
             
        	
        }
    }
    }

	
}