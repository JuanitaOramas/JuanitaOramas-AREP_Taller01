package edu.eci.arep;


import java.net.*;
import java.io.*;



public class HttpClient{
    private static final String USER_AGENT = "Chrome";
    private static final String GET_URL = "http://localhost:35000/infomovie?t=indiana";
//    private static final String GET_URL = "http://www.omdbapi.com/?apikey=628586c8&\" + query";

//    private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";


    public static void main(String[] args) throws IOException {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            // print result
            System.out.println(response.toString());
        } else {System.out.println("GET request not worked");}
        System.out.println("GET DONE");
    }



}
