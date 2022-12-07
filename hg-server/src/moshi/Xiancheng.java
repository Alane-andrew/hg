package moshi;

import interactivedata.ActiveData;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Xiancheng extends Thread {
    Socket s;
    CaoZuo cz = new CaoZuo();

    public Xiancheng(Socket s) {
        this.s = s;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            ActiveData activedata = (ActiveData) new ObjectInputStream(this.s.getInputStream()).readObject();
            ActiveData resultinfo = new ActiveData();
            if (activedata.getAction().equals("login")) {
                resultinfo.setResult(this.cz.login(activedata.getSql(), activedata.getValue()));
            } else if (activedata.getAction().equals("searchInfo")) {
            	
            	//-----------------------------
//            	System.out.println(activedata.getAction());//searchInfo
//            	System.out.println(activedata.getSql());//select * from kehuinfo
//            	//-----------------------------
            	
            	
                resultinfo.setInfo(this.cz.searchInfo(activedata.getSql()));
                
            } else if (activedata.getAction().equals("searchKcInfo")) {
                resultinfo.setInfo(this.cz.searchKcInfo(activedata.getSql()));
            } else if (activedata.getAction().equals("moOrderInfo")) {
                resultinfo.setB(this.cz.moOrderInfo(activedata.getSql(), activedata.getValue()));
            } else if (activedata.getAction().equals("insert")) {
                resultinfo.setB(this.cz.insert(activedata.getSql(), activedata.getValue()));
            } else if (activedata.getAction().equals("insertKc")) {
                resultinfo.setB(this.cz.insertKc(activedata.getSql(), activedata.getValue()));
            } else if (activedata.getAction().equals("delete")) {
                resultinfo.setB(this.cz.delete(activedata.getSql(), activedata.getValue()));
            }
            ObjectOutputStream oos = new ObjectOutputStream(this.s.getOutputStream());
            oos.writeObject(resultinfo);
            oos.close();
            this.s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}