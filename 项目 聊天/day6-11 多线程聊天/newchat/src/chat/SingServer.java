package chat;

import sun.nio.cs.ext.MS874;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExcuteCLientSever implements Runnable {
    //    客户端对象
    private Socket client;
    //    存名字，对象
    private Map<String, Socket> clientMap;

    //    alt+insert
    public ExcuteCLientSever(Socket client, Map<String, Socket> clientMap) throws IOException {
        this.client = client;
        this.clientMap = clientMap;
    }
    //来一个用户就新开一个线程

    @Override
    public void run() {
//        run（）方法中分为5个模块处理1.userName注册，2.G:群聊 3.P:私聊 4.quit 退出 5. 处理其他不正常格式输入
        try {
//            ctrl+alt+T  try catch
            //
            Scanner scanner = new Scanner(client.getInputStream());
            scanner.useDelimiter("\n");
            while (true) {
                if (scanner.hasNext()) {
                    String str = scanner.next();


//                   拉姆达过滤
                    Pattern pattern = Pattern.compile("\r");
                    Matcher matcher = pattern.matcher(str);
                    str = matcher.replaceAll("");



                    //用户注册
                    if (str.startsWith("userName")) {
//                        按照userName：名字分离出，名字，作为Map的Key
                        String userName = str.split("\\:")[1];
//方法                    将用户信息保存
                        registerUser(userName, client);
                        continue;
                    }

                    //群聊
                    else if (str.startsWith("G:")) {
//                        G:内容 分离出内容
                        String noti = str.split("\\:")[1];
//方法                    方法用途：给每个用户发送信息；还要有名字
                        groupChat(noti);
                        continue;
                    }
                    //私聊流程
                    else if (str.startsWith("P:")) {
//                        P:名字-内容
//                        分离出名字和内容
                        String temp = str.split("\\:")[1];
//                        分离出要发送信息的人名
                        String userName = temp.split("-")[0];
//                        分离内容
                        String msg = temp.split("\\-")[1];
//                        方法功能 给指定的人发送信息
                        privateChat(userName, msg);
                    }
//方法
                    //退出
                    else if (str.startsWith("exit")) {
//                            当开头为qexit时表示退出
//                        定义一个key用来放名字
                        String key = null;
//                        找名字
                        for (String temp : clientMap.keySet()) {

//                            用synchronized同步当前代码块，防止在移出用户时，其他线程读取clientMap时产生空指针异常
                            synchronized (this) {
//                                判断当前用户是否在clientMap中
//                                根据key找到value，判断是不是当前Socket的key
                                if (clientMap.get(temp).equals(client)) {
                                    key = temp;
                                }else {
                                    break;
                                }
                                System.out.println(key + "下线了");
                                clientMap.remove(key);
                            }
                        }
//                        有可能用户未注册就退出，此时要判断一下再广播
                            if (!findMe().equals(" ")){
                                groupChat("[" + key + "]" + "下线啦");
                            }

                        break;

                    } else {
                        String message = " 系统提示：输入有误,请按以下格式输入\n \"userName:\"名字------注册 \n \"G:\"内容------发起群聊\n \"P:\"用户名\"-\"内容-----发起私聊 \n \"quit\"-----退出";
                        // groupChat(message);
                        // if (findMe().equals("null"))
                        {
                            PrintStream ps = new PrintStream(client.getOutputStream());
                            ps.println(message);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //用户注册
    private void registerUser(String userName, Socket socket) {
        System.out.println("用户姓名为：" + userName);
        System.out.println("用户socket为：" + client);
        System.out.println("用户" + userName + "上线了");
        clientMap.put(userName, client);
    }

    //                G：群聊方法
    private void groupChat(String msg) {
//        取出clientMap中所有客户端Socket，然后遍历一遍；
//        分别取得每个Soceket的输出流向每个客户端输出
//        因为map没有取value的方法
        Set<Map.Entry<String, Socket>> entrySet = clientMap.entrySet();
        Iterator<Map.Entry<String, Socket>> iterator = entrySet.iterator();
        for (Map.Entry<String, Socket> stringSocketEntry : entrySet) {
            try {
                Socket socket = stringSocketEntry.getValue();
                PrintStream ps = new PrintStream(socket.getOutputStream());
//                服务器提示
                System.out.println("已广播到名为" + stringSocketEntry.getKey() + "（" + socket.getPort() + "）的用户，内容为：" + msg);
//                格式化输出提示信息到用户
                ps.println("["+findMe() + "] [群]:\n" + msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //找人
    private String findMe() {
//        根据client中的Socket找key（人名）
        Set<Map.Entry<String, Socket>> entrySet = clientMap.entrySet();
        for (Map.Entry<String, Socket> stringSocketEntry : entrySet) {
            if (stringSocketEntry.getValue().equals(client)) {
                return stringSocketEntry.getKey();
            }
        }
        return " ";
    }

    //私聊方法
    private void privateChat(String userName, String str) {
//        找到对应userName的Socket
        Socket privateUser = clientMap.get(userName);
        try {
            PrintStream ps = new PrintStream(privateUser.getOutputStream(), true, "utf-8");
            ps.println("来自[" + findMe() + "]的私信：\n" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class SingServer {
    //    private static Map<String,Socket> clientMap = new HashMap<String, Socket>();
    private static Map<String, Socket> clientMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("等待响应...");
        ServerSocket serverSocket = new ServerSocket(8080);
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            Socket socket = null;
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort());
                socket = serverSocket.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            新起一个ExcuteCLientSever线程，处理用户
            executorService.execute(new ExcuteCLientSever(socket, clientMap));
        }
        serverSocket.close();
    }
}

