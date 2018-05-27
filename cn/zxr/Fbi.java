package cn.zxr;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Fbi {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            results.add(exec.submit(new ThreadFbi(10)));
        }
        for(Future<Integer> i : results){
            try{
                System.out.println(i.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}

class ThreadFbi implements Callable<Integer> {
    private int n;
    private int f1 = 1;
    private int f2 = 1;
    private int sum = 2;
    int temp;
    public ThreadFbi(int n){
       this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        for(int i = 0; i < n; i++){
            temp = f2;
            f2 = f1 + f2;
            f1 = temp;
            sum += f2;
        }
        return sum;
    }
}