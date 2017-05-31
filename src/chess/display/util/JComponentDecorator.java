package chess.display.util;

import javax.swing.*;

/**
 * Created by coni on 28/05/2017.
 */
public class JComponentDecorator<T extends JComponent> {
    protected final T content;

    protected JComponentDecorator(T content) {
        this.content = content;
    }

    public void addTo(JComponent container, Object constraints){
        container.add(content, constraints);
        container.revalidate();
        container.repaint();
    }

    public void addTo(JComponent container){
        addTo(container, null);
    }
}
