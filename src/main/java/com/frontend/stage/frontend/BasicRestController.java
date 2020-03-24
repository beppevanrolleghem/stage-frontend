package com.frontend.stage.frontend;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class BasicRestController {

    @RequestMapping("/")
    public String index() {
        return "it works!";
    }


    @RequestMapping("/stage-frontend")
    public String index2() { return "it do work"; }


    @RequestMapping("/stage-frontend/check")
    public String getBackend() throws Exception {
        return doRequest("http://stage-backend-service");
    }

    public String doRequest(String addr) throws Exception {
        URL url = new URL(addr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        String responseVal;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            responseVal = response.toString();
        } else {
            throw new Exception("something went wrong");
        }
        return responseVal;
    }


}
