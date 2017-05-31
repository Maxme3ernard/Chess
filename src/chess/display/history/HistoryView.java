package chess.display.history;

import chess.display.util.JComponentDecorator;
import chess.display.Skin;
import chess.display.paint.PaintSkinPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by coni on 30/05/2017.
 */
public class HistoryView extends JComponentDecorator<JPanel> {
    private static final char[] CHARACTERS = new char[]{'A','B','C','D','E','F','G','H','1','2','3','4','5','6','7','8'};
    private final Skin skin;
    private final JPanel history;

    public HistoryView(Skin skin) {
        super(new JPanel());
        this.skin = skin;

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setPreferredSize(new Dimension(100,400));
        content.setBorder(BorderFactory.createLineBorder(Color.black));
        content.setOpaque(false);

        history = new JPanel();
        history.setOpaque(false);
        history.setLayout(new BoxLayout(history, BoxLayout.PAGE_AXIS));

        JScrollPane scrollPane = new JScrollPane(history);
        scrollPane.setMinimumSize(new Dimension(100,200));
        scrollPane.setPreferredSize(new Dimension(100, 300));
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setOpaque(false);

        ScrollPaneUI scrollPaneUI = new ScrollPaneUI();
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(scrollPaneUI));
        JLayer<JScrollPane> scrollPaneLayer = new JLayer<>(scrollPane, scrollPaneUI);

        content.add(Box.createVerticalGlue());
        content.add(scrollPaneLayer);
        content.add(Box.createVerticalGlue());

        addMove(0, 0,2,0,0);
        addMove(1, 3,0,5,5);
    }

    public void addMove(int pieceTypeId, int fx, int fy, int tx, int ty){
        JPanel element = new JPanel();
        element.setOpaque(false);
        element.setLayout(new BoxLayout(element, BoxLayout.X_AXIS));

        PaintSkinPanel icon = new PaintSkinPanel(skin.getPiecePaint(pieceTypeId));
        icon.setOpaque(false);
        element.add(icon);

        element.add(Box.createHorizontalStrut(2));

        JTextField move = new JTextField(
                new String(new char[]{' ', CHARACTERS[fx], CHARACTERS[8 + fy], ' ', CHARACTERS[tx], CHARACTERS[8 + ty]}));
        move.setOpaque(false);
        move.setEditable(false);
        move.setBorder(null);
        element.add(move);

        Dimension f = element.getPreferredSize();
        element.setMinimumSize(f);
        element.setMaximumSize(f);
        element.setSize(f);
        history.add(element);
        history.add(Box.createVerticalStrut(5));
    }
}
