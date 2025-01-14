package com.example.currencyexchange;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ExchangeRatesAPI {
    //Set URL
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/98d1456c7657c057582eaa85";

    public static void main(String[] args) throws Exception {
        ArrayList<String> curr = getCurrencyCodes();
        System.out.println(curr);

        System.out.println(getConvertedAmount(1, "USD", "HUF"));
    }

    public static ArrayList<String> getCurrencyCodes() throws Exception {
        try {
            ArrayList<String> currencyCodes = new ArrayList<String>();

            String urlStr = API_URL + "/latest/USD";
            URL url = new URL(urlStr);


            //Open Connection to API
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            //Use get to make a request
            request.setRequestMethod("GET");
            request.connect();

            //Use input stream to read request and turn it into readable text
            InputStream response = (InputStream) request.getContent();
            InputStreamReader reader = new InputStreamReader(response);

            //Phrase text into json structure
            JsonElement root = JsonParser.parseReader(reader);

            //Convert json structure into json object
            JsonObject jsonObject = root.getAsJsonObject();

            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            System.out.println(jsonObject.getAsJsonObject("conversion_rates").size());

            for(String key : conversionRates.keySet()){
                currencyCodes.add(key);
            }

            return currencyCodes;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return null;
    }

    public static double getConvertedAmount(double amount, String codeOne, String codeTwo) throws Exception {
        try {
            String urlStr = API_URL + "/pair/" + codeOne + "/" + codeTwo + "/" + amount;

            URL url = new URL(urlStr);


            //Open Connection to API
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            //Use GET to make a request
            request.setRequestMethod("GET");
            request.connect();

            //Use input stream to read request and turn it into readable text
            InputStream response = (InputStream) request.getContent();
            InputStreamReader reader = new InputStreamReader(response);

            //Phrase as text JSON structure
            JsonElement root = JsonParser.parseReader(reader);

            //Convert JSON Structure into Json Object
            JsonObject jsonObject = root.getAsJsonObject();


            double result = jsonObject.get("conversion_result").getAsDouble();


            return result;

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return 0;
    }

}
