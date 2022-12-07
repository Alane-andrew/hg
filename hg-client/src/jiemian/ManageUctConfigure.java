package jiemian;

import gongju.GongJu;
import gongju.LiemingAndRemarks;
import gongju.SqlOrderInfoShow;
import gongju.SqlUctInfoShow;
import gongju.UctInfo;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import moshi.CaoZuo;
import zidingyi.ImageLogo;

public class ManageUctConfigure extends JPanel implements ActionListener {
    SqlOrderInfoShow sois;
    SqlUctInfoShow suis;

    GongJu f9gongju = new GongJu();
    CaoZuo cz = new CaoZuo();
    UctInfo uctdata;
    private JSplitPane jsp;
    private JPanel mb1;
    private JTable jt;
    private JScrollPane jspn;
    JLabel[] bq;
    JTextField[] wbk;
    JButton an1;
    JButton an2;
    JButton an3;
    Vector<String[]> uctziduan;
    int zdtotal;
    String[] ename;
    Frame fra;
    String type;

    public ManageUctConfigure(Frame fra, String type) {
        this.fra = fra;
        this.type = type;
        this.suis = new SqlUctInfoShow(type);
        this.uctdata = new UctInfo(this.suis.getUctSql(), type);
        this.uctziduan = new LiemingAndRemarks().getUctZiduan(type);
        this.ename = this.uctziduan.get(0);
        String[] cname = this.uctziduan.get(1);
        this.zdtotal = this.ename.length;
        this.bq = new JLabel[cname.length];
        this.wbk = new JTextField[this.ename.length];
        for (int i = 0; i < this.ename.length; i++) {
            this.bq[i] = new JLabel(String.valueOf(cname[i]) + " :");
            this.wbk[i] = new JTextField(15);
            this.wbk[i].addActionListener(this);
            this.wbk[i].setActionCommand(this.ename[i]);
            if (this.ename[i].equals("authority")) {
                this.wbk[i].setText("按 回车键 选择...");
                this.wbk[i].setForeground(Color.lightGray);
            }
        }
        this.an1 = new JButton("添加");
        this.an1.addActionListener(this);
        this.an1.setActionCommand("tianjia");
        this.an2 = new JButton("清空");
        this.an2.addActionListener(this);
        this.an2.setActionCommand("clear");
        this.an3 = new JButton("删除");
        this.an3.addActionListener(this);
        this.an3.setActionCommand("delete");
        this.mb1 = new JPanel();
        this.mb1.setLayout((LayoutManager) null);
        for (int i2 = 0; i2 < this.bq.length; i2++) {
            this.mb1.add(this.bq[i2]);
            this.mb1.add(this.wbk[i2]);
        }
        this.mb1.add(this.an1);
        this.mb1.add(this.an2);
        this.mb1.add(this.an3);
        setMyBounds();
        initJp();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("authority")) {
            new SelectPower(this.fra, true, this.wbk, this.ename);
        }
        for (int i = 0; i < this.wbk.length; i++) {
            if (e.getSource() == this.wbk[i] && i + 1 < this.wbk.length) {
                this.wbk[i + 1].requestFocus();
                return;
            }
        }
        if (e.getActionCommand().equals("tianjia")) {
            for (int i2 = 0; i2 < this.wbk.length; i2++) {
                if (this.wbk[i2].getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, String.valueOf(this.bq[i2].getText()) + " ----不能为空！！！", "信息", 1);
                    return;
                }
            }
            Vector<String> inputdata = new Vector<>();
            Vector<String> inputziduan = new Vector<>();
            for (int i3 = 0; i3 < this.wbk.length; i3++) {
                inputdata.add(this.wbk[i3].getText().trim());
            }
            for (int i4 = 0; i4 < this.ename.length; i4++) {
                inputziduan.add(this.ename[i4]);
            }
            if (this.cz.insert(this.f9gongju.getUctInsertSql(inputziduan, this.type), inputdata)) {
                upTable();
                JOptionPane.showMessageDialog(this, "添加成功！！！", "消息", -1, new ImageLogo().getLogoOk());
                for (int i5 = 0; i5 < this.wbk.length; i5++) {
                    this.wbk[i5].setText("");
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "\n失败！ 请检查各项数据！\n或者 联系管理员！\n   ", "消息", 2);
        } else if (e.getActionCommand().equals("delete")) {
            int hang = this.jt.getSelectedRow();
            if (hang == -1) {
                JOptionPane.showMessageDialog(this, "请选中要删除的行");
                return;
            }
            Vector<String> value = new Vector<>();
            value.add((String) this.uctdata.getValueAt(hang, 0));
            String zdname = this.uctdata.getColumnEname(0);
            if (JOptionPane.showConfirmDialog(this, "确定删除  " + value + " 数据？？？", "删除确认对话框", 2) != 2) {
                if (this.cz.delete(this.f9gongju.getUctDeleteSql(this.type, zdname), value)) {
                    upTable();
                } else {
                    JOptionPane.showMessageDialog(this, "操作失败，请检查各项数据 或 联系 管理员！！！", "消息", 2);
                }
            }
        } else if (e.getActionCommand().equals("clear")) {
            for (int i6 = 0; i6 < this.wbk.length; i6++) {
                this.wbk[i6].setText("");
            }
        }
    }

    public void initJp() {
        this.jsp = new JSplitPane(0, true);
        this.jt = new JTable(this.uctdata);
        this.f9gongju.setTableRowHeight(this.jt);
        this.jspn = new JScrollPane(this.jt);
        this.jsp.setTopComponent(this.mb1);
        this.jsp.setBottomComponent(this.jspn);
        this.jsp.setDividerLocation(300);
        this.jsp.setDividerSize(4);
        this.jsp.setEnabled(false);
        setLayout(new GridLayout(1, 1));
        add(this.jsp);
        setBounds(10, 10, 800, 600);
        setVisible(true);
    }

    public void upTable() {
        this.uctdata = new UctInfo(this.suis.getUctSql(), this.type);
        this.jt.setModel(this.uctdata);
    }

    public void setMyBounds() {
        for (int i = 0; i < this.bq.length; i++) {
            this.bq[i].setBounds(200, 30 + (i * 30), 100, 20);
            this.wbk[i].setBounds(310, 30 + (i * 30), 120, 20);
        }
        this.an1.setBounds(280, 170, 100, 25);
        this.an2.setBounds(390, 170, 100, 25);
        this.an3.setBounds(500, 170, 100, 25);
    }
}