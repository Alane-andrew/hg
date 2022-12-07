package jiemian;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gongju.LoginProcess;
import gongju.NoServerWindow;
import gongju.SqlOrderInfoShow;
import zidingyi.ImageLogo;

public class Login extends JFrame implements ActionListener {
    private JPanel jp = new JPanel();
    private JLabel[] jlArray = {new JLabel("用户名: "), new JLabel("密  码: ")};
    private JLabel lb = new JLabel("");
    private JButton[] jbArray = {new JButton("登 录"), new JButton("取消")};
//    private JTextField userjtf = new JTextField("");
//    private JPasswordField jpassword = new JPasswordField();
    private JTextField userjtf = new JTextField("101");//直接在文本域里设置默认值
    private JPasswordField jpassword = new JPasswordField("123456");//直接在密码框里设置默认值

    public static void main(String[] args) {
        new Login();
    }

    public Login() {
        NoServerWindow.setFrame(this);
        this.jp.setLayout((LayoutManager) null);
        for (int i = 0; i < this.jlArray.length; i++) {
            this.jlArray[i].setBounds(30, 20 + (i * 80), 80, 25);
            this.jp.add(this.jlArray[i]);
        }
        for (int i2 = 0; i2 < this.jbArray.length; i2++) {
            this.jbArray[i2].setBounds(50 + (i2 * 120), 200, 80, 25);
            this.jp.add(this.jbArray[i2]);
            this.jbArray[i2].addActionListener(this);
        }
        this.lb.setBounds(20, 230, 300, 25);
        this.userjtf.setBounds(80, 20, 180, 25);
        this.jp.add(this.userjtf);
        this.userjtf.addActionListener(this);
        this.jpassword.setBounds(80, 100, 180, 25);
        this.jp.add(this.jpassword);
        this.jpassword.setEchoChar('*');
        this.jpassword.addActionListener(this);
        this.jp.add(this.lb);
        add(this.jp);
        setIconImage(new ImageLogo().getLogoTitle().getImage());
        setTitle("宏冠印业生产管理系统");
        setDefaultCloseOperation(3);
        setResizable(false);
        setBounds(100, 100, 400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.userjtf) {
            this.jpassword.requestFocus();
        } else if (e.getSource() == this.jbArray[0]) {
            if (this.userjtf.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "用户名 不能为空！！！", "信息", 1);
            } else if (String.valueOf(this.jpassword.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(this, "密码 不能为空！！！", "信息", 1);
            } else {
                LoginProcess loginprocess = new LoginProcess();
                Thread t = new Thread(loginprocess);
                t.setDaemon(true);
                t.start();
//                System.out.println("hhhhhhhhhhhhhh");//--------------------
                new Thread(new denglu(this, loginprocess, this.lb, this.userjtf, this.jpassword)).start();
//                System.out.println("pppppppppp");//---------------
                setVisible(false);
            }
        } else if (e.getSource() == this.jbArray[1]) {
            System.exit(0);
        }
    }
}