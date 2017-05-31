package chess.display.paint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by coni on 28/05/2017.
 */
public class PaintSkinPanel extends JPanel {
    private final PaintSkin[] paintSkins;

    public PaintSkinPanel(PaintSkin... paintSkins) {
        this.paintSkins = paintSkins;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paint(g2);
        for (PaintSkin paintSkin : paintSkins) paintSkin.paint(g2, this);
        g2.dispose();
    }
}
