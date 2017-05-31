package chess.display.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by coni on 31/05/2017.
 */
public class HeadedPanel extends JComponentDecorator<JPanel> {
    public HeadedPanel(JComponent header, JComponent content){
        super(new JPanel());
        this.content.setLayout(null);
        this.content.setOpaque(false);
        this.content.add(header);
        this.content.add(content);

        this.content.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension d = e.getComponent().getSize();
                Dimension h = new Dimension(d.width, header.getPreferredSize().height);
                Dimension c = new Dimension(d.width, d.height - h.height / 2);

                header.setLocation(0,0);
                header.setSize(h);
                header.setPreferredSize(h);

                content.setLocation(0, h.height / 2);
                content.setSize(c);
                content.setPreferredSize(c);

                HeadedPanel.this.content.revalidate();
                HeadedPanel.this.content.repaint();
            }
        });
    }
}
