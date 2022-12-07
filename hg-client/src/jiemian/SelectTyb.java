package jiemian;

import gongju.OrderInfo;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SelectTyb extends JDialog implements ActionListener {
    JButton an1;
    JButton an2;
    JRadioButton jrb;
    ArrayList wbkjcblist;
    Vector zdname_sql;
    ButtonGroup dxz = new ButtonGroup();
    Vector jilu = new OrderInfo("select * from tybinfo").getJilu();

    public SelectTyb(Dialog fra, Boolean msck, ArrayList wbkjcblist, Vector zdname_sql) {
        super(fra, msck.booleanValue());
        this.wbkjcblist = wbkjcblist;
        this.zdname_sql = zdname_sql;
        JPanel jp = new JPanel();
        jp.setLayout((LayoutManager) null);
        for (int i = 0; i < this.jilu.size(); i++) {
            String value = ((Vector) this.jilu.get(i)).get(0).toString();
            this.jrb = new JRadioButton(value);
            if (i < 10) {
                this.jrb.setBounds(30, 30 + (i * 40), 120, 30);
            } else {
                this.jrb.setBounds(180, (30 + (i * 40)) - 400, 120, 30);
            }
            this.jrb.setActionCommand(value);
            this.dxz.add(this.jrb);
            jp.add(this.jrb);
        }
        this.an1 = new JButton("确认");
        this.an1.addActionListener(this);
        this.an1.setActionCommand("confirm");
        this.an2 = new JButton("取消");
        this.an2.addActionListener(this);
        this.an2.setActionCommand("quxiao");
        JPanel mb1 = new JPanel();
        mb1.add(this.an1);
        mb1.add(this.an2);
        add(jp);
        add(mb1, "South");
        setTitle("选择托运部名称");
        setSize(400, 500);
        setLocation(200, 50);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
            if (this.dxz.isSelected((ButtonModel) null)) {
                JOptionPane.showMessageDialog(this, "请选择托运部名称");
                return;
            }
            int i = 0;
            while (true) {
                if (i >= this.wbkjcblist.size()) {
                    break;
                }
                if (this.wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JTextField") && this.zdname_sql.get(i).toString().equals("tybname")) {
                    ((JTextField) this.wbkjcblist.get(i)).setText(this.dxz.getSelection().getActionCommand());
                    ((JTextField) this.wbkjcblist.get(i)).setForeground(Color.BLACK);
                    break;
                }
                i++;
            }
            String tybadd = "";
            String tybcontactno = "";
            int i2 = 0;
            while (true) {
                if (i2 >= this.jilu.size()) {
                    break;
                } else if (this.dxz.getSelection().getActionCommand().equals(((Vector) this.jilu.get(i2)).get(0).toString())) {
                    tybadd = ((Vector) this.jilu.get(i2)).get(1).toString();
                    tybcontactno = ((Vector) this.jilu.get(i2)).get(2).toString();
                    break;
                } else {
                    i2++;
                }
            }
            for (int i3 = 0; i3 < this.zdname_sql.size(); i3++) {
                if (this.zdname_sql.get(i3).equals("tybadd")) {
                    ((JTextField) this.wbkjcblist.get(i3)).setText(tybadd);
                } else if (this.zdname_sql.get(i3).equals("tybcontactno")) {
                    ((JTextField) this.wbkjcblist.get(i3)).setText(tybcontactno);
                }
            }
            dispose();
        } else if (e.getActionCommand().equals("quxiao")) {
            dispose();
        }
    }
}