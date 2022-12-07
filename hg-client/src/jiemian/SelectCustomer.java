package jiemian;

import gongju.OrderInfo;
import java.awt.Color;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SelectCustomer extends JDialog implements ActionListener {
    JButton an1;
    JButton an2;
    JRadioButton jrb;
    JTextField[] wbk;
    String[] ename;
    ButtonGroup dxz = new ButtonGroup();
    Vector jilu = new OrderInfo("select * from kehuinfo").getJilu();
    

    public SelectCustomer(Frame fra, Boolean msck, JTextField[] wbk, String[] ename) {
        super(fra, msck.booleanValue());
        this.wbk = wbk;
        this.ename = ename;
        JPanel jp = new JPanel();
        jp.setLayout((LayoutManager) null);
        
//        System.out.println("jilu的size："+this.jilu.size());//12   ------------------------------
//        System.out.println("123:"+((Vector) this.jilu.get(1)).size());// 123:0   ??? --------------------
//        //子的size
//        
//        
////        System.out.println(((Vector) this.jilu.get(1)).get(0).toString());//--------
//        System.out.println(((Vector) this.jilu.get(1)).toString());//  []  --------------------
//        System.out.println(((Vector) this.jilu.get(1)));// []   --------------------
//        System.out.println(((Vector) this.jilu.get(1)).get(0).toString());//  没出来  --------------------
        
        
        
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
        setTitle("选择客户名称");
        setSize(400, 500);
        setLocation(200, 50);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
            if (this.dxz.isSelected((ButtonModel) null)) {
                JOptionPane.showMessageDialog(this, "请选择客户名称");
                return;
            }
            this.wbk[1].setText(this.dxz.getSelection().getActionCommand());
            this.wbk[1].setForeground(Color.BLACK);
            String customeradd = "";
            String contactno = "";
            int i = 0;
            while (true) {
                if (i >= this.jilu.size()) {
                    break;
                } else if (this.dxz.getSelection().getActionCommand().equals(((Vector) this.jilu.get(i)).get(0).toString())) {
                    customeradd = ((Vector) this.jilu.get(i)).get(1).toString();
                    contactno = ((Vector) this.jilu.get(i)).get(2).toString();
                    break;
                } else {
                    i++;
                }
            }
            for (int i2 = 0; i2 < this.ename.length; i2++) {
                if (this.ename[i2].equals("customeradd")) {
                    this.wbk[i2].setText(customeradd);
                } else if (this.ename[i2].equals("contactno")) {
                    this.wbk[i2].setText(contactno);
                }
            }
            dispose();
        } else if (e.getActionCommand().equals("quxiao")) {
            dispose();
        }
    }
}
