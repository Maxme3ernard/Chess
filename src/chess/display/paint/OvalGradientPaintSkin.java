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

        int radius = c.getWidth();
        float[] dist = {0,1f};
        Color[] colors = {color, new Color(0,0,0,0)};
        RadialGradientPaint paint = new RadialGradientPaint(c.getWidth()/2,c.getHeight()/2,radius, dist, colors);
        g2.setPaint(paint);

        Composite old = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaComposite));

        /*Point2D cen = new Point2D.Float(c.getX() + c.getWidth()/2, c.getY() + c.getHeight() / 2);
        AffineTransform origin = AffineTransform.getTranslateInstance(-cen.getX(), -cen.getY());
        AffineTransform center = AffineTransform.getTranslateInstance(c.getWidth() / 2, c.getHeight() / 2);
        AffineTransform scale = AffineTransform.getScaleInstance(yScale / cen.getY(), 1 / (yScale / cen.getY()));
        center.concatenate(scale);
        center.concatenate(origin);*/

        AffineTransform oldT = g2.getTransform();
        g2.setTransform(AffineTransform.getScaleInstance(0.5, 1));


        int width = (int) (c.getWidth() * xRatio);
        int height = (int) (c.getHeight() * yRatio);
        //g2.fillOval((c.getWidth() - width) / 2,(c.getHeight() - height) / 2, width, height);

        g2.fillRect(c.getX()*10, c.getY(), c.getWidth() * 3, c.getHeight() * 3);
        g2.setComposite(old);
        g2.setTransform(oldT);
    }
}
