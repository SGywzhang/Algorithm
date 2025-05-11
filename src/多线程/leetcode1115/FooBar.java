package 多线程.leetcode1115;

import java.util.concurrent.*;

public class FooBar {
    private int n;
    private Semaphore fooSemphore = new Semaphore(1);
    private Semaphore barSemphore = new Semaphore(0);

    public FooBar(int n){
         this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i = 0; i < n; i++){
            fooSemphore.acquire();
            printFoo.run();
            barSemphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException{
        for(int i = 0; i < n; i++){
            barSemphore.acquire();
            printBar.run();
            fooSemphore.release();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);

        Runnable printFoo = () -> System.out.println("Foo");
        Runnable printBar = () -> System.out.println("Bar");

        Thread foo_thread = new Thread(() -> {
            try{
                fooBar.foo(printFoo);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread bar_thread = new Thread(() -> {
            try{
                fooBar.bar(printBar);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        foo_thread.start();
        bar_thread.start();
    }
}
