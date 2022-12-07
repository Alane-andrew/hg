package gongju;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import moshi.CaoZuo;

public class UctInfo extends AbstractTableModel {
    private Vector ziduan;
    private Vector jilu;
    private String[] zdnamesql;
    private String[] zdtype;

    GongJu f3gongju = new GongJu();

    public UctInfo(String sql, String type) {
        sqlOrderInfo(sql, type);
    }

    public int getRowCount() {
        return this.jilu.size();
    }

    public Object getValueAt(int hang, int lie) {
        return ((Vector) this.jilu.get(hang)).get(lie);
    }

    public int getColumnCount() {
        return this.ziduan.size();
    }

    public String getColumnName(int e) {
        return (String) this.ziduan.get(e);
    }

    public String getColumnEname(int e) {
        return this.zdnamesql[e];
    }

    public String[] getZdtype() {
        return this.zdtype;
    }

    public Vector getZiduan() {
        return this.ziduan;
    }

    public void sqlOrderInfo(String sql, String type) {
        CaoZuo cz = new CaoZuo();
        new Vector();
        Vector jieguoxx = cz.searchInfo(sql);
        this.zdnamesql = (String[]) jieguoxx.get(0);
        this.zdtype = (String[]) jieguoxx.get(1);
        String[] lieming = new LiemingAndRemarks().uct_liemingConfirm(this.zdnamesql, type);
        this.ziduan = new Vector();
        for (String str : lieming) {
            this.ziduan.add(str);
        }
        Vector hang = new Vector();
        for (int i = 2; i < jieguoxx.size(); i++) {
            hang.add(jieguoxx.get(i));
        }
        this.jilu = new Vector();
        this.jilu = hang;
    }
}