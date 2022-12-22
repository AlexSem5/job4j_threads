package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    
    @Override
    public void run() {
        try {
            char[] symbols = {'-', '\\', '|', '/'};
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(500);
                System.out.print("\r load: " + symbols[i++]);
                if (i >= symbols.length) {
                    i = 0;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
