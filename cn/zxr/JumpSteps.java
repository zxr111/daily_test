package cn.zxr;

public class JumpSteps {
    public static long jumpEasy(int num){
       int pre1 = 1;
       int pre2 = 2;
       int cur = 0;
       for(int i = 0; i < num; i++){   //后一次是前两次的合.
           cur = pre1 + pre2;
           pre1 = pre2;
           pre2 = cur;
       }
       return cur;
    }
    public static long jumpComplex(int num){
        int jumpNum = 1;
        for(int i = 1; i < num; i++){ //2 ^ (n - 1) 每个台阶有两种，最后一个台阶必须跳。
           jumpNum *= 2;
        }
        return jumpNum;
    }

    public static void main(String[] args) {
        long num = jumpEasy(20);
        long num1 = jumpComplex(20);
        System.out.println("Easyjump:" + num);
        System.out.println("Complexjump:" + num1);
    }
}
