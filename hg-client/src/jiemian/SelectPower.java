package jiemian;

import java.awt.Color;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SelectPower extends JDialog implements ActionListener {
    JButton an1;
    JButton an2;
    JRadioButton jrb;
    ButtonGroup dxz = new ButtonGroup();
    JTextField[] wbk;
    String[] ename;

    public SelectPower(Frame fra, Boolean msck, JTextField[] wbk, String[] ename) {
        super(fra, msck.booleanValue());
        this.wbk = wbk;
        this.ename = ename;
        String[] power = {"老总", "印刷", "后道", "发货", "仓管"};
        JPanel jp = new JPanel();
        jp.setLayout((LayoutManager) null);
        for (int i = 0; i < power.length; i++) {
            this.jrb = new JRadioButton(power[i]);
            if (i < 10) {
                this.jrb.setBounds(30, 30 + (i * 40), 120, 30);
            } else {
                this.jrb.setBounds(180, (30 + (i * 40)) - 400, 120, 30);
            }
            this.jrb.setActionCommand(power[i]);
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
        setTitle("选择用户权限");
        setSize(400, 500);
        setLocation(200, 50);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
            if (this.dxz.isSelected((ButtonModel) null)) {
                JOptionPane.showMessageDialog(this, "请选择 用户权限");
                return;
            }
            int i = 0;
            while (true) {
                if (i >= this.ename.length) {
                    break;
                } else if (this.ename[i].equals("authority")) {
                    this.wbk[i].setText(this.dxz.getSelection().getActionCommand());
                    this.wbk[i].setForeground(Color.BLACK);
                    break;
                } else {
                    i++;
                }
            }
            dispose();
        } else if (e.getActionCommand().equals("quxiao")) {
            dispose();
        }
    }
}