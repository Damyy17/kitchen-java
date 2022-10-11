package com.example.kitchenn.service;

import com.example.kitchenn.entity.Order;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class OrderService {

    private static BlockingQueue<Order> kitchenQueue = new LinkedBlockingQueue<>();
    final static int NR_OF_THREADS = 5;
    static ReentrantLock mutex = new ReentrantLock();
    OrderService orderService;


    public static void sendOrderBack(Order order) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://127.0.0.1:7001/distribution";
        URI uri = new URI(baseUrl);

        try {
            restTemplate.postForEntity(uri, order, Order.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    public static void runServerWithThreads(){
        for (int i = 1; i <= NR_OF_THREADS; i++) {
            new Thread(() -> sendToDiningHall()).start();
        }
    }

    public static void sendToDiningHall(){
        while(true){
            mutex.lock();
            if (!kitchenQueue.isEmpty()) {
                Order order;
                try {
                    order = kitchenQueue.take();
                    sendOrderBack(order);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mutex.unlock();
        }
    }

    public void addOrder(Order order){
        kitchenQueue.add(order);
    }

}
