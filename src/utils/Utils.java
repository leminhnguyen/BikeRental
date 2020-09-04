package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.net.*;

public class Utils {

    public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final String POST_URL = "https://ecopark-system-api.herokuapp.com/api/card/balance/118609_group1_2020";
    public static final String POST_DATA = "{\"userId\": 100,\"id\": 100,\"title\": \"main title\",\"body\": \"main body\"}";
    
    public static long getMinutes(Date date1, Date date2){
        return TimeUnit.MILLISECONDS.toMinutes(date2.getTime()-date1.getTime());
    }

    public static void readBarCode(String barcode) throws Exception{

        String[] details = {};
        System.out.println(Arrays.toString(details));

        URL line_api_url = new URL(POST_URL);
        String payload = POST_DATA;

        HttpURLConnection linec = (HttpURLConnection) line_api_url
                .openConnection();
        linec.setDoInput(true);
        linec.setDoOutput(true);
        linec.setRequestMethod("GET");
        linec.setRequestProperty("Content-Type", "application/json");
        linec.setRequestProperty("Authorization", "Bearer "
                + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiIxMTg2MDlfZ3JvdXAxXzIwMjAiLCJpYXQiOjE1OTkxMTk5NDl9.y81pBkM0pVn31YDPFwMGXXkQRKW5RaPIJ5WW5r9OW-Y");

        // OutputStreamWriter writer = new OutputStreamWriter(
        //         linec.getOutputStream(), "UTF-8");
        // writer.write(payload);

        BufferedReader in = new BufferedReader(new InputStreamReader(
                linec.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }

    public static void main(String[] args) {
        try {
            readBarCode("barcode");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
