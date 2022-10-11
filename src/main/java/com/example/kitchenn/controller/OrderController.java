package com.example.kitchenn.controller;

import com.example.kitchenn.entity.Order;
import com.example.kitchenn.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(path = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> receiveOrder(@RequestBody Order order) {
        System.out.println(order.toString());
        orderService.addOrder(order);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
