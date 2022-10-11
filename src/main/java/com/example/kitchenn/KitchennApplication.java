package com.example.kitchenn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.kitchenn.service.OrderService;

@SpringBootApplication
public class KitchennApplication {

    public static void main(String[] args) {
        SpringApplication.run(KitchennApplication.class, args);
        OrderService.runServerWithThreads();
    }

}
