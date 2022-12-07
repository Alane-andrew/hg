package jiemian;

import gongju.LoginProcess;
import gongju.NoServerWindow;
import gongju.SqlOrderInfoShow;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import moshi.CaoZuo;

class denglu implements Runnable {
    private JFrame fra;
    private LoginProcess loginprocess;
    private JLabel lb;
    private JTextField userjtf;
    private JPasswordField jpassword;

    public denglu(JFrame fra, LoginProcess loginprocess, JLabel lb, JTextField userjtf, JPasswordField jpassword) {
        this.fra = fra;
        this.loginprocess = loginprocess;
        this.lb = lb;
        this.userjtf = userjtf;
        this.jpassword = jpassword;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Vector<String> paras = new Vector<>();
            paras.add(this.userjtf.getText().trim());
            paras.add(String.valueOf(this.jpassword.getPassword()));
            String power = new CaoZuo().login("select authority from userinfo where username=? and pw=?", paras);
            
//            String power ="老总";
//            new SelfSystem(new SqlOrderInfoShow(power)); //-----test
            
            if (power.equals("无法连接服务器")) {
                this.loginprocess.setClose(false);
                NoServerWindow.openNoServerWindow();
                this.fra.setVisible(true);
            } else if (power.equals("false")) {
                this.loginprocess.setClose(false);
                this.fra.setVisible(true);
                this.lb.setText("用户名 或 密码 错误！请重先输入！！！");
            } else {
                new SelfSystem(new SqlOrderInfoShow(power));
                this.loginprocess.setClose(false);
                this.fra.dispose();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}