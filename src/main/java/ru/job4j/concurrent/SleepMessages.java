package ru.job4j.concurrent;
/**
 * Interrupt example Oracledocs
 */
public class SleepMessages {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(() -> {
            String[] importantInfo = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < importantInfo.length; i++) {
                /*Pause for 4 seconds*/
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    /*We've been interrupted: no more messages*/
                    return;
                }
                /*Print a message*/
                System.out.println(importantInfo[i]);
            }
        });
        first.start();
        first.interrupt();
        first.join();
        System.out.println("The end");
    }
}
