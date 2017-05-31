package chess.display.menu;

import chess.display.util.JComponentDecorator;
import chess.display.Skin;
import chess.display.paint.PaintSkinPanel;
import chess.display.util.HeadedPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

/**
 * Created by coni on 31/05/2017.
 */
public class MenuView extends JComponentDecorator<JPanel> {

    public MenuView(Skin skin){
        super(new JPanel());
        this.content.setPreferredSize(new Dimension(100,100));
        this.content.setLayout(new BorderLayout(0,0));
        this.content.setOpaque(false);

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new FlowLayout(FlowLayout.LEFT, 2,0));

        header.add(Box.createHorizontalStrut(8));

        PaintSkinPanel icon = new PaintSkinPanel(skin.getPiecePaint(2));
        icon.setOpaque(false);
        header.add(icon);

        JTextField title = new JTextField("TITLE");
        title.setOpaque(false);
        title.setBorder(null);
        title.setEditable(false);
        title.setFont(new Font("Mistral", Font.PLAIN, 20));
        header.add(title);

        Dimension t = title.getPreferredSize();
        //noinspection SuspiciousNameCombination
        icon.setPreferredSize(new Dimension(t.height, t.height));

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setBorder(BorderFactory.createLineBorder(Color.black));
        content.setLayout(new GridBagLayout());

        JPanel rightContent = new JPanel();
        rightContent.setOpaque(false);
        rightContent.setLayout(new BoxLayout(rightContent, BoxLayout.Y_AXIS));

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridx = 1;
        content.add(Box.createHorizontalStrut(5), c);
        c.gridx = 0;
        c.weightx = 1;
        content.add(rightContent, c);

        addButton(rightContent);
        addButton(rightContent);
        addButton(rightContent);

        HeadedPanel headedPanel = new HeadedPanel(header, content);
        headedPanel.addTo(this.content);
    }

    private void addButton(JComponent container){
        Font font = new Font("Mistral", Font.PLAIN, 20);

        JButton button = new JButton("EXIT");
        button.setFont(font);
        Color def = Color.GRAY.darker();
        Color hover = Color.GRAY.darker().darker();
        Color pressed = new Color(78, 98, 130);
        button.setForeground(def);

        button.setUI(new BasicButtonUI(){
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {}
        });
        button.addChangeListener(e -> {
            if (button.getModel().isPressed()) button.setForeground(pressed);
            else button.setForeground(def);
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(def);
            }
        });
        button.setOpaque(false);
        button.setBorder(null);
        button.setBackground(new Color(0,0,0,0));
        button.setMaximumSize(button.getPreferredSize());
        button.setHorizontalAlignment(JTextField.RIGHT);
        button.setAlignmentX(Component.RIGHT_ALIGNMENT);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        container.add(button);
    }
}
