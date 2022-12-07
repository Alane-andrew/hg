package gongju;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class GongJu {
    public void dateToDate(Vector<String> value) {
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i).equals("date")) {
                value.set(i, getShijian());
            }
        }
    }

    public String getShijian() {
        String time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
}