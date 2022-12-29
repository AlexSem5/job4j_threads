package ru.job4j.concurrent;

import java.util.Objects;

public class ThreadJoin1 {
    
    private static class ThreadJob1 implements Runnable {
        
        private Thread next;
        
        private final TestTask testTask = new TestTask();
        
        @Override
        public void run() {
            if (next != null) {
                try {
                    next.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.equals(Thread.currentThread().getName(), "a")) {
                testTask.first();
            }
            if (Objects.equals(Thread.currentThread().getName(), "b")) {
                testTask.second();
            }
            if (Objects.equals(Thread.currentThread().getName(), "c")) {
                testTask.third();
            }
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
        job3.setNext(b);
        job2.setNext(a);
        a.start();
        b.start();
        c.start();
    }
}
