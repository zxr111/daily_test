package cn.zxr;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s + "\n");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }finally {
                in.close();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return sb.toString();
    }
    public static void write(String fileName, String text){
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                out.print(text);
            }finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public TextFile(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")) remove(0);
    }
    public TextFile(String fileName) throws IOException {
        this(fileName, "\n");
    }
    public void write(String fileName){
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for(String item : this)
                    out.println(item);
            }finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static public Map<Character, Integer> count(String fileName){
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        try {
            String s = TextFile.read("F:/3.txt");
            System.out.println(s);
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(i != 0 && arr[i - 1] != arr[i]){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
//        try {
//            String file = read("F:\\3.txt");
//            write("F:\\test.txt", file);
//            TextFile text = new TextFile("F:\\test.txt");
//            TreeSet<String> words = new TreeSet<>(new TextFile(file, "\\W+"));
//            System.out.println(words.headSet("a"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Map map = count("F:/3.txt");
    }
}
