package url_read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The class ReadFromWeb has a method readFromWeb that takes a String as an argument and returns a String
 */
public class ReadFromWeb {
	/**
	 * It takes a URL as a string, opens a stream to that URL, reads the stream line by line, and returns the contents of the
	 * stream as a string
	 *
	 * @param webURL The URL of the web page you want to read.
	 * @return A string of the text from the web page.
	 */	
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