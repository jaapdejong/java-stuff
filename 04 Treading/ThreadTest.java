package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    private static final Boolean myLock = false;
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        final Thread t1 = new Thread(() -> {
            // this is thread t1

            // ~~~~~~~~ TIMED_WAITING
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // don't care
            }

            // ~~~~~~~~ RUNNABLE
            int a = 1;
            for (int i = 0; i < 100; ++i) {
                a *= i;
            }

            // ~~~~~~~~ WAITING
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                // don't care
            }

            // ~~~~~~~~ BLOCKED
            synchronized (myLock) {}

            // ~~~~~~~~ TERMINATED
        });

        // this is the main thread

        // ~~~~~~~~ NEW
        while (t1.getState() != Thread.State.NEW) {}
        System.out.println("NEW");

        // start thread t1
        t1.start();

        // ~~~~~~~~ TIMED_WAITING
        while (t1.getState() != Thread.State.TIMED_WAITING) {}
        System.out.println("TIMED_WAITING");

        // ~~~~~~~~ RUNNABLE
        while (t1.getState() != Thread.State.RUNNABLE) {}
        System.out.println("RUNNABLE");

        // ~~~~~~~~ WAITING
        while (t1.getState() != Thread.State.WAITING) {}
        System.out.println("WAITING");

        // ~~~~~~~~ BLOCKED
        synchronized (myLock) {
            semaphore.release();
            while (t1.getState() != Thread.State.BLOCKED) {}
            System.out.println("BLOCKED");
        }

        // wait until thread t1 is stopped
        t1.join();

        // ~~~~~~~~ TERMINATED
        while (t1.getState() != Thread.State.TERMINATED) {}
        System.out.println("TERMINATED");

    }
}
