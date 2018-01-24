/**
 * Copyright(C) 2016 NMT
 *
 * Class MyScrollBarUI.java Apr 21, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class CustomScrollBarUI extends BasicScrollBarUI {

    private final Dimension d = new Dimension();

    public CustomScrollBarUI() {
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = Color.GRAY;
        } else if (isThumbRollover()) {
            color = Color.GRAY;
        } else {
            color = Color.LIGHT_GRAY;
        }
        g2.setPaint(color);
        int orientation = sb.getOrientation();
        if (orientation == JScrollBar.VERTICAL) {
            System.out.println("VERTICAL"+r);
            g2.fillRoundRect(r.x + 3, r.y + 10, r.width - 6, r.height - 20, 10, 10);
        } else if (orientation == JScrollBar.HORIZONTAL) {
            System.out.println("HORIZONTAL"+r);
            g2.fillRoundRect(r.y, r.x, r.height, r.width, 10, 10);
        }
        g2.setPaint(Color.WHITE);
//    g2.drawRoundRect(r.x, r.y, r.width, r.height, 15, 15);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}
