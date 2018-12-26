package ua.lviv;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class CurrencyRates {
	// essential URL structure is built using constants
    private static final String ACCESS_KEY = "bcf617be13171a33f0fd9d5af7576191";
    private static final String BASE_URL = "http://data.fixer.io/api/latest";
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    // method for request and retrieve the data
    public static JSONObject sendRequest(){
    	JSONObject exchangeRates = null;
        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + "?access_key=" + ACCESS_KEY);

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            exchangeRates = new JSONObject(EntityUtils.toString(entity)).getJSONObject("rates");
       
             response.close();
            
        } catch (ClientProtocolException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
           
            e.printStackTrace();
        } catch (ParseException e) {
           
            e.printStackTrace();
        } catch (JSONException e) {
          
            e.printStackTrace();
        }
		return exchangeRates;
                
    }
       
}
