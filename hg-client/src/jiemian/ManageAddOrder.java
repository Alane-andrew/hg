package jiemian;

import gongju.GongJu;
import gongju.If_notEdit;
import gongju.LiemingAndRemarks;
import gongju.SqlOrderInfoShow;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import moshi.CaoZuo;

public class ManageAddOrder extends JPanel implements ActionListener {
    SqlOrderInfoShow sois;
    Frame fra;
    ManageOrder manageorder;
    private JSplitPane jsp;
    private JPanel mbtop;
    Vector<String> head;
    Vector<Vector> data;
    DefaultTableModel dtm;
    JTable jt;
    JScrollPane jspn;
    JLabel[] bq;
    JLabel[] remarks;
    JTextField[] wbk;
    JButton an1;
    JButton an2;
    JPanel mb1;
    JPanel mb2;
    public int zdtotal;
    String[] ename;

    GongJu f5gongju = new GongJu();
    JLabel fmbq1 = new JLabel("单面 or 双面: ");
    JLabel fmbq2 = new JLabel("哑膜 or 亮膜: ");
    String[] str1 = {"请选择...", "单面", "双面"};
    JComboBox jcomb1 = new JComboBox(this.str1);
    String[] str2 = {"请选择...", "正面-哑-膜", "正面-亮-膜", "反面-哑-膜", "反面-哑-膜"};
    String[] str3 = {"请选择...", "双面-哑-膜", "双面-亮-膜", "正面-哑-膜，反面-亮-膜", "正面-亮-膜，反面-哑-膜"};
    JComboBox jcomb2 = new JComboBox(this.str2);
    JCheckBox[] jcb = new JCheckBox[5];

    public ManageAddOrder(Frame fck, ManageOrder manageorder) {
        this.fra = fck;
        this.manageorder = manageorder;
        Vector<String[]> kdziduan = new LiemingAndRemarks().getKaidanZiduan();
        
        //System.out.println(kdziduan.get(0));//-----------------------------------------------------
        
        this.ename = kdziduan.get(0);
        String[] cname = kdziduan.get(1);
        String[] inputremarks = kdziduan.get(2);
        this.zdtotal = this.ename.length;
        this.bq = new JLabel[cname.length - 6];
        this.wbk = new JTextField[this.ename.length - 6];
        this.remarks = new JLabel[this.ename.length - 6];
        for (int i = 0; i < this.ename.length; i++) {
            if (i < this.ename.length - 6) {
                this.bq[i] = new JLabel(String.valueOf(cname[i]) + " :");
                this.remarks[i] = new JLabel(inputremarks[i]);
                this.remarks[i].setForeground(Color.LIGHT_GRAY);
                this.wbk[i] = new JTextField(15);
                if (this.ename[i].equals("customername")) {
                    this.wbk[i].setText("按 回车键 选择...");
                    this.wbk[i].setForeground(Color.lightGray);
                }
                this.wbk[i].addActionListener(this);
            } else if (i > 9 && i < 15) {
                this.jcb[i - 10] = new JCheckBox(cname[i]);
            }
        }
        new If_notEdit().kaiDanNotEdit(this.wbk, this.ename);
        this.wbk[1].setActionCommand("customername");
        this.an1 = new JButton("确认下单");
        this.an1.addActionListener(this);
        this.an1.setActionCommand("confirm");
        this.an2 = new JButton("清空");
        this.an2.addActionListener(this);
        this.an2.setActionCommand("clear");
        this.jcb[4].addActionListener(this);
        this.jcomb1.addActionListener(this);
        this.jcomb1.setEnabled(false);
        this.jcomb2.setEnabled(false);
        this.mb1 = new JPanel();
        this.mb1.setLayout((LayoutManager) null);
        this.mb2 = new JPanel();
        this.mb2.setLayout((LayoutManager) null);
        for (int i2 = 0; i2 < this.bq.length; i2++) {
            this.mb1.add(this.bq[i2]);
            this.mb1.add(this.wbk[i2]);
            this.mb1.add(this.remarks[i2]);
        }
        for (int i3 = 0; i3 < this.jcb.length; i3++) {
            this.mb2.add(this.jcb[i3]);
        }
        this.mb2.add(this.an1);
        this.mb2.add(this.an2);
        this.mb2.add(this.jcomb1);
        this.mb2.add(this.jcomb2);
        this.mb2.add(this.fmbq1);
        this.mb2.add(this.fmbq2);
        this.mbtop = new JPanel();
        this.mbtop.setLayout(new GridLayout(2, 1));
        this.mbtop.add(this.mb1);
        this.mbtop.add(this.mb2);
        setMyBounds();
        initJp();
    }

    public void initJp() {
        this.jsp = new JSplitPane(0, true);
        this.head = new Vector<>();
        this.sois = new SqlOrderInfoShow("老总");
        String[] lieming = new LiemingAndRemarks().getKaidanZiduan().get(1);
        Vector<String> cname = new Vector<>();
        for (String str : lieming) {
            cname.add(str);
        }
        for (int i = 0; i < cname.size(); i++) {
            this.head.add(cname.get(i).toString());
        }
        this.data = new Vector<>();
        this.dtm = new DefaultTableModel(this.data, this.head);
        this.jt = new JTable(this.dtm);
        this.jspn = new JScrollPane(this.jt);
        setLayout(new GridLayout(1, 1));
        this.jsp.setTopComponent(this.mbtop);
        this.jsp.setBottomComponent(this.jspn);
        this.jsp.setDividerSize(4);
        add(this.jsp);
        this.jsp.setDividerLocation(700);
        setBounds(10, 10, 800, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("customername")) {
            new SelectCustomer(this.fra, true, this.wbk, this.ename);
            return;
        }
        for (int i = 0; i < this.wbk.length; i++) {
            if (e.getSource() == this.wbk[i] && i + 1 < this.wbk.length) {
                this.wbk[i + 1].requestFocus();
                return;
            }
        }
        if (e.getActionCommand() == this.jcb[4].getActionCommand() || e.getActionCommand() == this.jcomb1.getActionCommand()) {
            lamminationInfoJudge();
        }
        if (e.getActionCommand().equals("confirm")) {
            Vector<String> inputdata = new Vector<>();
            Vector<String> inputziduan = new Vector<>();
            for (int i2 = 0; i2 < this.wbk.length; i2++) {
                if (this.wbk[i2].getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, String.valueOf(this.bq[i2].getText()) + " ----不能为空！！！", "信息", 1);
                    return;
                } else {
                    inputdata.add(this.wbk[i2].getText().trim());
                }
            }
            for (int i3 = 0; i3 < this.jcb.length; i3++) {
                if (this.jcb[i3].isSelected()) {
                    inputdata.add("未完成");
                } else {
                    inputdata.add("--无--");
                }
            }
            if (!this.jcb[4].isSelected()) {
                inputdata.add("--无--");
            } else if (this.jcomb2.getSelectedItem().toString().equals("请选择...")) {
                JOptionPane.showMessageDialog(this, "请在 “哑膜 or 亮膜” 选项 选择信息", "信息", 1);
                return;
            } else {
                inputdata.add(this.jcomb2.getSelectedItem().toString());
            }
            for (int i4 = 0; i4 < this.ename.length; i4++) {
                inputziduan.add(this.ename[i4]);
            }
            inputziduan.add("orderdate");
            inputdata.add("date");
            if (new CaoZuo().insert(this.f5gongju.getInsertSql(inputziduan), inputdata)) {
                JOptionPane.showMessageDialog(this, "下单成功！！！", "消息", -1, new ImageIcon("image/label_8.jpg"));
                this.manageorder.upTable(this.sois.getOrderinfosql());
                return;
            }
            JOptionPane.showMessageDialog(this, "\n失败！ 请检查各项数据！\n或者 联系管理员！\n   ", "消息", 2);
        } else if (e.getActionCommand().equals("clear")) {
            for (int i5 = 0; i5 < this.wbk.length; i5++) {
                this.wbk[i5].setText("");
            }
        }
    }

    public void lamminationInfoJudge() {
        if (this.jcb[4].isSelected()) {
            this.jcomb1.setEnabled(true);
            if (this.jcomb1.getSelectedItem().toString().equals("单面")) {
                this.jcomb2.removeAllItems();
                for (int i = 0; i < this.str2.length; i++) {
                    this.jcomb2.addItem(this.str2[i]);
                }
                this.jcomb2.setEnabled(true);
            } else if (this.jcomb1.getSelectedItem().toString().equals("双面")) {
                this.jcomb2.removeAllItems();
                for (int i2 = 0; i2 < this.str3.length; i2++) {
                    this.jcomb2.addItem(this.str3[i2]);
                }
                this.jcomb2.setEnabled(true);
            } else {
                this.jcomb2.setEnabled(false);
            }
        } else {
            this.jcomb1.setEnabled(false);
            this.jcomb2.setEnabled(false);
        }
    }

    public void setMyBounds() {
        for (int i = 0; i < this.bq.length; i++) {
            this.bq[i].setBounds(200, 30 + (i * 30), 100, 20);
            this.wbk[i].setBounds(310, 30 + (i * 30), 120, 20);
            this.remarks[i].setBounds(450, 30 + (i * 30), 180, 20);
        }
        this.jcb[0].setBounds(200, 20, 80, 20);
        this.jcb[1].setBounds(280, 20, 80, 20);
        this.jcb[2].setBounds(360, 20, 80, 20);
        this.jcb[3].setBounds(440, 20, 80, 20);
        this.jcb[4].setBounds(200, 70, 60, 20);
        this.fmbq1.setBounds(270, 70, 80, 20);
        this.jcomb1.setBounds(360, 70, 70, 20);
        this.fmbq2.setBounds(480, 70, 80, 20);
        this.jcomb2.setBounds(570, 70, 180, 20);
        this.an1.setBounds(280, 170, 100, 25);
        this.an2.setBounds(390, 170, 100, 25);
    }
}