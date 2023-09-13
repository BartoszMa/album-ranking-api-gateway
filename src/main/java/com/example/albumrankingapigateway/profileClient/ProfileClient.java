package com.example.albumrankingapigateway.profileClient;

import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface ProfileClient {
    String getUserProfile(String accessToken) throws IOException, InterruptedException;
}
