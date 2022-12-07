package gongju;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreatPicName {
    public String getPicName() {
        return String.valueOf(getShijian()) + createNumRandom();
    }

    public String createNumRandom() {
        Random random = new Random();
        String val = "";
        for (int i = 0; i < 6; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                val = String.valueOf(val) + ((char) ((random.nextInt(2) % 2 == 0 ? 65 : 97) + random.nextInt(26)));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val = String.valueOf(val) + String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public String getShijian() {
        String time = null;
        try {
            time = new SimpleDateFormat("yyyyMMdd").format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
}
