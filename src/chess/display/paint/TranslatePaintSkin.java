package chess.display.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by coni on 29/05/2017.
 */
public class TranslatePaintSkin implements PaintSkin {
    private final PaintSkin paintSkin;

    public TranslatePaintSkin(PaintSkin paintSkin) {
        this.paintSkin = paintSkin;
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        AffineTransform old = g2.getTransform();
        g2.setTransform(AffineTransform.getTranslateInstance(100, 10));
        paintSkin.paint(g2, c);
        g2.setTransform(old);
    }
}
