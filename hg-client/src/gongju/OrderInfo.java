package gongju;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import moshi.CaoZuo;

public class OrderInfo extends AbstractTableModel implements Cloneable {
    private Vector ziduan;
    private Vector jilu;
    private String[] zdnamesql;
    private String[] zdtype;
    private String action;

    GongJu f1gongju;

    public OrderInfo(String ss) {
        this.action = "";
        this.f1gongju = new GongJu();
        sqlOrderInfo(ss);
    }

    public OrderInfo(String ss, String action) {
        this.action = "";
        this.f1gongju = new GongJu();
        this.action = action;
        sqlOrderInfo(ss);
    }

    public int getRowCount() {
        return this.jilu.size();
    }

    public Object getValueAt(int hang, int lie) {
    	
//    	//-----------------------------------------------------
//    	System.out.println("orderinfo--jilu的size是："+this.jilu.size());
//    	System.out.println("orderinfo--hang是："+hang);
//    	System.out.println("orderinfo--lie是："+lie);
//    	//-----------------------------------------------------
    		
        this.jilu = this.f1gongju.dataFilter(this.jilu, hang, lie);
        return ((Vector) this.jilu.get(hang)).get(lie);
    }

    public int getColumnCount() {
        return this.ziduan.size();
    }

    public String getColumnName(int e) {
        return (String) this.ziduan.get(e);
    }

    public String[] getZdnamesql() {
        return this.zdnamesql;
    }

    public String[] getZdtype() {
        return this.zdtype;
    }

    public Vector getZiduan() {
        return this.ziduan;
    }

    public Vector getJilu() {
        return this.jilu;
    }

    public void sqlOrderInfo(String sql) {
    	
    	//System.out.println("orderinfo 的sql：  "+sql);//---------------------
    	
        Vector jieguoxx;
        CaoZuo cz = new CaoZuo();
        new Vector();
        if (this.action.equals("searchKcInfo")) {
            jieguoxx = cz.searchKcInfo(sql);
        } else {
            jieguoxx = cz.searchInfo(sql);
        }
        this.zdnamesql = (String[]) jieguoxx.get(0);
        this.zdtype = (String[]) jieguoxx.get(1);
        
//        System.out.println(zdnamesql.length);//12  -----------------------
//        System.out.println(Arrays.toString(zdnamesql));//---------------
//        System.out.println(Arrays.toString(zdtype));//----------------
        
        String[] lieming = new LiemingAndRemarks().liemingConfirm(this.zdnamesql);
        this.ziduan = new Vector();
        for (String str : lieming) {
            this.ziduan.add(str);
        }
//        System.out.println(this.ziduan.toString());//----------------
        Vector hang = new Vector();
        for (int i = 2; i < jieguoxx.size(); i++) {
//        	System.out.println(jieguoxx.get(i).toString());//-------------------
            hang.add(jieguoxx.get(i));
        }
        this.jilu = new Vector();
        this.jilu = hang;
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        OrderInfo orderinfo = (OrderInfo) super.clone();
        orderinfo.ziduan = (Vector) this.ziduan.clone();
        orderinfo.jilu = (Vector) this.jilu.clone();
        orderinfo.zdnamesql = (String[]) this.zdnamesql.clone();
        orderinfo.zdtype = (String[]) this.zdtype.clone();
        return orderinfo;
    }
}