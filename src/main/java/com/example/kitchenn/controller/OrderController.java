package com.example.kitchenn.controller;

import com.example.kitchenn.entity.Kitchen;
import com.example.kitchenn.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Queue;

@RestController
public class OrderController {

//    public Queue<Order> kitchenQueue = new LinkedList<>();
    Kitchen kitchen = new Kitchen();

    @PostMapping(path = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> receiveOrder(@RequestBody Order order) {
        System.out.println(order.toString());
        kitchen.addOrderToKitchen(order);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
