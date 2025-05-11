package 多线程.leetcode1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private Semaphore semaphoreZero = new Semaphore(1);
    private Semaphore semaphoreOdd = new Semaphore(0);
    private Semaphore semaphoreEven = new Semaphore(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= n; i++){
            semaphoreZero.acquire();
            printNumber.accept(0);
            if(i % 2 == 0){
                semaphoreEven.release();
            }
            else{
                semaphoreOdd.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i+=2){
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i+=2){
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }
    public static void main(String[] args) {

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);

        IntConsumer intConsumer = (x) -> System.out.println(x);

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        zeroThread.start();
        oddThread.start();
        evenThread.start();
    }
}
