package gongju;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderDetails extends JDialog implements ActionListener {
    JLabel[] bq;
    JButton an1;
    JPanel mb1;
    JPanel mb2;
    JPanel mb3;
    String[] zdnamesql;
    String[] zdtype;
    OrderInfo data;

    GongJu f0gongju = new GongJu();
    ArrayList wbkjcblist = new ArrayList();

    public OrderDetails(Frame fck, String ckm, Boolean msck, OrderInfo orderinfo, int hang) {
        super(fck, ckm, msck.booleanValue());
        this.data = orderinfo;
        this.data = new OrderInfo(this.f0gongju.getOrderDetailsSql((String) this.data.getValueAt(hang, 0)));
        this.zdnamesql = this.data.getZdnamesql();
        this.zdtype = this.data.getZdtype();
        this.bq = new JLabel[this.zdnamesql.length];
        for (int i = 0; i < this.zdnamesql.length; i++) {
            if (this.zdtype[i].equals("VARCHAR") || this.zdtype[i].equals("DECIMAL") || this.zdtype[i].equals("DATETIME")) {
                this.bq[i] = new JLabel(this.data.getColumnName(i));
                JTextField a = new JTextField(15);
                a.setText(this.data.getValueAt(0, i).toString());
                a.setEditable(false);
                this.wbkjcblist.add(a);
            } else if (this.zdtype[i].equals("bit")) {
                this.bq[i] = new JLabel(this.data.getColumnName(i));
                JCheckBox b = new JCheckBox("bbbb");
                b.setSelected(Boolean.parseBoolean(this.data.getValueAt(0, i).toString()));
                b.setEnabled(false);
                this.wbkjcblist.add(b);
            }
        }
        this.an1 = new JButton("取消");
        this.an1.addActionListener(this);
        this.an1.setActionCommand("quxiao");
        this.mb1 = new JPanel();
        this.mb2 = new JPanel();
        this.mb3 = new JPanel();
        this.mb1.setLayout(new GridLayout(this.bq.length, 1));
        this.mb2.setLayout(new GridLayout(this.wbkjcblist.size(), 1));
        for (int i2 = 0; i2 < this.bq.length; i2++) {
            this.mb1.add(this.bq[i2]);
        }
        for (int i3 = 0; i3 < this.wbkjcblist.size(); i3++) {
            if (this.wbkjcblist.get(i3).getClass().toString().equals("class javax.swing.JTextField")) {
                this.mb2.add((JTextField) this.wbkjcblist.get(i3));
            } else if (this.wbkjcblist.get(i3).getClass().toString().equals("class javax.swing.JCheckBox")) {
                this.mb2.add((JCheckBox) this.wbkjcblist.get(i3));
            }
        }
        this.mb3.add(this.an1);
        add(this.mb1, "West");
        add(this.mb2);
        add(this.mb3, "South");
        setSize(670, 770);
        setLocation(401, 281);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("quxiao")) {
            dispose();
        }
    }
}