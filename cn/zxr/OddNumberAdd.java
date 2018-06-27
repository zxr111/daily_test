package cn.zxr;

public class OddNumberAdd {
      public static long rowSumOddNumbers(int n) {
             //TODO
             int ini = 1;
             long sum = 0;
             int addnum = (1 + n) * n / 2 - 1;
             if (n == 1)
                    return 1;
             for (int i = 0; i < addnum; i++)
             {
                    ini += 2;
                    if ( (addnum - 1) - i <= (n - 1) )
                           sum += ini;
             }
             return sum;
      }

    public static void main(String[] args) {
        System.out.println( rowSumOddNumbers(42) );
    }
}
