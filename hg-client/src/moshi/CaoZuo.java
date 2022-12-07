package moshi;

import interactivedata.ActiveData;
import java.util.Vector;

public class CaoZuo {
    private ActiveData activedata;

    public String login(String sql, Vector<String> paras) {
        this.activedata = new ActiveData();
        this.activedata.setSql(sql);
        this.activedata.setValue(paras);
        this.activedata.setAction("login");
        this.activedata = new Lianjie().fasong(this.activedata);
        return this.activedata.getResult();
    }

    public Vector searchInfo(String sql) {
        this.activedata = new ActiveData();
        this.activedata.setSql(sql);
        this.activedata.setAction("searchInfo");
        this.activedata = new Lianjie().fasong(this.activedata);
//        System.out.println("abc=:"+this.activedata.getInfo().size());//--------------------------------
//        System.out.println("abc=:"+this.activedata.getInfo().toString());//--------------------------------
        
        return this.activedata.getInfo();
    }

    public Vector searchKcInfo(String sql) {
        this.activedata = new ActiveData();
        this.activedata.setSql(sql);
        this.activedata.setAction("searchKcInfo");
        this.activedata = new Lianjie().fasong(this.activedata);
        return this.activedata.getInfo();
    }

    public boolean moOrderInfo(String sql, Vector<String> upinfo) {
        this.activedata = new ActiveData();
        this.activedata.setSql(sql);
        this.activedata.setValue(upinfo);
        this.activedata.setAction("moOrderInfo");
        this.activedata = new Lianjie().fasong(this.activedata);
        return this.activedata.getB();
    }

    public boolean insert(String sql, Vector<String> inputdata) {//add order, 开单
        this.activedata = new ActiveData();
        this.activedata.setSql(sql);
        this.activedata.setValue(inputdata);
        this.activedata.setAction("insert");
        this.activedata = new Lianjie().fasong(this.activedata);
        return this.activedata.getB();
    }

    public boolean insertKc(String sql, Vector<String> inputdata) {
        this.activedata = new ActiveData();
        this.activedata.setSql(sql);
        this.activedata.setValue(inputdata);
        this.activedata.setAction("insertKc");
        this.activedata = new Lianjie().fasong(this.activedata);
        return this.activedata.getB();
    }

    public boolean delete(String sql, Vector<String> value) {
        this.activedata = new ActiveData();
        this.activedata.setSql(sql);
        this.activedata.setValue(value);
        this.activedata.setAction("delete");
        this.activedata = new Lianjie().fasong(this.activedata);
        return this.activedata.getB();
    }
}