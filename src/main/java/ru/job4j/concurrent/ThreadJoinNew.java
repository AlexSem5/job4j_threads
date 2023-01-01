package ru.job4j.concurrent;

import java.util.Objects;

public class ThreadJoinNew {
    public static void main(String[] args) throws InterruptedException {
        TestTask testTask = new TestTask();
        Runnable r = () -> condition(testTask);
        final Thread a = new Thread(r, "a");
        final Thread b = new Thread(r, "b");
        final Thread c = new Thread(r, "c");
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }
    
    private static void condition(TestTask testTask) {
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
}
