package chess.display;

import chess.Plateau;
import chess.display.board.BoardView;
import chess.display.board.MoveDisplay;
import chess.display.board.PiecePaintSkin;
import chess.display.paint.*;
import chess.display.timer.TimerView;
import chess.time.TimeCounter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by coni on 09/05/2017.
 */
public class GameWindow {
    private final JPanel container = new JPanel();

    public GameWindow() {
        //container.setBackground(Color.red);
        container.setOpaque(false);
        container.setLayout(new BorderLayout());
    }

    public void createGame(){
        Plateau plateau = new Plateau();
        plateau.init();

        PaintSkin tileBackgroundLight = new ColorPaintSkin(new Color(129, 122, 84));
        PaintSkin tileBackgroundDark = new ColorPaintSkin(new Color(85,71,48));
        PaintSkin tileHoverEffectLight = new HoverEffect(.45f, 1f, new Color(0, 46, 93), .95f);
        PaintSkin tileHoverEffectDark = new HoverEffect(.45f, 1f, new Color(0, 102,255,150), .45f);
        PaintSkin tileSelectEffectLight = new HoverEffect(.45f, 1f, new Color(23, 93, 36), 0.95f);
        PaintSkin tileSelectEffectDark = new HoverEffect(.45f, 1f, new Color(43,255, 74,150), 0.45f);
        PaintSkin tileHighlightEffect = new RoundHighLightEffect(Color.WHITE, Color.GREEN, 0.3,0.8);
        PiecePaintSkin piecePaintSkin = new PiecePaintSkin(plateau);

        BufferedImage white = null;
        BufferedImage black = null;
        try {
            white = ImageIO.read(new File("resources/white_pawn.png"));
            black = ImageIO.read(new File("resources/black_pawn.png"));
        } catch (IOException e) {
            System.exit(42);
            e.printStackTrace();
        }

        PaintSkin piecesSkin[] = new PaintSkin[12];
        for (int i = 0; i < 6; i++) piecesSkin[i] = new ImagePaintSkin(white, 0.8);
        for (int i = 6; i < 12; i++) piecesSkin[i] = new ImagePaintSkin(black, 0.8);

        Skin skin = new Skin(tileBackgroundLight, tileBackgroundDark, tileHoverEffectLight, tileHoverEffectDark, tileSelectEffectLight, tileSelectEffectDark, tileHighlightEffect, piecePaintSkin, piecesSkin);
        piecePaintSkin.setSkin(skin);

        BoardView boardView = new BoardView(new MoveDisplay(plateau, container::repaint),500,500, skin);
      //  boardView.addTo(container, BorderLayout.CENTER);

        TimeCounter timeCounter = new TimeCounter(200);
        Timer timer = new Timer(1000, timeCounter);

        TimerView timerView = new TimerView();
        timeCounter.addObserver(timerView);
        timerView.addTo(container, BorderLayout.CENTER);

        timer.start();
    }

    public void addTo(JComponent component, Object constraints){
        component.add(container, constraints);
    }

    private static void launchTest(){
        JFrame frame = new JFrame("Chess");
        //frame.setMinimumSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(129, 112, 84));

        GameWindow gameWindow = new GameWindow();
        gameWindow.createGame();
        gameWindow.addTo(mainPanel, null);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameWindow::launchTest);
    }
}
