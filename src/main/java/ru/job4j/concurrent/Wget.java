package ru.job4j.concurrent;

public class Wget {
    public static void main(String[] args) {
        Thread thread = new Thread(Wget::sleepThenPrint);
        thread.start();
        System.out.println("back in main");
    }
    
    private static void sleepThenPrint() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.print("\rLoading : " + i  + "%");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
