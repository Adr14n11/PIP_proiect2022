package url_read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

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


}
