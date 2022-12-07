package gongju;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProcessDetails extends JDialog implements ActionListener {
    JScrollPane jsp;
    JLabel bq1;
    JLabel bq2;
    JButton an1;
    JPanel mb1;
    JPanel jp;
    private Vector<String> zdtype;
    private Vector<String> zdsql;
    private Vector hang;
    private Vector ziduan;
    private String hang_value;
    private String lieming;

    GongJu f2gongju = new GongJu();

    public ProcessDetails(Frame fra, String ckm, boolean msck) {
        super(fra, ckm, msck);
    }

    public void startProcessDetails() {
        this.jp = new JPanel();
        this.jp.setLayout((LayoutManager) null);
        this.mb1 = new JPanel();
        this.an1 = new JButton("取消");
        this.an1.addActionListener(this);
        this.an1.setActionCommand("quxiao");
        this.mb1.add(this.an1);
        int i = 0;
        while (i < this.hang.size()) {
            this.hang_value = this.hang.get(i).toString();
            if (this.hang_value.equals("--无--")) {
                judge(this.zdsql.get(i), i);
                i = 0;
            }
            i++;
        }
        for (int i2 = 0; i2 < this.hang.size(); i2++) {
            this.lieming = this.ziduan.get(i2).toString();
            this.bq1 = new JLabel(String.valueOf(this.lieming) + ":  ");
            this.bq1.setBounds(10, 10 + (35 * i2), 120, 25);
            this.bq2 = new JLabel(this.hang.get(i2).toString());
            this.bq2.setBounds(140, 10 + (35 * i2), 120, 25);
            this.bq2.setOpaque(true);
            if (this.zdtype.get(i2).equals("datetime")) {
                if (this.f2gongju.compareDate(this.hang.get(i2).toString())) {
                    this.bq2.setBackground(Color.green);
                } else {
                    this.bq2.setText("暂无数据");
                    this.bq2.setBackground(Color.lightGray);
                }
            }
            if (this.hang.get(i2).toString().equals("已完成")) {
                this.bq2.setBackground(Color.green);
            } else if (this.hang.get(i2).toString().equals("未完成")) {
                this.bq2.setBackground(Color.lightGray);
            }
            if (this.zdsql.get(i2).equals("orderdate")) {
                this.bq2.setBackground((Color) null);
            }
            this.jp.add(this.bq1);
            this.jp.add(this.bq2);
        }
        this.jp.setPreferredSize(new Dimension(800, (this.hang.size() * 35) + 30));
        this.jsp = new JScrollPane(this.jp);
        this.jsp.getVerticalScrollBar().setUnitIncrement(10);
        this.jsp.setVerticalScrollBarPolicy(20);
        this.jsp.setHorizontalScrollBarPolicy(31);
        this.jsp.setLocation(0, 100);
        add(this.jsp);
        add(this.mb1, "South");
        setSize(400, 700);
        setLocation(400, 50);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("quxiao")) {
            dispose();
        }
    }

    private void judge(String value, int lie) {
        if (value.equals("lamination")) {
            this.zdtype.remove(lie);
            this.zdsql.remove(lie);
            this.hang.remove(lie);
            this.ziduan.remove(lie);
            int i = 0;
            while (i < this.zdsql.size()) {
                if (this.zdsql.get(i).equals("lamedate") || this.zdsql.get(i).equals("lamfdate")) {
                    this.zdtype.remove(i);
                    this.zdsql.remove(i);
                    this.hang.remove(i);
                    this.ziduan.remove(i);
                    i = 0;
                }
                i++;
            }
        } else if (value.equals("uv")) {
            this.zdtype.remove(lie);
            this.zdsql.remove(lie);
            this.hang.remove(lie);
            this.ziduan.remove(lie);
            int i2 = 0;
            while (i2 < this.zdsql.size()) {
                if (this.zdsql.get(i2).equals("uvedate") || this.zdsql.get(i2).equals("uvfdate")) {
                    this.zdtype.remove(i2);
                    this.zdsql.remove(i2);
                    this.hang.remove(i2);
                    this.ziduan.remove(i2);
                    i2 = 0;
                }
                i2++;
            }
        } else if (value.equals("cut")) {
            this.zdtype.remove(lie);
            this.zdsql.remove(lie);
            this.hang.remove(lie);
            this.ziduan.remove(lie);
            int i3 = 0;
            while (i3 < this.zdsql.size()) {
                if (this.zdsql.get(i3).equals("cedate") || this.zdsql.get(i3).equals("cfdate")) {
                    this.zdtype.remove(i3);
                    this.zdsql.remove(i3);
                    this.hang.remove(i3);
                    this.ziduan.remove(i3);
                    i3 = 0;
                }
                i3++;
            }
        } else if (value.equals("oil")) {
            this.zdtype.remove(lie);
            this.zdsql.remove(lie);
            this.hang.remove(lie);
            this.ziduan.remove(lie);
            int i4 = 0;
            while (i4 < this.zdsql.size()) {
                if (this.zdsql.get(i4).equals("oiledate") || this.zdsql.get(i4).equals("oilfdate")) {
                    this.zdtype.remove(i4);
                    this.zdsql.remove(i4);
                    this.hang.remove(i4);
                    this.ziduan.remove(i4);
                    i4 = 0;
                }
                i4++;
            }
        } else if (value.equals("glue")) {
            this.zdtype.remove(lie);
            this.zdsql.remove(lie);
            this.hang.remove(lie);
            this.ziduan.remove(lie);
            int i5 = 0;
            while (i5 < this.zdsql.size()) {
                if (this.zdsql.get(i5).equals("glueedate") || this.zdsql.get(i5).equals("gluefdate")) {
                    this.zdtype.remove(i5);
                    this.zdsql.remove(i5);
                    this.hang.remove(i5);
                    this.ziduan.remove(i5);
                    i5 = 0;
                }
                i5++;
            }
        }
    }

    public void setHang(Vector hang) {
        this.hang = hang;
    }

    public void setZdsql(Vector<String> zdsql) {
        this.zdsql = zdsql;
    }

    public void setZiduan(Vector ziduan) {
        this.ziduan = ziduan;
    }

    public void setZdtype(Vector<String> zdtype) {
        this.zdtype = zdtype;
    }
}