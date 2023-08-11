package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
/*
Here I use an open(no key) api to call fun facts then print them to the console using gson
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        URL url = new URL("https://catfact.ninja/fact");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("response code: " + responseCode);

        if(responseCode == HttpURLConnection.HTTP_OK){
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNext()){
                sb.append(scanner.nextLine());
            }
            String jsonString = String.valueOf(sb);

            FunFact funFact = gson.fromJson(jsonString, FunFact.class);
            //Demonstrate separation of json string
            System.out.println(funFact);
            System.out.println("just fact: " + funFact.getFact());
            System.out.println("just length: " + funFact.getLength());

        }else{
            System.out.println("Error sending GET request");
        }
    }
}