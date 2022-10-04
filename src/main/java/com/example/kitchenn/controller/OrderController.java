package com.example.kitchenn.controller;

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

    Queue<Order> kitchenQueue = new LinkedList<>();

    @PostMapping(path = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> receiveOrder(@RequestBody Order order) {
        System.out.println(order.toString());
        kitchenQueue.add(order);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
