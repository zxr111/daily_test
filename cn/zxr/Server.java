package cn.zxr;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket;
        while (true){
           socket = serverSocket.accept();
           Thread t = new Thread(new ThreadServer(socket));
           t.start();
        }
    }
}

class ThreadServer implements Runnable{
//    private ServerSocket serverSocket = null;
//    private Socket socket = null;
//    public ThreadServer(Socket socket){
//        this.socket = socket;
//    }
//    //接收信息
//    public String GetMessage(){
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            return new String(in.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "错误信息";
//    }
//    //发送信息
//    public void SendMessage(String ms){
//        try {
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            out.write(ms);
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    private  Socket socket;
    public ThreadServer(Socket socket){
        this.socket = socket;
    }
    public void run() {
        BufferedOutputStream out;
        BufferedInputStream in;
        try {
            try{
                in = new BufferedInputStream(socket.getInputStream());
                out = new BufferedOutputStream(socket.getOutputStream());
                byte[] ms = in.readAllBytes();
                System.out.println(ms.toString() + "加入");
                String s;
//                while (true){
//                   while ((s = in.readLine()) != null){
//                       System.out.println(s);
//                   }
//                }
            }finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

