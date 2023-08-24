package com.sap.orderpaymentyellow.service;

import com.sap.orderpaymentyellow.Dto.OrderDTO;
import com.sap.orderpaymentyellow.Dto.OrderMapper;
import com.sap.orderpaymentyellow.Dto.SendPaymentDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaymentProcessingService {

    public void PaymentProcessing(){
        String mockServerUrl = "https://b2303d8d-4745-4fe6-96b9-631269866598.mock.pstmn.io/payment";

        try {
            URL url = new URL(mockServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestBody = "{\"paymentAmount\":100.0,\"creditCardNumber\":\"987654321000\",\"expiryDate\":\"03/33\",\"ccv\":\"333\"}";
            //String requestBody = OrderMapper.INSTANCE.orderToOrderDTO(o).toString();
           // SendPaymentDTO requestBody=new SendPaymentDTO(100,987654321000L,"03/33","333");
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
    }

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
            int invoiceNumber = jsonResponse.get("invoiceNumber").getAsInt();
            System.out.println("Status: " + status);
            System.out.println("Invoice Number: " + invoiceNumber);

            connection.disconnect();
} catch (IOException e) {
        e.printStackTrace();
        }
        }
}
