package cn.zxr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        // Your Code
        Integer[] arr = binary.toArray(new Integer[0]);
        int sum = 0;
        for ( int i = arr.length - 1; i >= 0; i-- ) {
            if( arr[i] == 1 )
                sum += Math.pow( 2, Math.abs(i - arr.length + 1) );
        }
        return sum;
    }

    public static void main(String[] args){
        List<Integer> bianry = Arrays.asList( 0, 1, 1, 1 );
        System.out.println( ConvertBinaryArrayToInt( bianry ) );
    }
}
