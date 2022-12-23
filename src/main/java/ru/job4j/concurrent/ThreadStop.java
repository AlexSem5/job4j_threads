package ru.job4j.concurrent;

/**
 * Interruption of blocked thread
 */
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(3000); /*второй поток выполняется в течение этого времени*/
        progress.interrupt();
    }
}
