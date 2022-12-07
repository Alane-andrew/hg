package jiemian;

import gongju.FileChooser;
import gongju.GongJu;
import gongju.ImageBinary;
import gongju.OrderInfo;
import gongju.SqlOrderInfoShow;
import gongju.TableImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import moshi.CaoZuo;
import zidingyi.ImagePanel;

public class ManageStock extends JPanel implements ActionListener {
    Frame fra;
    OrderInfo orderinfo;
    SqlOrderInfoShow sois;
    private String pname;
    private int quantity;
    private int shuliang;
    private String finalquantity;
    private String sql_update;
    private Vector jilu_clone;
    private Vector<String> upinfo;
    private TableImage ti;
    private ImageIcon bigphoto;
    JTable jt;
    JScrollPane jspn;

    GongJu f8gongju = new GongJu();
    CaoZuo cz = new CaoZuo();
    private JSplitPane jsp = new JSplitPane(0, true);
    private JPanel jpt = new JPanel();
    private JLabel bq1 = new JLabel("货  号:");
    private JTextField wbk1 = new JTextField();
    private JTextField wbk2 = new JTextField();
    private JTextField wbk3 = new JTextField();
    private JLabel[] bq_add = {new JLabel("货号:"), new JLabel("数量:"), new JLabel("位置:"), new JLabel("图片:")};
    private JTextField[] wbk_add = {new JTextField(), new JTextField(), new JTextField(), new JTextField()};
    private JButton an1 = new JButton("查询");
    private JButton an2 = new JButton("确认");
    private JButton an3 = new JButton("增加");
    private JButton an4 = new JButton("提取");
    private JButton an5 = new JButton("选择图片");
    private String sql = null;
    private Vector jilu = new Vector();
    private Vector ziduan = new Vector();
    private String[] zdnamesql = {"pname", "pquantity", "position", "picadd"};
    private ImagePanel ip = new ImagePanel();

    public ManageStock(Frame fck, Boolean ckm, SqlOrderInfoShow sois) {
        this.ziduan.add("-- 货 号 --");
        this.ziduan.add("-- 库 存 数 量 --");
        this.ziduan.add("-- 存 放 位 置 --");
        this.ziduan.add("-- 图 片 --");
        this.fra = fck;
        this.sois = sois;
        if (sois.getPower().equals("老总")) {
            this.wbk2.setVisible(false);
            this.wbk3.setVisible(false);
            this.an2.setVisible(false);
            this.an3.setVisible(false);
            this.an4.setVisible(false);
            this.an5.setVisible(false);
            for (int i = 0; i < this.wbk_add.length; i++) {
                this.bq_add[i].setVisible(false);
                this.wbk_add[i].setVisible(false);
            }
        }
        this.jt = new JTable();
        this.jt.setRowHeight(80);
        this.jt.setFont(new Font("微软雅黑", 0, 18));
        this.jt.getTableHeader().setFont(new Font("微软雅黑", 1, 18));
        this.jspn = new JScrollPane(this.jt);
        this.jt.addMouseListener(new MouseAdapter() { // from class: jiemian.ManageStock.1
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    ManageStock.this.jt.getSelectedRow();
                    ManageStock.this.ip.setImage(ManageStock.this.bigphoto);
                    ManageStock.this.ip.updateUI();
                }
            }
        });
        this.jsp.setDividerLocation(350);
        this.jsp.setDividerSize(4);
        this.jsp.setEnabled(false);
        this.jsp.setTopComponent(this.jpt);
        this.jsp.setBottomComponent(this.jspn);
        this.jpt.setLayout((LayoutManager) null);
        this.jpt.add(this.bq1);
        this.jpt.add(this.wbk1);
        this.jpt.add(this.wbk2);
        this.jpt.add(this.wbk3);
        this.jpt.add(this.an1);
        this.jpt.add(this.an2);
        this.jpt.add(this.an3);
        this.jpt.add(this.an4);
        this.jpt.add(this.an5);
        this.ip.setImage(new ImageIcon("image/dd.png"));
        this.jpt.add(this.ip);
        this.ip.setBounds(450, 10, 80, 25);
        this.bq1.setBounds(50, 10, 80, 25);
        this.wbk1.setBounds(130, 10, 150, 25);
        this.wbk2.setBounds(130, 50, 150, 25);
        this.wbk3.setBounds(130, 100, 150, 25);
        this.wbk_add[3].setEditable(false);
        for (int i2 = 0; i2 < this.bq_add.length; i2++) {
            this.bq_add[i2].setBounds(50 + (i2 * 180), 250, 30, 25);
            this.wbk_add[i2].setBounds(90 + (i2 * 180), 250, 100, 25);
            this.jpt.add(this.bq_add[i2]);
            this.jpt.add(this.wbk_add[i2]);
        }
        this.an3.setBackground(Color.green);
        this.an4.setBackground(Color.red);
        this.an1.setBounds(320, 10, 100, 25);
        this.an1.addActionListener(this);
        this.an1.setActionCommand("chaxun");
        this.an2.setBounds(900, 250, 60, 25);
        this.an2.addActionListener(this);
        this.an2.setActionCommand("confirm");
        this.an3.setBounds(320, 50, 100, 25);
        this.an3.addActionListener(this);
        this.an3.setActionCommand("addquantity");
        this.an4.setBounds(320, 100, 100, 25);
        this.an4.addActionListener(this);
        this.an4.setActionCommand("extractquantity");
        this.an5.setBounds(740, 250, 90, 25);
        this.an5.addActionListener(this);
        this.an5.setActionCommand("filechooser");
        setLayout(new GridLayout(1, 1));
        add(this.jsp);
        setBounds(5, 5, 600, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("chaxun")) {
            String pname = this.wbk1.getText().trim();
            if (pname.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入要查询的订单编号！！！", "消息", 1);
                return;
            }
            this.sql = "select * from kcinfo where pname='" + pname + "'";
            upTable(this.sql);
        } else if (e.getActionCommand().equals("addquantity")) {
            int ii = this.jt.getSelectedRow();
            if (ii == -1) {
                JOptionPane.showMessageDialog(this, "请选中要修改的行");
            } else if (this.wbk2.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "请输入要 增加 的数量！！！", "消息", 1);
            } else {
                this.shuliang = Integer.parseInt(this.wbk2.getText().trim());
                this.quantity = ((Integer) this.jt.getValueAt(ii, 1)).intValue();
                this.pname = (String) this.jt.getValueAt(ii, 0);
                this.finalquantity = String.valueOf(this.shuliang + this.quantity);
                this.upinfo = new Vector<>();
                this.upinfo.add(this.pname);
                this.upinfo.add(this.finalquantity);
                this.sql_update = "update kcinfo set pquantity=? where pname=?";
                if (this.cz.moOrderInfo(this.sql_update, this.upinfo)) {
                    ((Vector) this.jilu.get(ii)).set(1, Integer.valueOf(Integer.parseInt(this.finalquantity)));
                    this.ti = new TableImage(this.jilu, this.ziduan);
                    this.jt.setModel(this.ti);
                }
            }
        } else if (e.getActionCommand().equals("extractquantity")) {
            int ii2 = this.jt.getSelectedRow();
            if (ii2 == -1) {
                JOptionPane.showMessageDialog(this, "请选中要修改的行");
            } else if (this.wbk3.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "请输入要 提取 的数量！！！", "消息", 1);
            } else {
                this.shuliang = Integer.parseInt(this.wbk3.getText().trim());
                this.quantity = ((Integer) this.jt.getValueAt(ii2, 1)).intValue();
                this.pname = (String) this.jt.getValueAt(ii2, 0);
                if (this.shuliang > this.quantity) {
                    JOptionPane.showMessageDialog(this, "数量不够！！！，请重先输入要提取的数量", "消息", 1);
                    return;
                }
                this.finalquantity = String.valueOf(this.quantity - this.shuliang);
                this.upinfo = new Vector<>();
                this.upinfo.add(this.pname);
                this.upinfo.add(this.finalquantity);
                this.sql_update = "update kcinfo set pquantity=? where pname=?";
                if (this.cz.moOrderInfo(this.sql_update, this.upinfo)) {
                    ((Vector) this.jilu.get(ii2)).set(1, Integer.valueOf(Integer.parseInt(this.finalquantity)));
                    this.ti = new TableImage(this.jilu, this.ziduan);
                    this.jt.setModel(this.ti);
                }
            }
        } else if (e.getActionCommand().equals("filechooser")) {
            FileChooser fc = new FileChooser();
            String imagepath = fc.chooseFile();
            if (!fc.b) {
                JOptionPane.showMessageDialog(this, "图片大于100K，无法上传！！！", "消息", 1);
                this.wbk_add[3].setText((String) null);
                return;
            }
            this.wbk_add[3].setText(imagepath);
        } else if (e.getActionCommand().equals("confirm")) {
            Vector hang = new Vector();
            if (this.jilu.isEmpty()) {
                this.jilu.add(hang);
            }
            for (int i = 0; i < this.wbk_add.length; i++) {
                if (this.wbk_add[i].getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "数据有误 或 未填写完整，请检查！！！", "消息", 1);
                    return;
                }
            }
            String imagestring = new ImageBinary().getImageBinary(this.wbk_add[3].getText().trim());
            this.upinfo = new Vector<>();
            for (int i2 = 0; i2 < this.wbk_add.length - 1; i2++) {
                this.upinfo.add(this.wbk_add[i2].getText().trim());
            }
            this.upinfo.add(imagestring);
            this.sql_update = "insert into kcinfo values(?,?,?,?)";
            if (this.cz.insertKc(this.sql_update, this.upinfo)) {
                hang.add(this.wbk_add[0].getText().trim());
                hang.add(Integer.valueOf(Integer.parseInt(this.wbk_add[1].getText().trim())));
                hang.add(Integer.valueOf(Integer.parseInt(this.wbk_add[2].getText().trim())));
                hang.add(imagestring);
                this.jilu.set(0, hang);
                this.bigphoto = new ImageBinary(this.jilu, this.zdnamesql).getBigphoto();
                this.ti = new TableImage(this.jilu, this.ziduan);
                this.jt.setModel(this.ti);
                for (int i3 = 0; i3 < this.wbk_add.length; i3++) {
                    this.wbk_add[i3].setText("");
                }
            }
        }
    }

    public void upTable(String sql) {
        this.orderinfo = new OrderInfo(sql, "searchKcInfo");
        this.jilu = this.orderinfo.getJilu();
        this.zdnamesql = this.orderinfo.getZdnamesql();
        this.bigphoto = new ImageBinary(this.jilu, this.zdnamesql).getBigphoto();
        this.ti = new TableImage(this.jilu, this.ziduan);
        this.jt.setModel(this.ti);
    }
}
