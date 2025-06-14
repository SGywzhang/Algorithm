package 多线程.leetcode1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private int current = 1;
    private Semaphore sem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            sem.acquire();
            if (current > n) {
                sem.release();
                break;
            }
            if (current % 3 == 0 && current % 5 != 0) {
                printFizz.run();
                current++;
            }
            sem.release();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            sem.acquire();
            if (current > n) {
                sem.release();
                break;
            }
            if (current % 5 == 0 && current % 3 != 0) {
                printBuzz.run();
                current++;
            }
            sem.release();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            sem.acquire();
            if (current > n) {
                sem.release();
                break;
            }
            if (current % 15 == 0) {
                printFizzBuzz.run();
                current++;
            }
            sem.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            sem.acquire();
            if (current > n) {
                sem.release();
                break;
            }
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
            }
            sem.release();
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread t1 = new Thread(() -> {
            try { fizzBuzz.fizz(() -> System.out.print("fizz ")); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        Thread t2 = new Thread(() -> {
            try { fizzBuzz.buzz(() -> System.out.print("buzz ")); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        Thread t3 = new Thread(() -> {
            try { fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz ")); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        Thread t4 = new Thread(() -> {
            try { fizzBuzz.number(x -> System.out.print(x + " ")); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
} 