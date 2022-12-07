package zidingyi;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    ImageIcon im;

    public void setImage(ImageIcon im) {
        setLayout(null);
        this.im = im;
        setSize(200, 200);
        repaint();
    }

    public void paint(Graphics g) {
        ImagePanel.super.paint(g);
        g.drawImage(this.im.getImage(), 0, 0, 200, 200, this);
    }
}
