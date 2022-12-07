package gongju;

import java.util.Vector;
import javax.swing.ImageIcon;

public class KcPhoto {
    static Vector<ImageIcon> jilu_photo = new Vector<>();

    public static void setJiluPhoto(ImageIcon smallicon) {
        jilu_photo.add(smallicon);
    }

    public static ImageIcon getJiluPhoto(int a) {
        return jilu_photo.get(a);
    }

    public static void addOneImageIcon(ImageIcon ii) {
        jilu_photo.add(ii);
    }
}