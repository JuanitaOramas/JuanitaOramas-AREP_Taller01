package edu.eci.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConection {
    private static final String USER_AGENT = "Chrome";

    /** Metodo que obtiene la informacion de la pelicula
     * @param q
     */

    public static String HttpConectionExample(String q) throws IOException {

        String GET_URL = "http://www.omdbapi.com/?apikey=628586c8&" + q;
        URL obj = new URL(GET_URL);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        System.out.println(GET_URL);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);}
            in.close();
            System.out.println(response.toString());
            return response.toString();

        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return null;
    }


}
