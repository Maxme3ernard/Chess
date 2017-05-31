package chess.display.timer;

import chess.display.Skin;
import chess.display.paint.TransformPaintSkin;
import chess.time.Time;
import chess.display.util.JComponentDecorator;
import chess.display.paint.PaintSkinPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by coni on 28/05/2017.
 */
public class TimerView extends JComponentDecorator<JPanel> implements Observer{
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    private static final Date ZERO;
    private final JTextField whiteTime;
    private final JTextField blackTime;

    public TimerView(Skin skin) {
        super(new JPanel());
        content.setOpaque(false);
        content.setPreferredSize(new Dimension(300, 200));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        PaintSkinPanel white = new PaintSkinPanel(
                new TransformPaintSkin(skin.getPiecePaint(0), -.2, .25, .8, .8),
                new TransformPaintSkin(skin.getWhiteName(), .35,.5,.5,.4));
        white.setOpaque(false);
        content.add(white);

        String s = "00:00:00";
        Font font = new Font("Mistral", Font.BOLD, 20);
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
        Rectangle2D rect = font.getStringBounds(s, frc);
        Dimension d = new Dimension((int) rect.getWidth() + 10, (int) rect.getHeight());

        whiteTime = new JTextField("00:00:00");
        whiteTime.setEditable(false);
        whiteTime.setOpaque(false);
        whiteTime.setBorder(null);
        whiteTime.setFont(font);
        whiteTime.setHorizontalAlignment(SwingConstants.CENTER);
        whiteTime.setMinimumSize(d);
        whiteTime.setMaximumSize(d);
        content.add(whiteTime);

        PaintSkinPanel black = new PaintSkinPanel(
                new TransformPaintSkin(skin.getPiecePaint(0), -.2, .25, .8, .80),
                new TransformPaintSkin(skin.getWhiteName(), .35,.5,.5,.4));
        black.setOpaque(false);
        content.add(black);

        blackTime = new JTextField("00:00:00");
        blackTime.setEditable(false);
        blackTime.setOpaque(false);
        blackTime.setBorder(null);
        blackTime.setFont(font);
        blackTime.setHorizontalAlignment(SwingConstants.CENTER);
        blackTime.setMinimumSize(d);
        blackTime.setMaximumSize(d);
        content.add(blackTime);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (!(arg instanceof Time)) return;
        Time time = (Time) arg;
        if (time.isWhitePlayer()) updateTime(whiteTime, time.getTime());
        else updateTime(blackTime, time.getTime());
    }

    private void updateTime(JTextField field, int time){
        field.setText(DATE_FORMAT.format(new Date(ZERO.getTime() + time * 1000)));
        field.repaint();
    }

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        ZERO = calendar.getTime();
    }
}
