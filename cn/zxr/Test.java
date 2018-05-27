package cn.zxr;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Test {
    public  static String read(String filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        LinkedList l = new LinkedList();
        String s;
//        String filename = args[0];
        BufferedReader br = new BufferedReader(new FileReader("F:/3.txt"));
        while ((s = br.readLine()) != null){
            l.add(s + "\n");
        }
        l.push("a");
//        System.out.print(l);
        Iterator it = l.iterator();
        ArrayList arr = new ArrayList();
        while (it.hasNext()){
            arr.add(l.pollLast());
        }
        System.out.println();
    }
}
