package jiemian;

import gongju.NoServerWindow;
import gongju.SqlOrderInfoShow;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import zidingyi.ImageLogo;

public class SelfSystem extends JFrame implements ActionListener {
    SqlOrderInfoShow sois;
    JMenuBar tmb;
    DefaultMutableTreeNode[] dmtn;
    DefaultTreeModel dtm;
    JTree jt;
    JScrollPane jsp;
    private JSplitPane jsplr;
    Image image;
    ImageIcon ii;
    private JLabel jlRoot;
    private JPanel jp;
    CardLayout cl;

    public SelfSystem(SqlOrderInfoShow sois) {
        NoServerWindow.setFrame(this);
        this.sois = sois;
        initJp();
        this.jt.addTreeSelectionListener(new TreeSelectionListener() { // from class: jiemian.SelfSystem.1
            public void valueChanged(TreeSelectionEvent e) {
                NodeValue cnv = (NodeValue) ((DefaultMutableTreeNode) e.getPath().getLastPathComponent()).getUserObject();
                if (cnv.value.equals("用户管理系统")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "root");
                }
                if (cnv.value.equals("查询订单")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "so");
                } else if (cnv.value.equals("订单信息")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "mo");
                } else if (cnv.value.equals("开单")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "addorder");
                } else if (cnv.value.equals("用户配置")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "userconfigure");
                } else if (cnv.value.equals("订单客户配置")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "customerconfigure");
                } else if (cnv.value.equals("托运部配置")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "tybconfigure");
                } else if (cnv.value.equals("库存信息")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "managestock");
                } else if (cnv.value.equals("库存管理")) {
                    SelfSystem.this.cl.show(SelfSystem.this.jp, "managestock");
                } else if (cnv.value.equals("退出") && JOptionPane.showConfirmDialog(SelfSystem.this, "是否退出系统?", "消息", 0) == 0) {
                    System.exit(0);
                }
            }
        });
        for (int i = 1; i < this.dmtn.length; i++) {
            this.dtm.insertNodeInto(this.dmtn[i], this.dmtn[0], i - 1);
        }
        this.jt.setEditable(false);
        add(this.jsplr);
        this.jsplr.setLeftComponent(this.jt);
        this.jp.setBounds(200, 50, 300, 400);
        this.jsplr.setRightComponent(this.jp);
        this.jsplr.setDividerLocation(150);
        this.jsplr.setDividerSize(4);
        this.jsplr.setEnabled(false);
        this.jlRoot.setFont(new Font("Courier", 0, 30));
        this.jlRoot.setHorizontalAlignment(0);
        this.jlRoot.setVerticalAlignment(0);
        setDefaultCloseOperation(3);
        setIconImage(new ImageLogo().getLogoTitle().getImage());
        setTitle(sois.getTitle());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width / 2) - (500 / 2), ((screenSize.height / 2) - (400 / 2)) - 100, 500, 400);
        setExtendedState(6);
        setVisible(true);
        this.jt.setShowsRootHandles(true);
    }

    public void initJp() {
        Vector<String> nv = new Vector<>();
        for (String str : new String[]{"用户管理系统", "订单信息", "查询订单", "退出"}) {
            nv.add(str);
        }
        if (this.sois.getPower().equals("老总")) {
            nv.add(nv.size() - 1, "开单");
            //nv.add(nv.size() - 1, "库存信息");//因为“仓管” 这一权限尚未开发，所以这一栏先隐藏
            nv.add(nv.size() - 1, "用户配置");
            nv.add(nv.size() - 1, "订单客户配置");
        } else if (this.sois.getPower().equals("发货")) {
            //nv.add(nv.size() - 1, "库存管理");//因为“仓管” 这一权限尚未开发，所以这一栏先隐藏
            nv.add(nv.size() - 1, "托运部配置");
        }
        this.dmtn = new DefaultMutableTreeNode[nv.size()];
        for (int i = 0; i < nv.size(); i++) {
            this.dmtn[i] = new DefaultMutableTreeNode(new NodeValue(nv.get(i)));
        }
        this.dtm = new DefaultTreeModel(this.dmtn[0]);
        this.jt = new JTree(this.dtm);
        this.jsp = new JScrollPane(this.jt);
        this.jsplr = new JSplitPane(1, true);
        this.image = new ImageIcon("tsgl.jpg").getImage();
//        this.image = new ImageIcon("..image/hg32.png").getImage();
        this.ii = new ImageIcon(this.image);
        this.jlRoot = new JLabel(this.ii);
        this.jp = new JPanel();
        this.cl = new CardLayout();
        ManageOrder manageorder = new ManageOrder(this, true, this.sois);
        this.jp.setLayout(this.cl);
        this.jp.add(this.jlRoot, "root");
        this.jp.add(new ManageSearchOrder(this, true, this.sois), "so");
        this.jp.add(manageorder, "mo");
        this.jp.add(new ManageAddOrder(this, manageorder), "addorder");
        this.jp.add(new ManageUctConfigure(this, "user"), "userconfigure");
        this.jp.add(new ManageUctConfigure(this, "customer"), "customerconfigure");
        this.jp.add(new ManageUctConfigure(this, "tyb"), "tybconfigure");
        this.jp.add(new ManageStock(this, true, this.sois), "managestock");
    }

    public void actionPerformed(ActionEvent e) {
    }
}