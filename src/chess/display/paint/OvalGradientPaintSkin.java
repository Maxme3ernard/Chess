package chess.display.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 * Created by coni on 28/05/2017.
 */
public class OvalGradientPaintSkin implements PaintSkin {
    private final Color color;
    private final float alphaComposite;
    private final double xRatio, yRatio;

    public OvalGradientPaintSkin(Color color, float alphaComposite, double xRatio, double yRatio) {
        this.color = color;
        this.alphaComposite = alphaComposite;
        this.xRatio = xRatio;
        this.yRatio = yRatio;
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        float yScale = 150;

        int radius = 90;
        float[] dist = {0,1f};
        Color[] colors = {color, new Color(0,0,0,0)};
        RadialGradientPaint paint = new RadialGradientPaint(c.getWidth()/2,c.getHeight()/2,radius, dist, colors);
        g2.setPaint(paint);

        Composite old = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaComposite));

        Point2D center = new Point2D.Float(100,100);

        AffineTransform moveToOrigin = AffineTransform.getTranslateInstance(-10d, -10d);
        AffineTransform moveToCenter = AffineTransform.getTranslateInstance(c.getWidth() / 2, c.getHeight() / 2);

        double y = 100 / 100d;
        double x = 1/y;

        AffineTransform at = AffineTransform.getScaleInstance(x, y);
        moveToCenter.concatenate(at);
        moveToCenter.concatenate(moveToOrigin);

        AffineTransform oldT = g2.getTransform();
        g2.setTransform(moveToCenter);


        int width = (int) (c.getWidth() * xRatio);
        int height = (int) (c.getHeight() * yRatio);
        //g2.fillOval((c.getWidth() - width) / 2,(c.getHeight() - height) / 2, width, height);

        g2.fillRect(-c.getWidth(), -c.getHeight(), c.getWidth() * 3, c.getHeight() * 3);
        g2.setComposite(old);
        g2.setTransform(oldT);
    }
}
