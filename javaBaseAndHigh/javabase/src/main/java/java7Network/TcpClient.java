package java7Network;

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TcpClient {
    //服务器名称及开放的端口
    private String serverUrl;
    private int port;

    public TcpClient() {
    }

    public TcpClient(String serverUrl, int port) {
        this.serverUrl = serverUrl;
        this.port = port;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    //创建通道
    public Socket createClient(String serverUrl,int port) throws IOException {
        return new Socket(serverUrl,port);
    }



    //向服务器发送消息
    public void sendServer(Socket socket) throws IOException {
        //创建输出流对象
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
        //获取输出的内容
        Scanner in=new Scanner(System.in);
        System.out.print("C-S:");
        bufferedWriter.write(in.next());
        bufferedWriter.flush();
        socket.shutdownOutput();

    }


    //接收服务器的消息
    public void receiveServer(Socket socket) throws IOException {
        //创建输入流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        //创建接收消息的容器
        char a[]=new char[1024];
        br.read(a);
        socket.shutdownInput();
        String read=new String(a);
        System.out.println("S-C:"+read);
    }


    public static void main(String[] args) throws IOException {

        TcpClient tcpClient=new TcpClient("127.0.0.1",10008);


        while(true) {
            Socket socket=tcpClient.createClient(tcpClient.getServerUrl(),tcpClient.getPort());
            //向服务器发送消息
            tcpClient.sendServer(socket);
            //接收服务器消息
            tcpClient.receiveServer(socket);

        }
    }
}
