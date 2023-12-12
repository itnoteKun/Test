package com.xianC.SocketTCP;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketSever {
    public static void main(String[] args) throws Exception{
        System.out.println("服务端启动：");
        ServerSocket serverSocket=new ServerSocket(3456);// 开放端口
        System.out.println("正在监听3456：");
        Socket socket=serverSocket.accept();  //监听
        InputStream inputStream=socket.getInputStream(); //读取客户端输入的数据

        byte[] bytes=new byte[1024];
        int length=inputStream.read(bytes);
        String string=new String(bytes,0,length);

        System.out.println(socket.getInetAddress().getHostAddress()+":"+string);//IP地址：输出
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
