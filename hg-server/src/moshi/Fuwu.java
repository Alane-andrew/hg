package moshi;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Fuwu {
    String ip;

    public Fuwu() {
        try {
            ServerSocket ss = new ServerSocket();
            this.ip = InetAddress.getLocalHost().getHostAddress();
            SocketAddress address = new InetSocketAddress(this.ip, 6688);
//            System.out.println(address); // --------   /192.168.1.5:6688
//            System.out.println(545543); //---------------------
            ss.bind(address);
//            System.out.println(6666666); //---------------------
            while (true) {
                try {
                    Socket s = ss.accept();
                    Xiancheng xc = new Xiancheng(s);
                    xc.start();
//                    System.out.print(22222); //---------------------
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            System.out.println("代码错误");
        }
    }
}