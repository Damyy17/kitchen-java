package com.example.kitchenn.entity;

import java.util.LinkedList;
import java.util.Queue;

public class Kitchen {
    private final Queue<Order> kitchenQueue = new LinkedList<>();

    public void addOrderToKitchen(Order order){
        kitchenQueue.add(order);
    }

    public Order takeOrder(){
        return kitchenQueue.remove();
    }

    public boolean isEmpty(){
        return kitchenQueue.isEmpty();
    }

    public void printQ(){
        for (Order order : kitchenQueue) {
            System.out.println(order.toString());
        }
    }
}
