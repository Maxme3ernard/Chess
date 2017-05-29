package chess.display.paint;

import chess.display.paint.PaintSkin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by coni on 27/05/2017.
 */
public class HoverEffect implements PaintSkin {
    private final float rMin, rMax;
    private final Color color;
    private final float alphaComposite;

    public HoverEffect(float rMin, float rMax, Color color, float alphaComposite) {
        this.rMin = rMin;
        this.rMax = rMax;
        this.color = color;
        this.alphaComposite = alphaComposite;
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        int radius = c.getWidth();
        float[] dist = {rMin,rMax};
        Color[] colors = {new Color(0,0,0,0), color};
        RadialGradientPaint paint = new RadialGradientPaint(c.getWidth()/2,c.getHeight()/2,radius, dist, colors);
        g2.setPaint(paint);

        Composite old = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaComposite));

        g2.fillRect(0,0,c.getWidth(), c.getHeight());

        g2.setComposite(old);
    }
}
