package gongju;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OrderProcess extends JScrollPane implements ActionListener {
    Frame fra;
    JLabel bq;
    JPanel jp;
    JScrollPane jsp;
    JButton jb;
    String jilu_value;
    String lieming;
    String[] zdnamesql;
    Vector<String> zdtype;
    Vector<String> zdsql = new Vector<>();
    Vector jilu;
    Vector ziduan;
    Vector<String> zdtype_clone;
    Vector<String> zdsql_clone;
    Vector jilu_clone;
    Vector ziduan_clone;
    Vector<String> zdsql_filter;
    Vector jilu_filter;
    Vector ziduan_filter;
    Vector<String> hang;
    SqlOrderInfoShow sois;

    public OrderProcess(SqlOrderInfoShow sois, Frame fra) {
        this.fra = fra;
        this.sois = sois;
        OrderInfo orderinfo = new OrderInfo(sois.getOrderProcess_Sql());
        this.jilu = orderinfo.getJilu();
        this.ziduan = orderinfo.getZiduan();
        this.zdnamesql = orderinfo.getZdnamesql();
        for (int i = 0; i < this.zdnamesql.length; i++) {
            this.zdsql.add(this.zdnamesql[i]);
        }
        this.zdtype = new Vector<>();
        for (String str : orderinfo.getZdtype()) {
            this.zdtype.add(str);
        }
        noNeedShow();
        this.jp = new JPanel();
        this.jp.setLayout((LayoutManager) null);
        int k = 0;
        for (int i2 = 0; i2 < this.jilu_filter.size(); i2++) {
            for (int j = 0; j < ((Vector) this.jilu_filter.get(i2)).size(); j++) {
                this.jilu_value = ((Vector) this.jilu_filter.get(i2)).get(j).toString();
                this.lieming = this.ziduan_filter.get(j).toString();
                if (this.jilu_value.equals("--无--")) {
                    k++;
                } else if (this.zdsql_filter.get(j).equals("orderno")) {
                    JButton jb = new JButton(this.jilu_value);
                    jb.addActionListener(this);
                    jb.setActionCommand(this.jilu_value);
                    jb.setBounds(20 + (120 * (j - k)), 10 + (35 * i2), 100, 25);
                    this.jp.add(jb);
                } else {
                    if (this.zdsql_filter.get(j).equals("orderdate")) {
                        this.bq = new JLabel(this.jilu_value);
                    } else {
                        this.bq = new JLabel(this.lieming);
                    }
                    this.bq.setBounds(20 + (120 * (j - k)), 10 + (35 * i2), 120, 25);
                    this.bq.setOpaque(true);
                    if (this.jilu_value.equals("已完成")) {
                        this.bq.setBackground(Color.green);
                    } else if (!this.zdsql_filter.get(j).equals("orderno") && !this.zdsql_filter.get(j).equals("orderdate")) {
                        this.bq.setBackground(Color.lightGray);
                    }
                    this.jp.add(this.bq);
                }
            }
            k = 0;
        }
        this.jp.setPreferredSize(new Dimension(800, (this.jilu.size() * 35) + 30));
        this.jsp = new JScrollPane(this.jp);
        this.jsp.getVerticalScrollBar().setUnitIncrement(10);
        this.jsp.setVerticalScrollBarPolicy(20);
        this.jsp.setHorizontalScrollBarPolicy(31);
        this.jsp.setLocation(0, 100);
    }

    public JScrollPane getJsp() {
        return this.jsp;
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.jilu_filter.size(); i++) {
            if (e.getActionCommand().equals(((Vector) this.jilu_filter.get(i)).get(0))) {
                this.zdsql_clone = (Vector) this.zdsql.clone();
                this.zdtype_clone = (Vector) this.zdtype.clone();
                this.jilu_clone = (Vector) this.jilu.clone();
                this.ziduan_clone = (Vector) this.ziduan.clone();
                ProcessDetails pdetails = new ProcessDetails(this.fra, String.valueOf(((Vector) this.jilu_clone.get(i)).get(0).toString()) + "--生产进度表", true);
                pdetails.setHang((Vector) this.jilu_clone.get(i));
                pdetails.setZdsql(this.zdsql_clone);
                pdetails.setZiduan(this.ziduan_clone);
                pdetails.setZdtype(this.zdtype_clone);
                pdetails.startProcessDetails();
                return;
            }
        }
    }

    public void noNeedShow() {
        this.zdsql_filter = new Vector<>();
        this.jilu_filter = new Vector();
        this.ziduan_filter = new Vector();
        if (this.sois.getPower().equals("老总")) {
            for (int i = 0; i < this.jilu.size(); i++) {
                this.hang = new Vector<>();
                for (int j = 0; j < this.zdsql.size(); j++) {
                    if (!this.zdsql.get(j).equals("lamedate") && !this.zdsql.get(j).equals("lamfdate") && !this.zdsql.get(j).equals("cedate") && !this.zdsql.get(j).equals("cfdate") && !this.zdsql.get(j).equals("oiledate") && !this.zdsql.get(j).equals("oilfdate") && !this.zdsql.get(j).equals("glueedate") && !this.zdsql.get(j).equals("gluefdate") && !this.zdsql.get(j).equals("uvedate") && !this.zdsql.get(j).equals("uvfdate") && !this.zdsql.get(j).equals("ysprodate") && !this.zdsql.get(j).equals("hdprodate") && !this.zdsql.get(j).equals("fhprodate")) {
                        if (i == 0) {
                            this.ziduan_filter.add(this.ziduan.get(j));
                            this.zdsql_filter.add(this.zdsql.get(j));
                        }
                        this.hang.add(((Vector) this.jilu.get(i)).get(j).toString());
                    }
                }
                this.jilu_filter.add(this.hang);
            }
        } else if (this.sois.getPower().equals("后道")) {
            for (int i2 = 0; i2 < this.jilu.size(); i2++) {
                this.hang = new Vector<>();
                for (int j2 = 0; j2 < this.zdsql.size(); j2++) {
                    if (!this.zdsql.get(j2).equals("lamedate") && !this.zdsql.get(j2).equals("lamfdate") && !this.zdsql.get(j2).equals("cedate") && !this.zdsql.get(j2).equals("cfdate") && !this.zdsql.get(j2).equals("oiledate") && !this.zdsql.get(j2).equals("oilfdate") && !this.zdsql.get(j2).equals("glueedate") && !this.zdsql.get(j2).equals("gluefdate") && !this.zdsql.get(j2).equals("uvedate") && !this.zdsql.get(j2).equals("uvfdate") && !this.zdsql.get(j2).equals("ysprodate") && !this.zdsql.get(j2).equals("hdprodate") && !this.zdsql.get(j2).equals("fhprodate")) {
                        if (i2 == 0) {
                            this.ziduan_filter.add(this.ziduan.get(j2));
                            this.zdsql_filter.add(this.zdsql.get(j2));
                        }
                        this.hang.add(((Vector) this.jilu.get(i2)).get(j2).toString());
                    }
                }
                this.jilu_filter.add(this.hang);
            }
        }
    }
}