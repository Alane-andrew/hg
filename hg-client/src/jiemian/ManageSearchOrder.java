package jiemian;

import gongju.GongJu;
import gongju.OrderInfo;
import gongju.SqlOrderInfoShow;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ManageSearchOrder extends JPanel implements ActionListener {
    Frame fra;
    OrderInfo orderinfo;
    OrderInfo orderinfo_clone;
    SqlOrderInfoShow sois;

    GongJu f7gongju = new GongJu();
    private JSplitPane jsp = new JSplitPane(0, true);
    private JPanel jpt = new JPanel();
    private JLabel bq1 = new JLabel("订单编号:");
    private JTextField wbk1 = new JTextField();
    private JButton an1 = new JButton("查询订单");
    private JButton an2 = new JButton("修改订单记录");
    private String sql = null;
    JTable jt = new JTable();
    JScrollPane jspn = new JScrollPane(this.jt);

    public ManageSearchOrder(Frame fck, Boolean ckm, SqlOrderInfoShow sois) {
        this.fra = fck;
        this.sois = sois;
        this.f7gongju.setTableRowHeight(this.jt);
        this.jsp.setDividerLocation(40);
        this.jsp.setDividerSize(4);
        this.jsp.setEnabled(false);
        this.jsp.setTopComponent(this.jpt);
        this.jsp.setBottomComponent(this.jspn);
        this.jpt.setLayout((LayoutManager) null);
        this.jpt.add(this.bq1);
        this.jpt.add(this.wbk1);
        this.jpt.add(this.an1);
        this.jpt.add(this.an2);
        this.bq1.setBounds(50, 10, 80, 25);
        this.wbk1.setBounds(130, 10, 150, 25);
        this.wbk1.addActionListener(this);
        this.an1.setBounds(320, 10, 100, 25);
        this.an1.addActionListener(this);
        this.an1.setActionCommand("chaxun");
        this.an2.setBounds(520, 10, 120, 25);
        this.an2.addActionListener(this);
        this.an2.setActionCommand("xiugai");
        setLayout(new GridLayout(1, 1));
        add(this.jsp);
        setBounds(5, 5, 600, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("chaxun")) {
            String orderno = this.wbk1.getText().trim();
            if (orderno.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入要查询的订单编号！！！", "消息", 1);
                return;
            }
            this.sql = String.valueOf(this.sois.getSearchOrderinfosql()) + " where orderno='" + orderno + "'";
            this.orderinfo = new OrderInfo(this.sql);
            this.jt.setModel(this.orderinfo);
            try {
                this.orderinfo_clone = (OrderInfo) this.orderinfo.clone();
            } catch (CloneNotSupportedException e2) {
            }
        } else if (e.getActionCommand().equals("xiugai")) {
            int ii = this.jt.getSelectedRow();
            if (ii == -1) {
                JOptionPane.showMessageDialog(this, "请选中要修改的行");
            } else if (new Xiugai(this.fra, "修改订单记录", true, this.orderinfo, ii, this.sois).uptable) {
                upTable();
            } else {
                infoClone();
                this.jt.setModel(this.orderinfo);
            }
        }
    }

    public void infoClone() {
        try {
            this.orderinfo = (OrderInfo) this.orderinfo_clone.clone();
        } catch (CloneNotSupportedException e) {
        }
    }

    public void upTable() {
        this.orderinfo = new OrderInfo(this.sql);
        this.jt.setModel(this.orderinfo);
        try {
            this.orderinfo_clone = (OrderInfo) this.orderinfo.clone();
        } catch (CloneNotSupportedException e) {
        }
    }
}
