package com.example.kitchenn;

import com.example.kitchenn.entity.Cook;
import com.example.kitchenn.entity.Kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KitchennApplication {

    public static void main(String[] args) {
        SpringApplication.run(KitchennApplication.class, args);
        Kitchen kitchen = new Kitchen();
        final Thread cook1 = new Thread(new Cook("cook1"));
        cook1.start();
        kitchen.printQ();

    }

}
