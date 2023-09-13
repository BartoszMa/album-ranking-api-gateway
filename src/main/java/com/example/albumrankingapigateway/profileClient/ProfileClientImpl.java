package com.example.albumrankingapigateway.profileClient;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

@Service
public class ProfileClientImpl implements ProfileClient {

    @Override
    public String getUserProfile(String accessToken) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(System.getenv("USER_PROFILE_SERVICE_URI") + "/profile-info/" + accessToken))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());
        return response.body();

    }

}
