package com.example.currencyexchange;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.HashMap;

import static com.example.currencyexchange.ExchangeRatesAPI.getCurrencyCodes;

public class HelloController {
    public ComboBox<String> dropDown1;
    public ComboBox<String> dropDown2;
    public TextField mainAmount;
    public Text convertedAmount;
    public Text nameOne;
    public Text nameTwo;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws Exception {
        //welcomeText.setText("Welcome to JavaFX Application!");

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
            HashMap<String, String> curr = getCurrencyCodes();
            for (String code : curr.keySet()) {
                dropDown1.getItems().add(code);
                dropDown2.getItems().add(code);
            }
        } catch (Exception e) {
            System.out.println("An error was found " + e);
        }
    }

    public void clicked(ActionEvent mouseEvent) throws Exception {
        HashMap<String, String> curr = getCurrencyCodes();
        nameOne.setText(curr.get(dropDown1.getValue()));

    }

    public void clicked2(ActionEvent actionEvent) throws Exception {
        HashMap<String, String> curr = getCurrencyCodes();
        nameTwo.setText(curr.get(dropDown2.getValue()));
    }
}
