package ru.job4j.concurrent;

public class ThreadStop {
    public static void main(String[] args) {
        try {
            Thread progress = new Thread(new ConsoleProgress());
            progress.start();
            Thread.sleep(3000); /*второй поток выполняется в течение этого времени*/
            progress.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
