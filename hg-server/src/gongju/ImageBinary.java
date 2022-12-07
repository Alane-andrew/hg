package gongju;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

public class ImageBinary {
//    BASE64Encoder encoder = new BASE64Encoder();
//    BASE64Decoder decoder = new BASE64Decoder();
    
    Decoder decoder=Base64.getMimeDecoder();
    Encoder encoder =Base64.getMimeEncoder();
    
    

    public ImageBinary() {
    }

    public ImageBinary(Vector jilu) {
        int lie = 0;
        int i = 0;
        while (true) {
            if (i >= ((String[]) jilu.get(0)).length) {
                break;
            } else if (((String[]) jilu.get(0))[i].equals("picadd")) {
                lie = i;
                break;
            } else {
                i++;
            }
        }
        for (int j = 2; j < jilu.size(); j++) {
            ((Vector) jilu.get(j)).set(lie, getImageBinary(((Vector) jilu.get(j)).get(lie).toString()));
        }
    }

    public String getImageBinary(String picadd) {
        try {
            BufferedImage bi = ImageIO.read(new File(picadd));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            bi.flush();
            baos.close();
//            return this.encoder.encodeBuffer(bytes).trim();
            return this.encoder.encode(bytes).toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String base64StringToImage(String base64String, String picname) {
        String picadd = "image/kc_image/" + picname + ".jpg";
        try {
//            ByteArrayInputStream bais = new ByteArrayInputStream(this.decoder.decodeBuffer(base64String));
            ByteArrayInputStream bais = new ByteArrayInputStream(this.decoder.decode(base64String));
            BufferedImage bi1 = ImageIO.read(bais);
            bi1.flush();
            bais.close();
            ImageIO.write(bi1, "jpg", new File(picadd));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picadd;
    }
}