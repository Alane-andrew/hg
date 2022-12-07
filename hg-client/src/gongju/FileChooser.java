package gongju;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class FileChooser {
    public boolean b = true;

    public String chooseFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(0);
        jfc.setDialogTitle("请选择要上传的图片");
        if (jfc.showDialog(new JLabel(), "选择") == 1) {
            return null;
        }
        File file = jfc.getSelectedFile();
        if (file.length() <= 102400) {
            return file.getAbsolutePath();
        }
        this.b = false;
        return null;
    }
}