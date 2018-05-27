package cn.zxr;

import java.util.ArrayList;
import java.util.Arrays;

public class Test4 {
    public static String repl(String s){
        StringBuilder s1 = new StringBuilder();
        for(Character c : s.toCharArray()){
           if(c.toString().equals(" ")){
               System.out.println(1);
               s1.append("%20");
           }
           else
               s1.append(c);
        }
        return s1.toString();
    }
    public static void main(String[] args) {
        String s = "We are Winner";
//        String s1 = s.replaceAll(" ", "%20");
//        System.out.println(s1);
        String s1 = repl(s) ;
        System.out.println(s1);
    }
}
