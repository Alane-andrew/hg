package gongju;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.Timer;
import zidingyi.ImagePanel;
import zidingyi.MyFont;

public class TopMenuBar extends JMenuBar implements ActionListener, MouseListener {
    Image titleIcon;
    Image timebg;
    JMenuBar jmb;
    JMenu jm1;
    JMenu jm2;
    JMenu jm3;
    JMenu jm4;
    JMenu jm5;
    JMenu jm6;
    JMenuItem jmm1;
    JMenuItem jmm2;
    JMenuItem jmm3;
    JMenuItem jmm4;
    JMenuItem jmm5;
    ImageIcon jm1_icon1;
    ImageIcon jm1_icon2;
    ImageIcon jm1_icon3;
    ImageIcon jm1_icon4;
    ImageIcon jm1_icon5;
    JToolBar jtb;
    JButton jb1;
    JButton jb2;
    JButton jb3;
    JButton jb4;
    JButton jb5;
    JButton jb6;
    JButton jb7;
    JButton jb8;
    JButton jb9;
    JButton jb10;
    JPanel jp3_1;
    JPanel jp3_2;
    JPanel jp3_3;
    JPanel jp3_4;
    JPanel jp3_5;
    JPanel jp3_6;
    JPanel jp3_7;
    ImagePanel jp1_imgPanel;
    Image jp1_bg;
    JLabel jp1_lab1;
    JLabel jp1_lab2;
    JLabel jp1_lab3;
    JLabel jp1_lab4;
    JLabel jp1_lab5;
    JLabel jp1_lab6;
    JLabel jp1_lab7;
    JLabel jp1_lab8;
    JLabel jp2_lab1;
    JLabel jp2_lab2;
    Image jp3_bg;
    JLabel jp3_l1;
    JLabel jp3_l2;
    JLabel jp3_l3;
    JLabel jp3_l4;
    JLabel jp3_l5;
    JLabel jp3_l6;
    JLabel jp3_l7;
    CardLayout cardjp2;
    CardLayout cardjp3;
    JSplitPane jsp1;
    JLabel timeNow;
    Timer t;

    public JMenuBar Tmb() {
        this.jm1_icon1 = new ImageIcon("image/jm1_icon1.jpg");
        this.jm1_icon2 = new ImageIcon("image/jm1_icon2.jpg");
        this.jm1_icon3 = new ImageIcon("image/jm1_icon3.jpg");
        this.jm1_icon4 = new ImageIcon("image/jm1_icon4.jpg");
        this.jm1_icon5 = new ImageIcon("image/jm1_icon5.jpg");
        this.jm1 = new JMenu("预留功能1");
        this.jm1.setFont(MyFont.f1);
        this.jmm1 = new JMenuItem("功能1-1", this.jm1_icon1);
        this.jmm1.setFont(MyFont.f2);
        this.jmm2 = new JMenuItem("功能1-2", this.jm1_icon2);
        this.jmm2.setFont(MyFont.f2);
        this.jmm3 = new JMenuItem("功能1-3", this.jm1_icon3);
        this.jmm3.setFont(MyFont.f2);
        this.jmm4 = new JMenuItem("功能1-4", this.jm1_icon4);
        this.jmm4.setFont(MyFont.f2);
        this.jmm5 = new JMenuItem("功能1-5", this.jm1_icon5);
        this.jmm5.setFont(MyFont.f2);
        this.jm1.add(this.jmm1);
        this.jm1.add(this.jmm2);
        this.jm1.add(this.jmm3);
        this.jm1.add(this.jmm4);
        this.jm1.add(this.jmm5);
        this.jm2 = new JMenu("预留功能2");
        this.jm2.setFont(MyFont.f1);
        this.jm3 = new JMenu("预留功能3");
        this.jm3.setFont(MyFont.f1);
        this.jm4 = new JMenu("预留功能4");
        this.jm4.setFont(MyFont.f1);
        this.jm5 = new JMenu("预留功能5");
        this.jm5.setFont(MyFont.f1);
        this.jm6 = new JMenu("预留功能6");
        this.jm6.setFont(MyFont.f1);
        this.jmb = new JMenuBar();
        this.jmb.add(this.jm1);
        this.jmb.add(this.jm2);
        this.jmb.add(this.jm3);
        this.jmb.add(this.jm4);
        this.jmb.add(this.jm5);
        this.jmb.add(this.jm6);
        return this.jmb;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}