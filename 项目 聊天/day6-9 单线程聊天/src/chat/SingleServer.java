package chat;


import jdk.nashorn.internal.ir.WhileNode;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
    public static void main(String[] args) {
        System.out.println("服务端启动，等待连接：>");
        try {
//           创建 服务端
            ServerSocket serverSocket = new ServerSocket(8080);
//                阻塞，等待客户端输入
            Socket client = serverSocket.accept();

            //            输出 输出到客户端
            Scanner scannerOut = new Scanner(System.in);
//            自定义分隔符
            scannerOut.useDelimiter("\n");
//            使用打印流输出
            PrintStream print = new PrintStream(client.getOutputStream());
            if (scannerOut.hasNext()) {
                print.println(scannerOut.next());
            }

            // 输入  从客户端
            Scanner scannerIn = new Scanner(client.getInputStream());
//            自定义分隔符
            scannerIn.useDelimiter("\n");
            if (scannerIn.hasNext()) {
                String string = scannerIn.next();
                System.out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

