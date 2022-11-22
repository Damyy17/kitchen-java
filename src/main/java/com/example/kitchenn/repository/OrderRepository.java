package com.example.kitchenn.repository;

import com.example.kitchenn.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Repository
public class OrderRepository {
    private static final BlockingQueue<Order> data = new LinkedBlockingQueue<>();
    private int maxSize;
    private final Object FULL_QUEUE = new Object();
    private final Object EMPTY_QUEUE = new Object();

    public void addData(Order order) throws InterruptedException {
        data.put(order);
    }

    public static Order takeOrder() throws InterruptedException {
        return data.take();
    }

}
