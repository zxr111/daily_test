package cn.zxr;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new TestThread());
        Thread thread2 = new Thread(new TestThread());
        Thread thread3 = new Thread(new TestThread());
        Thread thread4 = new Thread(new TestThread());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class TestThread implements Runnable{
    public TestThread(){
        System.out.println("start");
    }

    @Override
    public void run() {
        while (true){
           for(int i = 0; i < 3; i++) {
               System.out.println("hello");
               Thread.yield();
           }
           System.out.println("end");
           break;
        }
    }
}
