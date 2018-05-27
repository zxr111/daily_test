package cn.zxr;
public class Test03 {
    //题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    // 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public static boolean find(int[][] a, int b) {
        if (a[0].length < 1 && a.length < 1) {
            System.out.println("输入错误");
            return false;
        }
        int cols = a[0].length; //矩阵的宽
        int rows = a.length;    //矩阵的高
        int row = 0;
        int col = cols - 1;
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (b == a[row][col])
                return true;
            else if (b < a[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2 ,4 ,5},
                {2, 3, 7, 9},
                {4, 8, 9, 11}
        };
        if(find(a, 3))
            System.out.println("z");
//        System.out.println(1);
    }
}
