package chat;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


class OutToServer implements Runnable {
//    给服务器发送消息
    private Socket client;

    public OutToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //
            PrintStream ps = new PrintStream(client.getOutputStream(), true, "utf-8");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            while (true) {
                System.out.println("请输入内容：");
                if (scanner.hasNext()) {
                    String str = scanner.next();
                    ps.println(str);
//                    以下语句自定义退出符号
                    if (str.equals("exit")) {
                        System.out.println("客户端退出啦");

                        scanner.close();
                        ps.close();
                        client.close();
//                        退出
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadFromServer implements Runnable {
//    接收来自服务的消息
    private Socket client;

    public ReadFromServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(client.getInputStream());
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class SingleClient {
    public static void main(String[] args) {

        String serverName = "127.0.0.1";
        int port = 8080;
        try {
            //服务器端口号
            Socket client = new Socket(serverName, port);
            //新起一个线程，给服务端
            Thread threadForserver = new Thread(new OutToServer(client));
//           新起一个线程，接收服务器的信息
            Thread threadReceive = new Thread(new ReadFromServer(client));
            threadForserver.start();
            threadReceive.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
