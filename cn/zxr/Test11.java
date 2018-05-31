package cn.zxr;
//计算一个整数中位一的个数
public class Test11 {
    public static int countBit1(int num){
        int count = 0;
        while(num != 0){
           count++;
           num = (num - 1) & num;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(countBit1(13));
    }
}
