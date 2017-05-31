package chess.display.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by coni on 27/05/2017.
 */
public class ImagePaintSkin implements PaintSkin {
    private final BufferedImage bufferedImage;
    private final double fillRatio;

    public ImagePaintSkin(BufferedImage bufferedImage, double fillRatio) {
        this.bufferedImage = bufferedImage;
        this.fillRatio = fillRatio;
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

        g2.drawImage(bufferedImage, (int) ((c.getWidth() - w) /2), (int) ((c.getHeight() - h) / 2), (int)w, (int)h, null);
    }
}
