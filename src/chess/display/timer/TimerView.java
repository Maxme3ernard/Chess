package chess.display.timer;

import chess.display.paint.OvalGradientPaintSkin;
import chess.time.Time;
import chess.display.JComponentDecorator;
import chess.display.paint.ColorPaintSkin;
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

    public TimerView() {
        super(new JPanel());
        content.setOpaque(false);
        content.setPreferredSize(new Dimension(300,300));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        PaintSkinPanel white = new PaintSkinPanel(new OvalGradientPaintSkin(Color.BLUE, 0.5f, .8, .6));
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

        PaintSkinPanel black = new PaintSkinPanel(new ColorPaintSkin(Color.black));
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
