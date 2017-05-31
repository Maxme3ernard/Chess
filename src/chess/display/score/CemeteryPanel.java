package chess.display.score;

import chess.display.util.JComponentDecorator;
import chess.display.Skin;
import chess.display.paint.PaintSkinPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by coni on 31/05/2017.
 */
public class CemeteryPanel extends JComponentDecorator<JPanel> {
    private final Skin skin;
    private final JPanel white;
    private final JPanel black;

    public CemeteryPanel(Skin skin){
        super(new JPanel());
        this.skin = skin;
        content.setOpaque(false);
        content.setLayout(new GridLayout(1, 2));

        white = new JPanel();
        white.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 0));
        white.setOpaque(false);
        content.add(white);

        black = new JPanel();
        black.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 0));
        black.setOpaque(false);
        content.add(black);

        addResizeListener(white);
        addResizeListener(black);
    }

    @Override
    public void addTo(JComponent container, Object constraints) {
        super.addTo(container, constraints);
        container.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int pad = (int) (container.getHeight() * .1);
                Dimension d = new Dimension(container.getWidth() - pad, container.getHeight() - pad);
                content.setPreferredSize(d);
                content.setSize(d);
                content.revalidate();
                content.repaint();
            }
        });
    }

    public void addWhitePiece(int pieceTypeId){
        addPiece(white, pieceTypeId);
    }
    public void addBlackPiece(int pieceTypeId){
        addPiece(black, pieceTypeId);
    }

    private void addPiece(JPanel panel, int pieceTypeId){
        PaintSkinPanel piece = new PaintSkinPanel(skin.getPiecePaint(pieceTypeId));
        piece.setOpaque(false);
        piece.setPreferredSize(new Dimension(30,panel.getHeight()));
        panel.add(piece);
    }

    private void addResizeListener(JPanel panel){
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension c = e.getComponent().getSize();
                int w = (int) (c.getWidth() / 8) - 1;
                int h = (int) c.getHeight() / (panel.getComponentCount() <= 8 ? 1 : 2);
                Dimension d = new Dimension(w, h);
                for (Component component : panel.getComponents()) {
                    component.setPreferredSize(d);
                    component.setSize(d);
                }
                panel.revalidate();
                panel.repaint();
            }
        });
    }
}
