package 多线程.leetcode1114;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore second = new Semaphore(0);
    private Semaphore third = new Semaphore(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        printThird.run();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");
        Thread t1 = new Thread(() -> {
            try { foo.first(printFirst); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        Thread t2 = new Thread(() -> {
            try { foo.second(printSecond); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        Thread t3 = new Thread(() -> {
            try { foo.third(printThird); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        t2.start();
        t3.start();
        t1.start();
    }
} 