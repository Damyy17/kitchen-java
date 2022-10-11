// package com.example.kitchenn.entity;

// import java.net.URISyntaxException;
// import java.util.concurrent.locks.ReentrantLock;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.example.kitchenn.service.OrderService;

// public class Cook implements Runnable{

//     String name;
//     ReentrantLock mutex = new ReentrantLock();

//     @Autowired
//     OrderService orderService;

//     public Cook(String name){
//         this.name = name;
//     }

//     @Override
//     public void run() {
//         System.out.println("Started thread " + name );

//         try {
//             Thread.sleep(4000);
//         } catch (InterruptedException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//         while(true){
//             mutex.lock();
//             // if (!orderService.isEmpty()) {
//             //     try {
//             //         orderService.sendOrderBack();
//             //     } catch (URISyntaxException e) {
//             //         e.printStackTrace();
//             //     }
//             // }
//             mutex.unlock();
//         }
//     }
// }
