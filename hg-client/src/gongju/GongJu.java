package gongju;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GongJu {
    String nodata = "暂无数据";

    public String getUpdateSql(Vector upzd) {
        String sql22;
        String sql33 = "update orderxx set ";
        String sql44 = "where " + upzd.get(0) + "=?";
        for (int i = 1; i < upzd.size(); i++) {
            if (i < upzd.size() - 1) {
                sql22 = String.valueOf(sql33) + upzd.get(i) + "=?,";
            } else {
                sql22 = String.valueOf(sql33) + upzd.get(i) + "=? ";
            }
            sql33 = sql22;
        }
        return String.valueOf(sql33) + sql44;
    }

    public String getInsertSql(Vector<String> inputziduan) {
        String sql22;
        String sql222;
        String sql33 = "insert into orderxx (";
        for (int i = 0; i < inputziduan.size(); i++) {
            if (i < inputziduan.size() - 1) {
                sql222 = String.valueOf(sql33) + inputziduan.get(i) + ",";
            } else {
                sql222 = String.valueOf(sql33) + inputziduan.get(i) + ") values(";
            }
            sql33 = sql222;
        }
        for (int i2 = 0; i2 < inputziduan.size(); i2++) {
            if (i2 < inputziduan.size() - 1) {
                sql22 = String.valueOf(sql33) + "?,";
            } else {
                sql22 = String.valueOf(sql33) + "?)";
            }
            sql33 = sql22;
        }
        return sql33;
    }

    public String getUctInsertSql(Vector<String> inputziduan, String type) {
        String sql22;
        String sql222;
        String tablename = "";
        if (type.equals("user")) {
            tablename = "userinfo";
        } else if (type.equals("customer")) {
            tablename = "kehuinfo";
        } else if (type.equals("tyb")) {
            tablename = "tybinfo";
        }
        String sql33 = "insert into " + tablename + " (";
        for (int i = 0; i < inputziduan.size(); i++) {
            if (i < inputziduan.size() - 1) {
                sql222 = String.valueOf(sql33) + inputziduan.get(i) + ",";
            } else {
                sql222 = String.valueOf(sql33) + inputziduan.get(i) + ") values(";
            }
            sql33 = sql222;
        }
        for (int i2 = 0; i2 < inputziduan.size(); i2++) {
            if (i2 < inputziduan.size() - 1) {
                sql22 = String.valueOf(sql33) + "?,";
            } else {
                sql22 = String.valueOf(sql33) + "?)";
            }
            sql33 = sql22;
        }
        return sql33;
    }

    public String getUctDeleteSql(String type, String zdname) {
        String tablename = "";
        if (type.equals("user")) {
            tablename = "userinfo";
        } else if (type.equals("customer")) {
            tablename = "kehuinfo";
        } else if (type.equals("tyb")) {
            tablename = "tybinfo";
        }
        return "delete from " + tablename + " where " + zdname + "=?";
    }

    public String getOrderDetailsSql(String orderno) {
        return "select orderno,unitprice,yspro from orderxx where orderno='" + orderno + "'";
    }

    public Vector dataFilter(Vector jilu, int hang, int lie) {
    	
//    	//-----------------------------------------------------
//    	System.out.println("记录的size是："+jilu.size());
//    	System.out.println("hang是："+hang);
//    	System.out.println("lie是："+lie);
//    	//-----------------------------------------------------
    	
        if (((Vector) jilu.get(hang)).get(lie) == null || ((Vector) jilu.get(hang)).get(lie).toString().equals("1900-01-01") || ((Vector) jilu.get(hang)).get(lie).toString().equals("")) {
            ((Vector) jilu.get(hang)).set(lie, this.nodata);
        }
        return jilu;
    }

    public Vector compareData(Vector zdname_sql, Vector zdname_value, Vector wbkv) {
        Vector<String> upzdsql = new Vector<>();
        Vector<String> upinfo = new Vector<>();
        Vector info = new Vector();
        upzdsql.add(zdname_sql.get(0).toString());
        upinfo.add(wbkv.get(0).toString());
        for (int i = 1; i < zdname_sql.size(); i++) {
            if (!wbkv.get(i).equals(zdname_value.get(i).toString())) {
                upzdsql.add(zdname_sql.get(i).toString());
                upinfo.add(wbkv.get(i).toString());
            }
        }
        info.add(upzdsql);
        info.add(upinfo);
        return info;
    }

    public boolean proDataFinished(Vector value) {
        for (int i = 0; i < value.size(); i++) {
        	//System.out.println("---"+value.get(i).toString());//--------------
        	//System.out.println("nodata:"+this.nodata);//-------------
            if (value.get(i).toString().equals("1900-01-01") || value.get(i).toString().equals(this.nodata) || value.get(i).toString().equals("未完成") || value.get(i).toString().equals("")) {
                return false;
            }
        }
        return true;
    }

    public void componentsEnable(ArrayList wbkjcblist) {
//        System.out.println("3333333333333333333333abc");//-----------------------
        for (int j = 0; j < wbkjcblist.size(); j++) {
            if (wbkjcblist.get(j).getClass().toString().equals("class javax.swing.JTextField")) {
//            	System.out.println("111111111111");
//            	System.out.println(((JTextField) wbkjcblist.get(j)).toString());
                ((JTextField) wbkjcblist.get(j)).setEnabled(false);//文本框 不可修改，不可选中，灰色
            } else if (wbkjcblist.get(j).getClass().toString().equals("class javax.swing.JCheckBox")) {
//            	System.out.println("222222222222");
//            	System.out.println(((JCheckBox) wbkjcblist.get(j)).toString());
                ((JCheckBox) wbkjcblist.get(j)).setEnabled(false);
            }
        }
    }

    public String getShijian() {
        String time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public boolean compareDate(String validtime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(validtime));
            c2.setTime(df.parse("1900-01-01"));
        } catch (ParseException e) {
            System.err.println("格式不正确lll");
        }
        if (c1.compareTo(c2) > 0) {
            return true;
        }
        return false;
    }

    public void setTableRowHeight(JTable jt) {
        jt.setRowHeight(40);
    }
}