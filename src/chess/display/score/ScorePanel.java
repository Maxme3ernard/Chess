package chess.display.score;

import chess.Plateau;
import chess.display.util.JComponentDecorator;
import chess.display.Skin;
import chess.display.paint.PaintSkin;
import chess.display.paint.PaintSkinPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by coni on 31/05/2017.
 */
public class ScorePanel extends JComponentDecorator<JPanel> {
    private final Plateau plateau;
    private final JTextField whiteScore;
    private final JTextField blackScore;

    public ScorePanel(Skin skin, Plateau plateau){
        super(new JPanel());
        this.plateau = plateau;
        content.setLayout(new GridLayout(1,2, 0,0));
        content.setOpaque(false);

        JPanel white = new JPanel();
        whiteScore = new JTextField("SCORE");
        setupPanel(white, skin.getWhiteName(), whiteScore, BorderLayout.WEST, BorderLayout.EAST);
        content.add(white);

        JPanel black = new JPanel();
        blackScore = new JTextField("SCORE");
        setupPanel(black, skin.getWhiteName(), blackScore, BorderLayout.EAST, BorderLayout.WEST);
        content.add(black);
    }

    public void updateWhiteScore(){
        updateScore(whiteScore, true);
    }
    public void updateBlackScore(){
        updateScore(blackScore, false);
    }

    private void updateScore(JTextField field, boolean isWhite){
        double score = plateau.score(isWhite);
        field.setText(String.valueOf(score));
    }

    private void setupPanel(JPanel container, PaintSkin namePaintSkin, JTextField score, String nameCons, String scoreCons){
        FlowLayout layout = (FlowLayout) container.getLayout();
        layout.setVgap(0);
        container.setOpaque(false);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());

        PaintSkinPanel name = new PaintSkinPanel(namePaintSkin);
        name.setOpaque(false);
        panel.add(name, nameCons);

        score.setBorder(null);
        score.setOpaque(false);
        score.setEditable(false);
        score.setFont(new Font("Mistral", Font.BOLD, 20));
        panel.add(score, scoreCons);

        container.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension c = e.getComponent().getSize();
                Dimension d = new Dimension((int) (c.width / 1.5), (int) panel.getPreferredSize().getHeight());
                panel.setSize(d);
                panel.setPreferredSize(d);

                Dimension n = new Dimension((int) (d.width / 3.5), d.height);
                name.setSize(n);
                name.setPreferredSize(n);

                panel.revalidate();
                panel.repaint();
            }
        });
        container.add(panel);
    }
}
