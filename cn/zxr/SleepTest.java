package cn.zxr;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        int i;
        Random rand = new Random();
        while (true){
           i = rand.nextInt(10000);
           System.out.println("sleep" + i +" seconds");
           TimeUnit.MILLISECONDS.sleep(i);
        }
    }
}
