package cn.zxr;

public class Test12 {
    //求x^y
    public static double Solution(double x, int y){
        double res = 1;
       if(y == 0)
           return 0;
       else if(y > 0){
           for(int i = 0; i < y; i++)
               res *= x;
           return res;
       }
       else {
           double x1 = (double) 1 / x;
           for (int i = 0; i < -y; i++)
               res *= x1;
           return res;
       }
    }

    public static void main(String[] args) {
        double res = Solution(-0.5, -2);
        System.out.println(res);
    }
}
