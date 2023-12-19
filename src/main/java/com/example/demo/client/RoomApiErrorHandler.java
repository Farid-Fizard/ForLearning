package com.example.demo.client;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
//@Component
public class RoomApiErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode().is4xxClientError()||clientHttpResponse.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if(clientHttpResponse.getStatusCode().is4xxClientError()){
            throw new ResourceNotFound404();

        }
        if(clientHttpResponse.getStatusCode().is5xxServerError()){
            throw new RuntimeException(clientHttpResponse.getStatusText());
        }

    }
}
