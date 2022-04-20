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
            //System.out.println(text);
            return text;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MalformedURLException("URL este stricat sefule!!");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }

    }
    
    public static int stringCompare(String str1, String str2)
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
    	
        String url = "https://gps.sctpiasi.ro/json";
        String ceva="{ lista:";
        String ceva2=" }";
        String altceva;
        String aux;
        String de_comparat = "22";
        aux = readFromWeb(url);
        //System.out.println(aux);
        
        //String[] arr_aux = aux.split("}");
        
        //for(String a:arr_aux)
        	//System.out.println(a);
        
        altceva = ceva+aux;
        altceva = altceva+ceva2;
        System.out.println(altceva);
        
        JSONObject jsnobject = new JSONObject(altceva);
        
        JSONArray jsonArray = jsnobject.getJSONArray("lista");
        
        String[] lista_filtrata = new String[18];
        
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            //System.out.println(explrObject);
            String fmm = explrObject.getString("vehicleName");
            //System.out.println(fmm);     
            fmm = fmm+"-"+explrObject.getString("vehicleLat");
            fmm = fmm+"-"+explrObject.getString("vehicleLong");
            //System.out.println(fmm);
            if(stringCompare(fmm, de_comparat)==1){
            	System.out.println(fmm);
            	
            	lista_filtrata[counter]=fmm;
            	counter = counter +1;
            }
            
         
        }
        System.out.println(counter);
        for(int i=0;i<counter;i++){
        	System.out.println(lista_filtrata[i]);
        }
        
 
        
    }

}