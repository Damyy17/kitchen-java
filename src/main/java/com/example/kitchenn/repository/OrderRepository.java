package com.example.kitchenn.repository;

import com.example.kitchenn.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Repository
public class OrderRepository {
    private static final BlockingQueue<Order> data = new LinkedBlockingQueue<>();

    public void addData(Order order){
        data.add(order);
    }

    public static Order takeOrder() throws InterruptedException {
        return data.take();
    }

    public static boolean checkIfEmpty(){
        return data.isEmpty();
    }
}
