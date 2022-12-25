package ru.job4j.concurrent;

/**
 * Interrupt example Oracledocs
 */

public class SleepMesNew {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(() -> {
            String[] importantInfo = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            System.out.println(Thread.currentThread().getName());
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    /*Pause for 4 seconds*/
                    Thread.sleep(4000);
                    /*We've been interrupted: no more messages*/
                    /*Print a message*/
                    System.out.println(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                return;
            }
            System.out.println("in Thread 0");
        });
        first.start();
        first.interrupt();
        first.join();
        System.out.println("The end");
    }
}
