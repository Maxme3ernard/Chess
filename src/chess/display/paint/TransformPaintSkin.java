package chess.display.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.regex.Pattern;

/**
 * Created by coni on 29/05/2017.
 */
public class TransformPaintSkin implements PaintSkin {
    private final PaintSkin paintSkin;
    private final double xRatio, yRatio, xScale, yScale;

    public  TransformPaintSkin(PaintSkin paintSkin, double xRatio, double yRatio, double xScale, double yScale) {
        this.paintSkin = paintSkin;
        this.xRatio = xRatio;
        this.yRatio = yRatio;
        this.xScale = xScale;
        this.yScale = yScale;
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        AffineTransform old = g2.getTransform();
        AffineTransform transform = new AffineTransform();
        transform.concatenate(old);
        transform.translate(c.getWidth() * xRatio, c.getHeight() * yRatio);
        transform.scale(xScale, yScale);
        g2.setTransform(transform);
        paintSkin.paint(g2, c);
        g2.setTransform(old);
    }
}
