package ru.gb.lecture05.lecturerCode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculator {
    public static void main(String[] args) {
        // Example shows how thread pools and task queueing works with threads
        Scanner in = new Scanner(System.in);
        Queue<Task1> queue = new ArrayDeque();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread taskService = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    executor.submit(() -> {
                        Task1 task1 = queue.poll();
                        if (task1 != null) {
                            System.out.print("Task" + task1 + " start execution: ");
                            task1.run();
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        taskService.start();
        System.out.println("Start entering your values fast and see how the thread manages to print your entries.");

        while (in.hasNextLine()) {
            try {
                int value = Integer.parseInt(in.nextLine().trim());
                Task1 task1 = new Task1(value);
                queue.add(task1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
