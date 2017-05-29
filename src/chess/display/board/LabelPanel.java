package chess.display.board;

import chess.display.JComponentDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by coni on 22/05/2017.
 */
public class LabelPanel extends JComponentDecorator<JPanel> {
    public static final int X_AXIS = 0;
    public static final int Y_AXIS = 1;
    private final int axis;
    private int max = 0;

    public LabelPanel(int axis) {
        super(new JPanel());
        this.axis = axis;
        content.setLayout(null);
        content.setOpaque(false);
        content.setBackground(new Color(0,0,0,0));
        content.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeAndMove();
            }
        });
    }

    public void setSize(int x, int y){
        if (axis == Y_AXIS){
            if (x > max) max = x;
        } else {
            if (y > max) max = y;
        }
        content.setPreferredSize(new Dimension(x, y));
    }

    public void add(JComponent toAdd){
        content.add(toAdd);
        if (axis == Y_AXIS){
            int width = (int) toAdd.getPreferredSize().getWidth();
            if (width > max) max = width;
            content.setPreferredSize(new Dimension(max, content.getHeight()));
        } else {
            int height = (int) toAdd.getPreferredSize().getHeight();
            if (height > max) max = height;
            content.setPreferredSize(new Dimension(content.getWidth(), max));
        }
        resizeAndMove();
    }

    private void resizeAndMove(){
        if (axis == Y_AXIS){
            double panelHeight = (double) content.getHeight();
            double w = (double) content.getWidth() / 2;
            Component[] components = content.getComponents();
            Component c;
            for (int i = 0; i < components.length; i++) {
                c = components[i];

                // Don't put outside loop to protect accuracy on rounding
                int x = (int) (w - ((double) c.getWidth()) / 2);
                double d = panelHeight * (i + .5) / content.getComponentCount();
                int y = (int) (d - ((double) c.getHeight()) / 2);

                c.setLocation(x, y);
                c.setSize(c.getPreferredSize());
            }
        } else {
            double panelWidth = (double) content.getWidth();
            double h = (double) content.getHeight() / 2;

            Component[] components = content.getComponents();
            Component c;
            for (int i = 0; i < components.length; i++) {
                c = components[i];

                // Don't put outside loop to protect accuracy on rounding
                int y = (int) (h - ((double) c.getHeight()) / 2);
                double d = panelWidth * (i + .5) / content.getComponentCount();
                int x = (int) (d - ((double) c.getWidth()) / 2);

                c.setLocation(x, y);
                c.setSize(c.getPreferredSize());
            }
        }
        content.revalidate();
        content.repaint();
    }
}
