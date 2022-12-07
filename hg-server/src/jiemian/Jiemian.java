package jiemian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moshi.Fuwu;

public class Jiemian extends JFrame implements ActionListener {
    JPanel jp1 = new JPanel();
    JButton jb1 = new JButton("启动主服务器");
    JButton jb2 = new JButton("关闭主服务器");

    public static void main(String[] args) {
        new Jiemian();
    }

    public Jiemian() {
        this.jb1.addActionListener(this);
        this.jb2.addActionListener(this);
        this.jp1.add(this.jb1);
        this.jp1.add(this.jb2);
        add(this.jp1);
        setSize(186, 168);
        setLocation(318, 186);
        setResizable(false);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jb1) {
            new Fuwu();
        } else if (e.getSource() == this.jb2) {
            System.exit(0);
        }
    }
}