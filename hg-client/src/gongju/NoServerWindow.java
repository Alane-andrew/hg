package gongju;

import java.awt.Frame;
import javax.swing.JOptionPane;

public class NoServerWindow {
    private static Frame fra;

    public static void setFrame(Frame fck) {
        fra = fck;
    }

    public static void openNoServerWindow() {
        JOptionPane.showMessageDialog(fra, "无法与服务器连接，请检查网络 或 联系管理员！！！");
    }
}