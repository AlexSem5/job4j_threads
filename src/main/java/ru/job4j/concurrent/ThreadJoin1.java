package ru.job4j.concurrent;

public class ThreadJoin1 {
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }
    
    private static class ThreadJob1 implements Runnable {
        private Thread next;
        
        @Override
        public void run() {
            threadMessage("Started");
            if (next != null) {
                try {
                    next.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            threadMessage("Terminated");
        }
        
        public void setNext(Thread thread) {
            this.next = thread;
        }
    }
    
    public static void main(String[] args) {
        ThreadJob1 job1 = new ThreadJob1();
        ThreadJob1 job2 = new ThreadJob1();
        ThreadJob1 job3 = new ThreadJob1();
        final Thread a = new Thread(job1, "a");
        final Thread b = new Thread(job2, "b");
        final Thread c = new Thread(job3, "c");
        job1.setNext(b);
        job2.setNext(c);
        a.start();
        b.start();
        c.start();
    }
}
