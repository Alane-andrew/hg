package moshi;

import java.util.Vector;
import sjk.Shujuku;

public class CaoZuo {
    public String login(String sql, Vector<String> paras) {
        return new Shujuku().userQuery(sql, paras);
    }

    public Vector searchInfo(String sql) {
//    	System.out.println("nihaobird");//nihaobird------------------------------
        return new Shujuku().searchOrderInfo(sql);
    }

    public Vector searchKcInfo(String sql) {
        return new Shujuku().searchKcInfo(sql);
    }

    public boolean moOrderInfo(String sql, Vector<String> upinfo) {
        return new Shujuku().upDate(sql, upinfo);
    }

    public boolean insert(String sql, Vector<String> inputdata) {
        return new Shujuku().insert(sql, inputdata);
    }

    public boolean insertKc(String sql, Vector<String> inputdata) {
        return new Shujuku().insertKc(sql, inputdata);
    }

    public boolean delete(String sql, Vector<String> value) {
        return new Shujuku().delete(sql, value);
    }
}