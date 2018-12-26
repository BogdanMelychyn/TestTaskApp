package ua.lviv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;


import org.json.JSONException;
import org.json.JSONObject;


public class CurrencyRates {
	// essential URL structure is built using constants
    private static final String ACCESS_KEY = "bcf617be13171a33f0fd9d5af7576191";
    private static final String BASE_URL = "http://data.fixer.io/api/latest";
    static InputStream stream;

    // method for request and retrieve the data
    public static JSONObject sendRequest(){
    	JSONObject exchangeRates = null;
    	 
       try {
    	   stream = new URL(BASE_URL + "?access_key=" + ACCESS_KEY).openStream();
    	   BufferedReader rd = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
    	   exchangeRates = new JSONObject(streamToString(rd)).getJSONObject("rates");;
                       
       }catch(MalformedURLException e) {
    	   e.printStackTrace();
    	   
       }catch (IOException e) {
           
            e.printStackTrace();
        }catch (JSONException e) {
          
            e.printStackTrace();
        } 
		return exchangeRates;
                
    }
    private static String streamToString(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }    
}
