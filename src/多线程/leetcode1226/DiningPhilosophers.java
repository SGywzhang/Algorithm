package 多线程.leetcode1226;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private Lock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork in order.
    public void wantsToEat(int philosopher,
                          Runnable pickLeftFork,
                          Runnable pickRightFork,
                          Runnable eat,
                          Runnable putLeftFork,
                          Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % 5;
        Lock first = forks[Math.min(left, right)];
        Lock second = forks[Math.max(left, right)];
        first.lock();
        second.lock();
        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            second.unlock();
            first.unlock();
        }
    }

    public static void main(String[] args) {
        DiningPhilosophers philosophers = new DiningPhilosophers();
        Runnable pickLeftFork = () -> System.out.print("PickLeft ");
        Runnable pickRightFork = () -> System.out.print("PickRight ");
        Runnable eat = () -> System.out.print("Eat ");
        Runnable putLeftFork = () -> System.out.print("PutLeft ");
        Runnable putRightFork = () -> System.out.print("PutRight ");
        for (int i = 0; i < 5; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    philosophers.wantsToEat(id, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
} 