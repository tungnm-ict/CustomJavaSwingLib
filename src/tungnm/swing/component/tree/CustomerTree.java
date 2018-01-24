/**
 * Copyright(C) 2016 NMT
 *
 * Class CustomItemTreeTest.java Aug 19, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.tree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.Painter;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.IconUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class CustomerTree extends JTree {

    private Color selectedColorNode = Color.lightGray;
    private UIDefaults uIDefaults;

    public CustomerTree() {
        setUpTree();
    }

    public CustomerTree(TreeModel treeModel) {
        super(treeModel);
        setUpTree();
    }

    public void setLeftChildIndent(int indent) {
        uIDefaults.put("Tree.leftChildIndent", indent);
    }

    private void setUpTree() {
        IconUIResource emptyIcon = new IconUIResource(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
            }

            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        });
        UIManager.put("Tree.expandedIcon", emptyIcon);
        UIManager.put("Tree.collapsedIcon", emptyIcon);
        //UIManager.put("Tree.closedIcon",    emptyIcon);
        //UIManager.put("Tree.openIcon",      emptyIcon);
        UIManager.put("Tree.paintLines", Boolean.FALSE);

        uIDefaults = new UIDefaults();
        uIDefaults.put("Tree:TreeCell[Enabled+Selected].backgroundPainter", new Painter<JComponent>() {
            @Override
            public void paint(Graphics2D g, JComponent c, int w, int h) {
                g.setPaint(selectedColorNode);
                g.fillRect(0, 0, w, h);
            }
        });
        uIDefaults.put("Tree.leftChildIndent", -4);
        this.setCellRenderer(new CustomerTreeCellRenderer());
        //this.setRowHeight(0);
        this.setRootVisible(false);
        this.setShowsRootHandles(false);
        this.setBackground(Color.WHITE);
        this.putClientProperty("Nimbus.Overrides", uIDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}

class CustomerTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {

        JLabel labelDefault = (JLabel) super.getTreeCellRendererComponent(
                tree, value, selected, expanded, leaf, row, hasFocus);
        if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object uo = node.getUserObject();
            if (uo instanceof CustomerTreeNode) {
                CustomerTreeNode i = (CustomerTreeNode) uo;
                labelDefault.setForeground(Color.BLACK);
                labelDefault.setIcon(new CustomerTreeNode(i.title, i.color, i.dim, leaf, expanded));

                int indent = 0;
                TreeNode parent = node.getParent();
                while (parent instanceof DefaultMutableTreeNode) {
                    DefaultMutableTreeNode pn = (DefaultMutableTreeNode) parent;
                    if (pn.getUserObject() instanceof CustomerTreeNode) {
                        CustomerTreeNode pi = (CustomerTreeNode) pn.getUserObject();
                        indent += pi.intend / 2;
                    }
                    parent = pn.getParent();
                }
                labelDefault.setBorder(BorderFactory.createEmptyBorder(2, indent, 2, 5));
                return labelDefault;
            } else if (uo instanceof JComponent) {
                JComponent component = (JComponent) uo;
                return component;
            }

        }
        return labelDefault;
    }
}

class CustomerTreeNode implements Icon {

    public final String title;
    public final Color color;
    public final Dimension dim;
    public int intend;
    private final boolean expanded;
    private final boolean leaf;
    private static int GAP = 4;
    //public TestNode(String title, ImageIcon img, Dimension dim) {

    public CustomerTreeNode(String title, Color color, Dimension dim, boolean leaf) {
        this(title, color, dim, leaf, false);
    }
    public CustomerTreeNode(String title, Color color, Dimension dim, boolean leaf, int intend) {
        this(title, color, dim, leaf, false,intend);
    }

    public CustomerTreeNode(String title, Color color, Dimension dim,
            boolean leaf, boolean expanded) {
        this(title, color, dim, leaf, expanded,30);
    }

    public CustomerTreeNode(String title, Color color, Dimension dim,
            boolean leaf, boolean expanded, int intend) {
        this.title = title;
        this.color = color;
        this.dim = dim;
        this.expanded = expanded;
        this.leaf = leaf;
        this.intend = intend;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x + GAP, y + GAP, dim.width - GAP - GAP, dim.height - GAP - GAP);
        if (dim.width < 64) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int w6 = dim.width / 12;
            int w3 = dim.width / 6;
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(w6));
            Point pt = new Point(x + dim.width / 2, y + dim.height / 2);
            Path2D path = new Path2D.Double();
            path.moveTo(pt.x - w6, pt.y - w3);
            path.lineTo(pt.x + w6, pt.y);
            path.lineTo(pt.x - w6, pt.y + w3);
            int numquadrants;
            if (leaf) {
                numquadrants = 0;
            } else if (expanded) {
                numquadrants = 3;
            } else {
                numquadrants = 1;
            }
            AffineTransform at = AffineTransform.getQuadrantRotateInstance(
                    numquadrants, pt.x, pt.y);
            g2.draw(at.createTransformedShape(path));
            g2.dispose();
        }
    }

    @Override
    public int getIconWidth() {
        return dim.width;
    }

    @Override
    public int getIconHeight() {
        return dim.height;
    }

    @Override
    public String toString() {
        return title;
    }
}
