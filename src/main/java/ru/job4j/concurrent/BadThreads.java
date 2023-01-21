package ru.job4j.concurrent;

public class BadThreads {
    /*static String message;*/
    private static Message message = new Message();
    private static String printMessage = message.getMessage();
    
    private static class CorrectorThread extends Thread {
        
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
/*
             Key statement 1:
*/
            synchronized (message) {
                printMessage = "2";
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        CorrectorThread thread = new CorrectorThread();
        thread.start();
        synchronized (message) {
            printMessage = "1";
        }
        Thread.sleep(2000);
/*
             Key statement 2:
*/
        System.out.println(printMessage);
    }
}

class Message {
    private String message;
    
    public String getMessage() {
        return this.message;
    }
}
