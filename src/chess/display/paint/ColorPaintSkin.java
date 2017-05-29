package chess.display.paint;

import chess.display.paint.PaintSkin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by coni on 27/05/2017.
 */
public class ColorPaintSkin implements PaintSkin {
    private final Color color;

    public ColorPaintSkin(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        g2.setColor(color);
        g2.fillRect(0,0,c.getWidth(), c.getHeight());
    }
}
