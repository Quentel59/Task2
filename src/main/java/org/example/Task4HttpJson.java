package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4HttpJson {

    public static void run() {
        String url = "https://httpbin.org/ip";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode json = objectMapper.readTree(response.body());

            String ip = json.get("origin").asText();

            System.out.println("IP адрес: " + ip);

        } catch (Exception e) {
            System.out.println("Ошибка при выполнении HTTP запроса:");
            System.out.println(e.getMessage());
        }
    }
}