package zidingyi;

import gongju.GongJu;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SPanel extends JPanel {
    boolean b;

    public SPanel(Vector zdname_value, ArrayList wbkjcblist, JButton an1) {
        this.b = false;
        setLayout(null);
        GongJu gongju2 = new GongJu();
        this.b = gongju2.proDataFinished(zdname_value);
        //System.out.println("2222222222222abc");//-----------------------
        if (this.b) {
            gongju2.componentsEnable(wbkjcblist);//设置文本框内容 不可修改，不可选中，灰色
            an1.setEnabled(false);
        }
    }

    public void paint(Graphics g) {
        SPanel.super.paint(g);
        if (this.b) {
            ImageIcon img = new ImageIcon("image/finished.png");
            g.drawImage(img.getImage(), 230, 50, img.getIconWidth(), img.getIconHeight(), this);
        }
    }
}