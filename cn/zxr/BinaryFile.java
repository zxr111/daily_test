package cn.zxr;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFile {
    public static byte[] read(File bFile) throws IOException{
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try{
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }finally {
            bf.close();
        }
    }
    public static byte[] read(String bFile) throws IOException{
       return read(new File(bFile));
    }

    public static void main(String[] args) {
        File file = new File("F:/3.txt");
        try {
            byte[] bf = read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
