package gongju;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import zidingyi.ImageLogo;

public class LoginProcess extends JFrame implements Runnable {
    private boolean close = true;
    private JProgressBar progress = new JProgressBar(1, 100);

    public LoginProcess() {
        this.progress.setStringPainted(true);
        this.progress.setForeground(Color.ORANGE);
        add(this.progress);
        setIconImage(new ImageLogo().getLogoTitle().getImage());
        setTitle("正在登陆服务器，请稍候...");
        setDefaultCloseOperation(3);
        setBounds(450, 300, 400, 70);
        setVisible(true);
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            this.progress.setValue(0);
            this.progress.setString("0%");
            for (int i = 0; i < 48; i++) {
                try {
                    this.progress.setValue(this.progress.getValue() + 2);
                    this.progress.setString(String.valueOf(this.progress.getValue()) + " %");
                    Thread.sleep(300);
                    if (!this.close) {
                        dispose();
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}