package ru.job4j.concurrent;

public class SleepMessages {
    public static void main(String[] args)
            throws InterruptedException {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        System.out.println(Thread.currentThread().getName());
        for (int i = 0;
             i < importantInfo.length;
             i++) {
            /*Pause for 4 seconds*/
            Thread.sleep(4000);
            /*Print a message*/
            System.out.println(importantInfo[i]);
        }
    }
}
