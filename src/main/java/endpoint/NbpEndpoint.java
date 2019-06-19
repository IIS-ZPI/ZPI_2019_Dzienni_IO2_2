package endpoint;

import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class NbpEndpoint {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String API_URL = "http://api.nbp.pl/api/exchangerates/rates/a/";
    private static final String API_TABLE_URL = "http://api.nbp.pl/api/exchangerates/tables/a";

    //
    public String sendRequest(boolean table, String currency, String startDate, String endDate) throws Exception {
        URL obj;
        if (table)
            obj = getCurrencyTableUrl();
        else
            obj = getUrl(currency, startDate, endDate);
        int responseCode = 0;
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        try {
            responseCode = con.getResponseCode();
        } catch (Exception e){
            throw new ConnectException();
        }
        System.out.println("\nSending 'GET' request to URL : " + con.getURL().toString());
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private URL getUrl(String currency, String startDate, String endDate) throws MalformedURLException {
        return new URL(API_URL + currency + "/" + startDate + "/" + endDate + "?format=json");
    }

    private URL getCurrencyTableUrl() throws MalformedURLException {
        return new URL(API_TABLE_URL + "?format=json");
    }

}