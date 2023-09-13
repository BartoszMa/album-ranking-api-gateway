package com.example.albumrankingapigateway.controller;


import com.example.albumrankingapigateway.profileClient.ProfileClient;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Resource
    private ProfileClient profileClient;

    @GetMapping("currentUser")
    public ResponseEntity<String> userProfile(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient) throws IOException, InterruptedException {
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        return ResponseEntity.ok(profileClient.getUserProfile(accessToken.getTokenValue()));
    }

}
