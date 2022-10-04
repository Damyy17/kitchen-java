package com.example.kitchenn.service;

import com.example.kitchenn.entity.Order;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class OrderService {


    public void sendOrderBack(Order order) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://127.0.0.1:7001/distribution";
        URI uri = new URI(baseUrl);
        restTemplate.postForEntity(uri,order, Order.class);
    }

}
