/**
 * Copyright(C) 2016 NMT
 *
 * Class ImageUtil.java Aug 23, 2016 Nguyen Manh Tung
 */
package tungnm.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class ImageUtil {

    public static BufferedImage downloadImage(String stringUrl) {
        BufferedImage bufferedImage = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(stringUrl);
            bufferedImage = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("Execute Method Exception " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return bufferedImage;
    }

    public static Image scaleMax(BufferedImage image, int max) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        double dWidth = 0;
        double dHeight = 0;
        if (width == height) {
            dWidth = max;
            dHeight = max;
        } else if (width > height) {
            dWidth = max;
            dHeight = ((double) height / (double) width) * max;
        } else {
            dHeight = max;
            dWidth = ((double) width / (double) height) * max;
        }
        Image scaleImage = image.getScaledInstance((int) dWidth, (int) dHeight, Image.SCALE_SMOOTH);
        return scaleImage;
    }

    public static Image scaleMin(BufferedImage image, int min) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        double dWidth = 0;
        double dHeight = 0;
        if (width == height) {
            dWidth = min;
            dHeight = min;
        } else if (width < height) {
            dWidth = min;
            dHeight = ((double) height / (double) width) * min;
        } else {
            dHeight = min;
            dWidth = ((double) width / (double) height) * min;
        }
        Image scaleImage = image.getScaledInstance((int) dWidth, (int) dHeight, Image.SCALE_SMOOTH);
        return scaleImage;
    }

    public static Image scaleMax(Image image, int max) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        double dWidth = 0;
        double dHeight = 0;
        if (width == height) {
            dWidth = max;
            dHeight = max;
        } else if (width > height) {
            dWidth = max;
            dHeight = ((double) height / (double) width) * max;
        } else {
            dHeight = max;
            dWidth = ((double) width / (double) height) * max;
        }
        Image scaleImage = image.getScaledInstance((int) dWidth, (int) dHeight, Image.SCALE_SMOOTH);
        return scaleImage;
    }

    public static Image scaleMin(Image image, int min) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        double dWidth = 0;
        double dHeight = 0;
        if (width == height) {
            dWidth = min;
            dHeight = min;
        } else if (width < height) {
            dWidth = min;
            dHeight = ((double) height / (double) width) * min;
        } else {
            dHeight = min;
            dWidth = ((double) width / (double) height) * min;
        }
        Image scaleImage = image.getScaledInstance((int) dWidth, (int) dHeight, Image.SCALE_SMOOTH);
        return scaleImage;
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }

    public static Image loadImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new FileInputStream(fileName));
        } catch (IOException e) {
            Logger.getLogger(ImageUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return image;
    }

    public static void saveImage(BufferedImage bufferedImage, String destinationFile) {
        try {
            File outputfile = new File(destinationFile);
            ImageIO.write(bufferedImage, "png", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(ImageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveImage(Image image, String destinationFile) {
        try {
            File outputfile = new File(destinationFile);
            ImageIO.write(toBufferedImage(image), "png", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(ImageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
