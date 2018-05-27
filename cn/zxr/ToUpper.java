package cn.zxr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ToUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        ArrayList<String> arr1 = new ArrayList<>();
        for(Character c : arr){
            arr1.add(c.toString().toUpperCase());
        }
        Iterator it = arr1.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }
}
