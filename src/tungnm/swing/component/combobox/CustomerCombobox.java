/**
 * Copyright(C) 2016 NMT
 *
 * Class CustomCombobox.java Aug 22, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.combobox;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import tungnm.swing.component.scrollbar.CustomScrollBarUI;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 * @param <E>
 */
public class CustomerCombobox<E> extends JComboBox<E> {

    private DefaultComboBoxModel<E> defaultComboBoxModel;
    private Color foreground = Color.BLACK;
    private Color background = Color.WHITE;
//    private Color selectionForeground = Color.BLUE;
//    private Color selectionBackground = Color.WHITE;
    private MyComboBoxUI myComboBoxUI;
    private Color borderColor = Color.BLACK;
    private int strock = 1;
    private RoundedCornerBorder roundedCornerBorder;
    private boolean usingDefaultComboBoxModel = false;

    private ComboBoxCellRender cellRender;

    public CustomerCombobox() {
        super();
        setupCombobox();
    }

    public CustomerCombobox(Color foreground, Color background) {
        super();
        this.background = background;
//        this.selectionBackground = selectionBackground;
//        this.selectionForeground = selectionForeground;
        setupCombobox();
    }

    public CustomerCombobox(DefaultComboBoxModel comboBoxModel) {
        super(comboBoxModel);
        usingDefaultComboBoxModel = true;
        setupCombobox();
    }

    public CustomerCombobox(E[] items) {
        super(items);
        setupCombobox();
    }

    public CustomerCombobox(Vector<E> items) {
        super(items);
        setupCombobox();
    }

    public int getCellHeight() {
        return cellRender.getCellHeight();
    }

    public void setCellHeight(int cellHeight) {
        this.cellRender.setCellHeight(cellHeight);
    }

    private void setupCombobox() {
        cellRender = new ComboBoxCellRender();
        this.setRenderer(cellRender);
        cellRender.setCellHeight(25);
        defaultComboBoxModel = (DefaultComboBoxModel<E>) this.getModel();
        UIManager.put("ComboBox.foreground", foreground);
        UIManager.put("ComboBox.background", background);
        UIManager.put("ComboBox.selectionForeground", background);
        UIManager.put("ComboBox.selectionBackground", foreground);

        UIManager.put("ComboBox.buttonDarkShadow", background);
        UIManager.put("ComboBox.buttonBackground", foreground);
        UIManager.put("ComboBox.buttonHighlight", foreground);
        UIManager.put("ComboBox.buttonShadow", foreground);
        myComboBoxUI = new MyComboBoxUI(borderColor, borderColor.darker());
        myComboBoxUI.setBackground(background);
        myComboBoxUI.setForeground(foreground);
        myComboBoxUI.setBorderColor(borderColor);
        myComboBoxUI.setStrock(strock);

        roundedCornerBorder = new RoundedCornerBorder(borderColor, strock);
        this.setBorder(roundedCornerBorder);
        this.setOpaque(false);
        setUI(myComboBoxUI);
    }

    public void updateCombobox() {
        setUI(myComboBoxUI);
    }

    public void addElement(E item) {
        defaultComboBoxModel.addElement(item);
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        roundedCornerBorder.setBorderColor(borderColor);
        myComboBoxUI.setColor(borderColor);
        myComboBoxUI.setRollover(borderColor.darker());
        myComboBoxUI.setBorderColor(borderColor);
    }

    public void setStrock(int strock) {
        this.strock = strock;
        roundedCornerBorder.setStrock(strock);
        myComboBoxUI.setStrock(strock);
    }

    @Override
    public void setForeground(Color foreground) {
        this.foreground = foreground;
        super.setForeground(foreground);
        if (myComboBoxUI != null) {
            myComboBoxUI.setForeground(foreground);
        }
        UIManager.put("ComboBox.foreground", foreground);
        UIManager.put("ComboBox.selectionBackground", foreground);
        repaint();
    }

    @Override
    public void setBackground(Color background) {
        this.background = background;
        super.setBackground(background);
        if (myComboBoxUI != null) {
            myComboBoxUI.setBackground(background);
        }
        UIManager.put("ComboBox.background", background);
        UIManager.put("ComboBox.selectionForeground", background);
        repaint();
    }

    class TriangleShape extends Path2D.Double {

        public TriangleShape(Point2D... points) {
            moveTo(points[0].getX(), points[0].getY());
            lineTo(points[1].getX(), points[1].getY());
            lineTo(points[2].getX(), points[2].getY());
            closePath();
        }
    }

    class ArrowIcon implements Icon {

        private Color color, rollover;

        protected ArrowIcon(Color color, Color rollover) {
            this.color = color;
            this.rollover = rollover;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void setRollover(Color rollover) {
            this.rollover = rollover;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(color);
            int shift = 0;
            if (c instanceof AbstractButton) {
                ButtonModel m = ((AbstractButton) c).getModel();
                if (m.isPressed()) {
                    shift = 1;
                } else if (m.isRollover()) {
                    g2.setPaint(rollover);
                }
            }
            g2.translate(x, y + shift);
//            g2.drawLine(2, 13, 6, 3);
//            g2.drawLine(3, 4, 5, 4);
//            g2.drawLine(4, 5, 4, 5);
            TriangleShape triangleShape = new TriangleShape(
                    new Point2D.Double(0, 0),
                    new Point2D.Double(8, 0),
                    new Point2D.Double(4, 7)
            );

            g2.fill(triangleShape);

            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return 9;
        }

        @Override
        public int getIconHeight() {
            return 9;
        }
    }

    class RoundedCornerBorder extends AbstractBorder {

        private Color borderColor = Color.BLACK;
        private int strock = 2;

        public RoundedCornerBorder() {
        }

        public RoundedCornerBorder(Color borderColor, int strock) {
            this.borderColor = borderColor;
            this.strock = strock;
        }

        public void setBorderColor(Color borderColor) {
            this.borderColor = borderColor;
        }

        public void setStrock(int strock) {
            this.strock = strock;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(strock));
            int r = 15;
            int w = width - 1;
            int h = height - 1;

//        g2.setPaint(c.getBackground());
            RoundRectangle2D round = new RoundRectangle2D.Double(x, y, w, h, r, r);

            Container parent = c.getParent();
//            if (Objects.nonNull(parent)) {
//                g2.setPaint(parent.getBackground());
//                Area corner = new Area(new RoundRectangle2D.Double(x, y, width, height, r, r));
//                corner.subtract(round);
//                g2.fill(corner);
//            }
            g2.setPaint(borderColor);
            g2.draw(round);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(4, 8, 4, 8);
            return insets;
        }
    }

    class MyComboBoxUI extends BasicComboBoxUI {

        private Color color = Color.BLACK;
        private Color rollover = Color.BLUE;
        private Color background = Color.LIGHT_GRAY;
        private Color foreground = Color.BLACK;
        private Color borderColor = Color.BLACK;
        private int strock = 3;

        public MyComboBoxUI(Color color, Color rollover) {
            super();
            this.color = color;
            this.rollover = rollover;
        }

        public MyComboBoxUI() {
        }

        public void setBackground(Color background) {
            this.background = background;
        }

        public void setForeground(Color foreground) {
            this.foreground = foreground;
        }

        public void setBorderColor(Color borderColor) {
            this.borderColor = borderColor;
        }

        public void setStrock(int strock) {
            this.strock = strock;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void setRollover(Color rollover) {
            this.rollover = rollover;
        }

        @Override
        protected JButton createArrowButton() {
//            JButton button = new BasicArrowButton(BasicArrowButton.EAST);
            JButton button = new JButton(new ArrowIcon(color, rollover));
            button.setPreferredSize(new Dimension(10, 10));
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder());
            return button;
        }

        @Override
        protected ComboPopup createPopup() {
            BasicComboPopup popup = new BasicComboPopup(comboBox) {
                protected JScrollPane createScroller() {
                    JScrollPane jScrollPane = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    jScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
                    return jScrollPane;
                }
            };
            return popup;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            int width = c.getWidth();
            int height = c.getHeight();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(strock));
            g2.setPaint(background);
            int r = 15;
            int w = width - 1;
            int h = height - 1;
            Area round = new Area(new RoundRectangle2D.Double(0, 0, w, h, r, r));
            g2.fill(round);
//            g2.setPaint(borderColor);
//            g2.draw(round);
            //-----------------------------------------
            g2.setPaint(foreground);
            JComboBox j = (JComboBox) c;
            Object selectedItem = j.getSelectedItem();
            int size = j.getFont().getSize();
            g2.drawString(selectedItem.toString(), 10, (height + size) / 2);

            g2.dispose();
        }

    }

    class ComboBoxCellRender extends JLabel implements ListCellRenderer {

        protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        private int cellHeight = 0;

        public int getCellHeight() {
            return cellHeight;
        }

        public void setCellHeight(int cellHeight) {
            this.cellHeight = cellHeight;
        }

        @Override
        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (cellHeight > 0) {
                renderer.setPreferredSize(new Dimension(renderer.getWidth(), cellHeight));
            }
            renderer.setText(String.valueOf(value));
            return renderer;
        }
    }
}
