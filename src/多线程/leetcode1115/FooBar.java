package 多线程.leetcode1115;

import java.util.concurrent.*;

public class FooBar {
    private int n;
    private Semaphore fooSemphore = new Semaphore(1);
    private Semaphore barSemphore = new Semaphore(0);

    public FooBar(int n){

    }
}
