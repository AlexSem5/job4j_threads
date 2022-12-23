package ru.job4j.concurrent;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            System.out.println("we are looping in main: " + first.getName() + " is " + first.getState());
            System.out.println("we are looping in main: " + second.getName() + " is " + second.getState());
        }
        System.out.println("We are in main after the loop: " + first.getName() + " is " + first.getState());
        System.out.println("We are in main after the loop: " + second.getName() + " is " + second.getState());
        System.out.println("The work is done");
    }
}

