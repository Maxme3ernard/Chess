package chess.display.board;

import chess.display.board.MoveDisplay;
import chess.display.paint.PaintSkin;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by coni on 15/05/2017.
 */
public class TileUI extends LayerUI<JPanel> {
    private final MoveDisplay moveDisplay;
    private final int x,y;
    private final PaintSkin background;
    private final PaintSkin hoverSkin, selectedSkin, highlightedSkin;
    private final PaintSkin pieceSkin;
    private boolean hover, selected;

    public TileUI(MoveDisplay moveDisplay, int x, int y, PaintSkin background, PaintSkin hoverSkin, PaintSkin selectedSkin, PaintSkin highlightedSkin, PaintSkin pieceSkin) {
        this.moveDisplay = moveDisplay;
        this.x = x;
        this.y = y;
        this.background = background;
        this.hoverSkin = hoverSkin;
        this.selectedSkin = selectedSkin;
        this.highlightedSkin = highlightedSkin;
        this.pieceSkin = pieceSkin;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D)g;

        super.paint(g2, c);

        background.paint(g2, c);
        if (hover) hoverSkin.paint(g2, c);
        if (selected) selectedSkin.paint(g2, c);
        if (moveDisplay.isHighlighted(x, y)) highlightedSkin.paint(g2, c);
        pieceSkin.paint(g2, c);

        g2.dispose();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JLayer jLayer = (JLayer) c;
        jLayer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
    }

    @Override
    public void uninstallUI(JComponent c) {
        JLayer jLayer = (JLayer) c;
        jLayer.setLayerEventMask(0);
        super.uninstallUI(c);
    }

    @Override
    protected void processMouseEvent(MouseEvent e, JLayer l) {
        if (e.getID() == MouseEvent.MOUSE_ENTERED) hover = true;
        else if (e.getID() == MouseEvent.MOUSE_EXITED) hover = false;
        else if (e.getID() == MouseEvent.MOUSE_CLICKED) moveDisplay.click(this);
        l.repaint();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void select(){
        selected = true;
    }
    public void deselect(){
        selected = false;
    }
}
