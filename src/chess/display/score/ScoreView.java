package chess.display.score;

import chess.Plateau;
import chess.display.util.JComponentDecorator;
import chess.display.Skin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by coni on 31/05/2017.
 */
public class ScoreView extends JComponentDecorator<JPanel> {
    private final CemeteryPanel cemetery;
    private final ScorePanel score;

    public ScoreView(Skin skin, Plateau plateau) {
        super(new JPanel());
        content.setOpaque(false);

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new BorderLayout());
        //header.setPreferredSize(new Dimension(100,50));

        score = new ScorePanel(skin, plateau);
        score.addTo(header);

        JPanel body = new JPanel();
        body.setBorder(BorderFactory.createLineBorder(Color.black));
        body.setOpaque(false);
        body.setLayout(new GridBagLayout());
        body.setPreferredSize(new Dimension(800,80));

        cemetery = new CemeteryPanel(skin);
        cemetery.addTo(body);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(header);
        content.add(Box.createVerticalStrut(2));
        content.add(body);
    }

    public void addWhitePiece(int pieceTypeId){
        cemetery.addWhitePiece(pieceTypeId);
        score.updateWhiteScore();
    }
    public void addBlackPiece(int pieceTypeId){
        cemetery.addBlackPiece(pieceTypeId);
        score.updateBlackScore();
    }
}
