package jiemian;

import gongju.GongJu;
import gongju.OrderInfo;
import gongju.OrderProcess;
import gongju.SqlOrderInfoShow;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class ManageOrder extends JPanel implements ActionListener {
    Frame fra;
    OrderInfo orderinfo;
    OrderInfo orderinfo_clone;
    SqlOrderInfoShow sois;

    GongJu f6gongju = new GongJu();
    private JSplitPane jsp = new JSplitPane(0, true);
    private JPanel jpt = new JPanel();
    private JButton an1 = new JButton("修改订单记录");
    private JButton an2 = new JButton("更新");
    private JButton an3 = new JButton("查询");
    private JRadioButton jrb1 = new JRadioButton("未完成订单", true);
    private JRadioButton jrb2 = new JRadioButton("已完成订单");
    private JRadioButton jrb3 = new JRadioButton("订单进度");
    private ButtonGroup jrbbg = new ButtonGroup();
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    JTable jt;
    JScrollPane jspn;

    public ManageOrder(Frame fck, Boolean ckm, SqlOrderInfoShow sois) {
        this.fra = fck;
        this.orderinfo = new OrderInfo(sois.getOrderinfosql());
        try {
            this.orderinfo_clone = (OrderInfo) this.orderinfo.clone();
        } catch (CloneNotSupportedException e) {
        }
        this.sois = sois;
        this.jt = new JTable(this.orderinfo);
        this.f6gongju.setTableRowHeight(this.jt);
        this.jspn = new JScrollPane(this.jt);
        this.an1.setBounds(50, 40, 120, 25);
        this.an1.addActionListener(this);
        this.an1.setActionCommand("xiugai");
        this.an2.setBounds(this.screensize.width - 280, 40, 80, 25);
        this.an2.addActionListener(this);
        this.an2.setActionCommand("gengxin");
        this.jrb1.setBounds(50, 10, 120, 25);
        this.jrb2.setBounds(200, 10, 120, 25);
        this.jrb3.setBounds(350, 10, 120, 25);
        if (sois.getPower().equals("老总") || sois.getPower().equals("后道")) {
            this.jrb3.setEnabled(true);
        } else {
            this.jrb3.setEnabled(false);
        }
        this.an3.setBounds(500, 10, 80, 25);
        this.an3.addActionListener(this);
        this.an3.setActionCommand("chaxun");
        this.jrbbg.add(this.jrb1);
        this.jrbbg.add(this.jrb2);
        this.jrbbg.add(this.jrb3);
        this.jpt.setLayout((LayoutManager) null);
        this.jpt.add(this.an1);
        this.jpt.add(this.an2);
        this.jpt.add(this.jrb1);
        this.jpt.add(this.jrb2);
        this.jpt.add(this.jrb3);
        this.jpt.add(this.an3);
        this.jsp.setDividerLocation(80);
        this.jsp.setDividerSize(4);
        this.jsp.setEnabled(false);
        this.jsp.setTopComponent(this.jpt);
        this.jsp.setBottomComponent(this.jspn);
        setLayout(new GridLayout(1, 1));
        add(this.jsp);
        setBounds(5, 5, 600, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("xiugai")) {
            int ii = this.jt.getSelectedRow();
            if (ii == -1) {
                JOptionPane.showMessageDialog(this, "请选中要修改的行");
            } else if (new Xiugai(this.fra, "修改订单记录", true, this.orderinfo, ii, this.sois).uptable) {
                upTable(this.sois.getOrderinfosql());
            } else {
                infoClone();
                this.jt.setModel(this.orderinfo);
            }
        } else if (e.getActionCommand().equals("chaxun")) {
            if (this.jrb1.isSelected()) {
                this.orderinfo = new OrderInfo(this.sois.getOrderinfosql());
                this.jt.setModel(this.orderinfo);
                this.jsp.setDividerLocation(this.jsp.getDividerLocation());
                this.jsp.setDividerSize(this.jsp.getDividerSize());
                this.jsp.setBottomComponent(this.jspn);
            } else if (this.jrb2.isSelected()) {
                this.orderinfo = new OrderInfo(this.sois.getFinishedorderinfosql());
                this.jt.setModel(this.orderinfo);
                this.jsp.setDividerLocation(this.jsp.getDividerLocation());
                this.jsp.setDividerSize(this.jsp.getDividerSize());
                this.jsp.setBottomComponent(this.jspn);
            } else if (this.jrb3.isSelected()) {
                this.jsp.setDividerLocation(this.jsp.getDividerLocation());
                this.jsp.setDividerSize(this.jsp.getDividerSize());
                this.jsp.setBottomComponent(new OrderProcess(this.sois, this.fra).getJsp());
                return;
            }
            try {
                this.orderinfo_clone = (OrderInfo) this.orderinfo.clone();
            } catch (CloneNotSupportedException e2) {
            }
        } else if (!e.getActionCommand().equals("gengxin")) {
        } else {
            if (this.jrb1.isSelected()) {
                upTable(this.sois.getOrderinfosql());
            } else if (this.jrb2.isSelected()) {
                upTable(this.sois.getFinishedorderinfosql());
            } else if (this.jrb3.isSelected()) {
                this.jsp.setDividerLocation(this.jsp.getDividerLocation());
                this.jsp.setDividerSize(this.jsp.getDividerSize());
                this.jsp.setBottomComponent(new OrderProcess(this.sois, this.fra).getJsp());
            }
        }
    }

    public void infoClone() {
        try {
            this.orderinfo = (OrderInfo) this.orderinfo_clone.clone();
        } catch (CloneNotSupportedException e) {
        }
    }

    public void upTable(String sql) {
        this.orderinfo = new OrderInfo(sql);
        this.jt.setModel(this.orderinfo);
        try {
            this.orderinfo_clone = (OrderInfo) this.orderinfo.clone();
        } catch (CloneNotSupportedException e) {
        }
    }
}