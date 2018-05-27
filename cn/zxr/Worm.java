package cn.zxr;

import java.io.*;

class Data implements Serializable{
    private int n;
    public Data(int n){this.n = n;}
    public String toString() {return Integer.toString(n);}
}
public class Worm implements Serializable{
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:/3.txt"));
            out.writeObject(new A(1));
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:/3.txt"));
            A a = (A)in.readObject();
            System.out.print(a.getN());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class A implements Serializable{
    private int n;
    public A(int n){
       this.n = n;
    }

    public int getN() {
        return n;
    }
}

