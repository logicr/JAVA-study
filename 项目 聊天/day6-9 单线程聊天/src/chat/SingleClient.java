package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {
    public static void main(String[] args) {
        System.out.println("客户端启动，等待连接：>");

        try {
//                Socket socket = new Socket("127.0.0.1", 18848);
            Socket socket = new Socket("192.168.43.79", 8080);

//            输入 从服务端接收
            Scanner scannerIn = new Scanner(socket.getInputStream());
            scannerIn.useDelimiter("\n");
            if (scannerIn.hasNext()) {
                System.out.println(scannerIn.next());
            }

            //            输出 到服务器
            Scanner scannerOut = new Scanner(System.in);
            scannerOut.useDelimiter("\n");
            PrintStream print = new PrintStream(socket.getOutputStream());
            if (scannerOut.hasNext()) {
                String string = scannerOut.next();
                print.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

