package com.example.kitchenn.service;

import com.example.kitchenn.entity.Order;
import com.example.kitchenn.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class OrderService {

    final static int NR_OF_THREADS = 5;
    static ReentrantLock mutex = new ReentrantLock();

    @Autowired
    private OrderRepository orderRepository;

    public static void sendOrderBack(Order order) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://127.0.0.1:7003/aggregator2";
        URI uri = new URI(baseUrl);

        try {
            restTemplate.postForEntity(uri, order, Order.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    public static Order takeOrder() throws InterruptedException {
        return OrderRepository.takeOrder();
    }

    public void addOrder(Order order) throws InterruptedException {
        orderRepository.addData(order);
    }

    public static void sendToAggregator() {
        while (true) {
            mutex.lock();
            Order order;
            try {
                order = takeOrder();
                sendOrderBack(order);
            } catch (URISyntaxException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mutex.unlock();
        }
    }

    public static void runServerWithThreads() {
        for (int i = 1; i <= NR_OF_THREADS; i++) {
            Thread agThread = new Thread(OrderService::sendToAggregator);
            agThread.start();
        }
    }

}
