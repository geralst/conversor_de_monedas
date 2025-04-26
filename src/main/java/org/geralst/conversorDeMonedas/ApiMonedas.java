package org.geralst.conversorDeMonedas;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiMonedas {

    private static final String API_KEY = "ffc639edca14d861f9d3d5c7";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String from, String to) {
        try {
            String urlStr = BASE_URL + API_KEY + "/pair/" + from + "/" + to;
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Verificar que la respuesta HTTP sea 200 (OK)
            if (conn.getResponseCode() != 200) {
                throw new IOException("Error en la conexión: Código HTTP " + conn.getResponseCode());
            }

            // Usar try-with-resources para manejar el cierre del Scanner automáticamente
            try (Scanner scanner = new Scanner(conn.getInputStream())) {
                String response = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";

                // Parsear el String JSON a JsonObject
                JsonObject json = JsonParser.parseString(response).getAsJsonObject();

                // Extraer el valor de "conversion_rate"
                if (json.has("conversion_rate")) {
                    return json.get("conversion_rate").getAsDouble();
                } else {
                    System.out.println("Respuesta inesperada de la API: " + json.toString());
                    return 1.0;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 1.0;
        }
    }
}
