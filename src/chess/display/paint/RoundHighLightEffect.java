package chess.display.paint;

import chess.display.paint.PaintSkin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by coni on 28/05/2017.
 */
public class RoundHighLightEffect implements PaintSkin {
    private final Color innerColor, outerColor;
    private final double fillRatio, innerRatio;

    public RoundHighLightEffect(Color innerColor, Color outerColor, double fillRatio, double innerRatio) {
        this.innerColor = innerColor;
        this.outerColor = outerColor;
        this.fillRatio = fillRatio;
        this.innerRatio = innerRatio;
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        int size = (int) (Math.min(c.getWidth(), c.getHeight()) * fillRatio);

        g2.setColor(outerColor);
        g2.fillOval((c.getWidth() - size) / 2, (c.getHeight() - size) / 2, size, size);

        size *= innerRatio;
        g2.setColor(innerColor);
        g2.fillOval((c.getWidth() - size) / 2, (c.getHeight() - size) / 2, size, size);
    }
}
