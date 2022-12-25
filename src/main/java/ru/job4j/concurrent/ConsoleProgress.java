package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    
    @Override
    public void run() {
        char[] symbols = {'-', '\\', '|', '/'};
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print("\r load: " + symbols[i++]);
            if (i >= symbols.length) {
                i = 0;
            }
        }
    }
}

