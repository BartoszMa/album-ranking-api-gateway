package com.example.albumrankingapigateway.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletResponse response) throws IOException {
        response.sendRedirect(System.getenv("FRONTEND_URI") + "/profile");
        return "error";
    }

}
