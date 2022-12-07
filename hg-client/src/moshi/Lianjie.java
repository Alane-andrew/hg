package moshi;

import interactivedata.ActiveData;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Lianjie {
    public Socket s;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public ActiveData fasong(Object o) {   //任何参数类型传进来 都可以用Object对像来接收
        ActiveData resultinfo = new ActiveData();
        try {
//        	192.168.1.5
//          this.s = new Socket("192.168.2.253", 6688);
            this.s = new Socket("192.168.1.5", 6688); //本机ip地址
            this.oos = new ObjectOutputStream(this.s.getOutputStream());
            this.oos.writeObject(o);
            //System.out.println("vvvvvv22222222222222");//----------------------------------------
            this.ois = new ObjectInputStream(this.s.getInputStream());
            //System.out.println("vvv33333");//----------------------
            resultinfo = (ActiveData) this.ois.readObject();
            close();
            this.s.close();
        } catch (Exception e) {
        }
        if (this.s == null) {
            resultinfo.setResult("无法连接服务器");
        }
        return resultinfo;
    }

    public void close() {
        try {
            if (this.oos != null) {
                this.oos.close();
            }
            if (this.ois != null) {
                this.ois.close();
            }
        } catch (Exception e) {
        }
    }
}
