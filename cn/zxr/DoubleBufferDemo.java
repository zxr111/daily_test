package cn.zxr;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class DoubleBufferDemo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{ 1, 2, 3});
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{1.1, 1.222, 1.34}) ;
//        while (db.hasRemaining()){
//            double d = db.get();
//            System.out.print(d + ",");
//        }
        ib.flip();
        while (ib.hasRemaining()){
            int i = ib.get();
            System.out.print(i + ",");
        }
    }
}
