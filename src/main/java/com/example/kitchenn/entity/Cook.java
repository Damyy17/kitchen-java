package com.example.kitchenn.entity;

import com.example.kitchenn.service.OrderService;

import java.net.URISyntaxException;

public class Cook implements Runnable{

    String name;
    OrderService orderService = new OrderService();
    Kitchen kitchen;

    public Cook(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Started thread " + name );
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            if (kitchen.isEmpty()){
                Thread.sleep(0);
            } else {
                orderService.sendOrderBack(kitchen.takeOrder());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended thread " + name);
        
    }
}
