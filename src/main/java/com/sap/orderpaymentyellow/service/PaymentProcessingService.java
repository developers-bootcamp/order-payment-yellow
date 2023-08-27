package com.sap.orderpaymentyellow.service;

import com.sap.orderpaymentyellow.Dto.OrderDTO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaymentProcessingService {

    public void PaymentProcessing(OrderDTO order){
        String mockServerUrl = "https://2a9336fa-408a-40db-89e1-65c49a4dac90.mock.pstmn.io/payment?paymentAmount="+order.getPaymentAmount()+"&creditCardNumber="+order.getCreditCardNumber()+"&cvc="+order.getCvc()+"&expiryDate="+order.getExpiryOn();

        try {
            URL url = new URL(mockServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
            JsonObject jsonResponse = new Gson().fromJson(response.toString(), JsonObject.class);
            String status = jsonResponse.get("status").getAsString();
            String invoiceNumber = jsonResponse.get("invoiceNumber").getAsString();

            System.out.println("Status: " + status);
            System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Response Body: " + response.toString());

        connection.disconnect();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
