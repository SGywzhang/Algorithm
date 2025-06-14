package 多线程.leetcode1279;

import java.util.concurrent.Semaphore;

public class TrafficLight {
    private Semaphore roadA = new Semaphore(1);
    private Semaphore roadB = new Semaphore(0);
    private int road = 1;

    public TrafficLight() {}

    public void carArrived(
        int carId,           // 汽车编号
        int roadId,          // 当前道路编号: 1 (A), 2 (B)
        int direction,       // 行驶方向: 1 (直行), 2 (左转), 3 (右转)
        Runnable turnGreen,  // 开绿灯
        Runnable crossCar    // 过路口
    ) {
        try {
            if (roadId == 1) {
                roadA.acquire();
                if (road != 1) {
                    turnGreen.run();
                    road = 1;
                }
                crossCar.run();
                roadA.release();
            } else {
                roadB.acquire();
                if (road != 2) {
                    turnGreen.run();
                    road = 2;
                }
                crossCar.run();
                roadB.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        Runnable turnGreen = () -> System.out.print("Green ");
        Runnable crossCar = () -> System.out.print("Car ");
        for (int i = 1; i <= 5; i++) {
            int carId = i;
            int roadId = (i % 2) + 1;
            int direction = 1;
            new Thread(() -> light.carArrived(carId, roadId, direction, turnGreen, crossCar)).start();
        }
    }
} 