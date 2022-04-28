package url_read;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
public class ReadFromWeb {
    public static String readFromWeb(String webURL) throws IOException {
        URL url = new URL(webURL);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            String text ="";
            while ((line = br.readLine()) != null) {
                text = text + line; 
            }           
            return text;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MalformedURLException("URL invalid");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }
    
    public static int stringCompare(String str1, String str2) //Functie cu care filtram tramvaiele dupa id. 2 intrari string
    {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
  
            if (str1_ch != str2_ch) {
                return 0;
            }            
        }
        return 1;
    }
        
    public static void main(String[] args) throws IOException {
    	
    	int counter =0;
        String url = "https://gps.sctpiasi.ro/json"; //URL-ul nostru
        String creare_lista_json_start_I_s ="{ lista:"; //Simboluri inceput
        String creare_lista_json_start_E_s =" }"; //Simboluri sfarsit
        String concatenat_final_s; //Continutul url-ului in varianta lista de json
        String aux;
        String de_comparat = "22"; //String folosit pentru a cauta tramvaiele cu name-ul care ne intereseaza
        aux = readFromWeb(url); //Continutul url-ului
             
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
            aux_2 = aux_2+"-"+latitudine;
            aux_2 = aux_2+"-"+longitudine;
                        
            if(stringCompare(aux_2, de_comparat)==1){           	
            	lista_filtrata[counter]=aux_2;
            	latitudini[counter] = Double.parseDouble(latitudine);
            	latitudine+="-";
            	longitudini[counter] = Double.parseDouble(longitudine);
            	longitudine+="-";
            	ID[counter]= Integer.parseInt(aux_1);
            	counter = counter +1;
            }               
        }

        for(int i=0;i<counter;i++){      	        	
        	TramvaieDeInteres tramvai = new TramvaieDeInteres( ID[i], latitudini[i], longitudini[i] );
        	tramvai.afisare();
        }		        
    }
}