package cn.zxr;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Client {
//    private Socket socket = null;
//    public Client()
//    {
//       Connect();
//    }
//    //连接
//    public void Connect(){
//        try {
//            socket = new Socket("localhost", 7777);
//            System.out.println("连接成功, 请输入姓名");
//            Scanner sc = new Scanner(System.in);
//            String name = sc.nextLine();
//            SendMessage(name);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    //发送信息
//    public void SendMessage(String ms){
//        try {
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            out.write(ms);
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    //接收信息
//    public String GetMessage(){
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            return in.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static void main(String[] args) {
        Socket socket;
        BufferedInputStream in;
        BufferedOutputStream out;
        PrintWriter pw;
        BufferedReader br;
        try {
            socket = new Socket("localhost", 7777);
            try{
                in = new BufferedInputStream(socket.getInputStream());
                out = new BufferedOutputStream(socket.getOutputStream());
                System.out.println("请输入姓名");
                Scanner sc = new Scanner(System.in);
                out.write(sc.nextLine().getBytes());
                System.out.println("开始聊天吧");
                String s;
//                while (true){
//                    while ((s = in.readLine()) != null){
//                        pw.println(s);
//                    }
//                }
            }finally {
//                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//class ThreadClient implements Runnable{
//    private int port;
//    private Socket socket;
//   public ThreadClient(int port) {
//       this.port = port;
//       try {
//           socket = new Socket("localhost", port);
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
//   }
//
//    @Override
//    public void run() {
//       while (true){
//           Scanner sc = new Scanner(System.in);
//           try {
//               BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
//               String str = sc.nextLine();
//               out.write(str.getBytes());
//               out.flush();
//           } catch (IOException e) {
//               e.printStackTrace();
//           }
//       }
//    }
//}
