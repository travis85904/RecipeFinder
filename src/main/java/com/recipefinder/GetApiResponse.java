package com.recipefinder;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class GetApiResponse {

    static Recipe[] getJsonArray(String query) throws IOException, InterruptedException {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("private/config.properties");
        properties.load(fileInputStream);
        String apiKey = properties.getProperty("api.key");
    
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://recipe-by-api-ninjas.p.rapidapi.com/v1/recipe?query=" + query.replaceAll(" ", "%20")))
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "recipe-by-api-ninjas.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Recipe[] recipes = gson.fromJson(response.body(), Recipe[].class);

        return gson.fromJson(response.body(), Recipe[].class);
    }

}