package main.java.com.xianC.SocketTCP;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketUser {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动：");
        Socket socket=new Socket(InetAddress.getLocalHost(),3456);
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("我来串门了！".getBytes());
        outputStream.close();
        socket.close();
    }
}
