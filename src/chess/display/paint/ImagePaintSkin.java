package chess.display.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by coni on 27/05/2017.
 */
public class ImagePaintSkin implements PaintSkin {
    private final BufferedImage bufferedImage;
    private final double xRatio, yRatio;
    private final double fillRatio;

    public ImagePaintSkin(BufferedImage bufferedImage, double xRatio, double yRatio, double fillRatio) {
        this.bufferedImage = bufferedImage;
        this.xRatio = xRatio;
        this.yRatio = yRatio;
        this.fillRatio = fillRatio;
    }

    public ImagePaintSkin(BufferedImage bufferedImage, double fillRatio) {
        this(bufferedImage, 0.5f, 0.5f, fillRatio);
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        double w = bufferedImage.getWidth();
        double h = bufferedImage.getHeight();
        if (h >= w){
            double r = w / h;
            h = ((double)c.getHeight()) * fillRatio;
            w = h * r;
        } else {
            double r = h / w;
            w = ((double)c.getWidth()) * fillRatio;
            h = w * r;
        }

        g2.drawImage(bufferedImage,
                (int) (((double)c.getWidth()) * xRatio - w / 2),
                (int) (((double)c.getHeight()) * yRatio - h / 2), (int)w, (int)h, null);
    }
}
