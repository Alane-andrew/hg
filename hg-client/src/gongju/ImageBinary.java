package gongju;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

public class ImageBinary {
    ImageIcon pic;
    Image cc;
    Image smallImage;
    ImageIcon smallicon;
    ImageIcon bigphoto;
    ByteArrayInputStream bais;
    ByteArrayOutputStream baos;
    BufferedImage bi1;
    BufferedImage bi;
    byte[] bytes;
    byte[] bytes1;
    File f;
    File w2;
//    BASE64Encoder encoder = new BASE64Encoder();
//    BASE64Decoder decoder = new BASE64Decoder();

      

   // [替换代码]
    //注不要使用.getDecoder();
    Decoder decoder=Base64.getMimeDecoder();
    Encoder encoder =Base64.getMimeEncoder();
//    byte[] buffer =decoder.decode(str);
    
    
    
    Vector<ImageIcon> jilu_photo = new Vector<>();
    ImageIcon ii = null;

    public ImageBinary() {
    }

    public ImageBinary(Vector jilu, String[] zdnamesql) {
        int lie = 0;
        int i = 0;
        while (true) {
            if (i >= zdnamesql.length) {
                break;
            } else if (zdnamesql[i].equals("picadd")) {
                lie = i;
                break;
            } else {
                i++;
            }
        }
        for (int j = 0; j < jilu.size(); j++) {
            this.pic = base64StringToImage(((Vector) jilu.get(j)).get(lie).toString());
            this.bigphoto = this.pic;
            this.cc = this.pic.getImage();
            this.smallImage = this.cc.getScaledInstance(80, 80, 2);
            this.smallicon = new ImageIcon(this.smallImage);
            ((Vector) jilu.get(j)).set(lie, this.smallicon);
        }
    }

    public ImageIcon getBigphoto() {
        return this.bigphoto;
    }

    public ImageIcon base64StringToImage(String base64String) {
        try {
//            this.bytes1 = this.decoder.decodeBuffer(base64String);
            this.bytes1 = this.decoder.decode(base64String);
            
            this.bais = new ByteArrayInputStream(this.bytes1);
            this.bytes1 = null;
            this.bi1 = ImageIO.read(this.bais);
            this.bi1.flush();
            this.bais.close();
            this.ii = new ImageIcon(this.bi1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.ii;
    }

    public String getImageBinary(String picadd) {
        this.f = new File(picadd);
        try {
            this.bi = ImageIO.read(this.f);
            this.bi.flush();
            this.baos = new ByteArrayOutputStream();
            ImageIO.write(this.bi, "jpg", this.baos);
            this.baos.close();
            this.bytes = this.baos.toByteArray();
//            return this.encoder.encodeBuffer(this.bytes).trim();
            return this.encoder.encode(this.bytes).toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Vector addOnePic(Vector hang, String[] zdnamesql) {
        int lie = 0;
        int i = 0;
        while (true) {
            if (i >= zdnamesql.length) {
                break;
            } else if (zdnamesql[i].equals("picadd")) {
                lie = i;
                break;
            } else {
                i++;
            }
        }
        hang.set(3, new ImageIcon(base64StringToImage(hang.get(lie).toString()).getImage().getScaledInstance(80, 80, 2)));
        return hang;
    }
}