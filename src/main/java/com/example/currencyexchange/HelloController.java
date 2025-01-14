package com.example.currencyexchange;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import okhttp3.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HelloController {
    public ComboBox<String> dropDown1;
    public ComboBox<String> dropDown2;
    public TextField mainAmount;
    public Text convertedAmount;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws Exception {
        welcomeText.setText("Welcome to JavaFX Application!");

        if((dropDown1.getValue() != null && !dropDown1.getValue().equalsIgnoreCase(""))
                && (dropDown2.getValue() != null && !dropDown2.getValue().equalsIgnoreCase(""))){
            int amount = Integer.parseInt(mainAmount.getText());

            System.out.println(ExchangeRatesAPI.getConvertedAmount(amount, dropDown1.getValue(), dropDown2.getValue()));



            convertedAmount.setText(String.valueOf(ExchangeRatesAPI.getConvertedAmount(amount, dropDown1.getValue(), dropDown2.getValue())));

        } else {
            System.out.println("Nothing in boxes");
        }
    }


    public void showing(Event event) {
        try {
            dropDown1.getItems().addAll(ExchangeRatesAPI.getCurrencyCodes());
            dropDown2.getItems().addAll(ExchangeRatesAPI.getCurrencyCodes());
        } catch (Exception e) {
            System.out.println("An error was found " + e);
        }
    }
}
