package java7Network;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class TcpServer {
    //服务器名称及开放的端口
    public final String URL="127.0.0.1";
    public final int PORT=10008;


    //创建服务器
    public ServerSocket createServer(String url,int port)
    {
        ServerSocket serverSocket=null;
        try {
             serverSocket=new ServerSocket();
        } catch (IOException e) {
            System.out.println("创建服务器失败!");
        }
        //为服务器指定地址和端口
        try {
            serverSocket.bind(new InetSocketAddress(url,port));
        } catch (IOException e) {
            System.out.println("绑定地址失败！");
        }

        return serverSocket;

    }

    //服务器接收客服端的消息
    public String receiveInfo(Socket socket) throws IOException {
        //创建输入流对象
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        //创建接收消息容器
        char a[]=new char[1024];
        bufferedReader.read(a);
        //临时关闭捕获到的socket的输入流
        socket.shutdownInput();
        return new String(a);
    }

    //服务器向客服端发送消息
    public void sendInfo(Socket socket) throws IOException {
        //创建输出流
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
        //写入消息
        Scanner in= new Scanner(System.in);
        System.out.print("\nS-C"+"("+socket.getInetAddress().toString().substring(1)+"):");
        bufferedWriter.write(in.next());
        bufferedWriter.flush();
        socket.shutdownOutput();
    }

    public static void main(String[] args) throws IOException {

        TcpServer tcpServer=new TcpServer();
        //创建一个Server
        ServerSocket serverSocket=tcpServer.createServer(tcpServer.URL,tcpServer.PORT);

        while(true) {
            //监听客服端
            Socket socket = serverSocket.accept();

            //服务器接收消息
            System.out.print("C("+socket.getInetAddress().toString().substring(1)+")-S:" + tcpServer.receiveInfo(socket));

            //服务器发送消息
            tcpServer.sendInfo(socket);

        }
    }
}
