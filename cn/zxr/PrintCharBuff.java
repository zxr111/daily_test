package cn.zxr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PrintCharBuff {
    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("F:/3.txt").getChannel() ;
        ByteBuffer buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("asdhasfjkjfa");
        fc.write(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        fc.close();

    }
}
