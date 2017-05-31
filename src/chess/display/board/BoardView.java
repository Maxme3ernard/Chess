package chess.display.board;

import chess.display.Skin;
import chess.display.util.JComponentDecorator;
import chess.display.util.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by coni on 15/05/2017.
 */
public class BoardView extends JComponentDecorator<JPanel> {
    public BoardView(MoveDisplay moveDisplay, int width, int height, Skin skin) {
        super(new JPanel());
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        content.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 1;
        c.gridy = 0;
        createVerticalLabels().addTo(content, c);
        c.gridx = 1;
        c.gridy = 2;
        createVerticalLabels().addTo(content, c);

        c.gridx = 0;
        c.gridy = 1;
        createHorizontalLabels().addTo(content, c);
        c.gridx = 2;
        c.gridy = 1;
        createHorizontalLabels().addTo(content, c);

        c.gridx = 1;
        c.gridy = 1;
        JPanel tiles = createTiles(moveDisplay, width, height, skin);
        content.add(tiles, c);

        content.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension d = e.getComponent().getSize();
                int min = Math.min(d.width, d.height) - 42;
                tiles.setPreferredSize(new Dimension(min, min));
            }
        });
    }

    private JPanel createTiles(MoveDisplay moveDisplay, int width, int height, Skin skin) {
        JPanel tiles = new JPanel();
        tiles.setPreferredSize(new Dimension(width, height));
        tiles.setLayout(new SpringLayout());
        tiles.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel tile;
        for (int i = 0; i < 64; i++) {
            tile = new JPanel();
            int y = 7 - i / 8;
            int x = i % 8;
            if (i % 2 == i / 8 % 2)
                tiles.add(new JLayer<>(tile,
                    new TileUI(moveDisplay, x, y, skin.getTileBackgroundDark(),
                            skin.getTileHoverEffectDark(), skin.getTileSelectEffectDark(),
                            skin.getTileHighlightEffect(), skin.getPiecePaintSkin())));
            else
                tiles.add(new JLayer<>(tile,
                    new TileUI(moveDisplay, x, y, skin.getTileBackgroundLight(),
                            skin.getTileHoverEffectLight(), skin.getTileSelectEffectLight(),
                            skin.getTileHighlightEffect(), skin.getPiecePaintSkin())));
        }
        SpringUtilities.makeCompactGrid(tiles, 8, 8, 0,0,0,0);
        return tiles;
    }

    private LabelPanel createVerticalLabels(){
        char[] letters = new char[]{'a','b','c','d','e','f','g','h'};
        LabelPanel vertical = new LabelPanel(LabelPanel.X_AXIS);
        vertical.setSize(0,20);

        for (int i = 0; i < 8; i++) vertical.add(new JLabel(String.valueOf(letters[i])));

        return vertical;
    }
    private LabelPanel createHorizontalLabels(){
        LabelPanel horizontal = new LabelPanel(LabelPanel.Y_AXIS);
        horizontal.setSize(20,0);

        for (int i = 8; i >= 1; i--) horizontal.add(new JLabel(String.valueOf(i)));

        return horizontal;
    }
}
