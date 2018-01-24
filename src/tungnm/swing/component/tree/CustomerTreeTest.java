/**
 * Copyright(C) 2016 NMT
 *
 * Class CustomerTreeTest.java Aug 19, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.tree;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import tungnm.swing.component.scrollbar.CustomScrollPane;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class CustomerTreeTest {

    public static TreeModel makeModel() {
        Dimension d64 = new Dimension(64, 64);
        Dimension d32 = new Dimension(32, 32);
        Dimension d24 = new Dimension(24, 24);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode set1 = new DefaultMutableTreeNode(
                new CustomerTreeNode("SubCategory 1", Color.ORANGE, d64, false));
        set1.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubCategory 1", Color.ORANGE, d32, true)));
        set1.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubCategory 2", Color.CYAN.darker(), d32, true)));
        set1.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubCategory 3", Color.GREEN, d32, true)));
        DefaultMutableTreeNode set2 = new DefaultMutableTreeNode(
                new CustomerTreeNode("SubCategory 2", Color.GREEN.darker().darker(), d64, false));
        DefaultMutableTreeNode set3 = new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubCategory 5", Color.GREEN, d32, false));
        set3.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubSubCategory 1", Color.BLUE, d24, true)));
        set3.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubSubCategory 2", Color.GREEN, d24, true)));
        set3.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubSubCategory 3", Color.ORANGE.darker(), d24, true)));
        set2.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubCategory 4", Color.ORANGE.darker().darker(), d32, true)));
        set2.add(set3);
        set2.add(new DefaultMutableTreeNode(
                new CustomerTreeNode("SubSubCategory 6", Color.ORANGE, d32, true)));
        root.add(set1);
        root.add(set2);

        JPanel pContent = new JPanel();
        pContent.setBackground(new Color(202, 203, 54, 128));
        DefaultMutableTreeNode set4Content = new DefaultMutableTreeNode(pContent);
        pContent.setPreferredSize(new Dimension(310, 50));
        JPanel p = new JPanel();
        p.setBackground(new Color(102, 203, 54, 128));
        DefaultMutableTreeNode set4 = new DefaultMutableTreeNode(p);
        p.setPreferredSize(new Dimension(310, 50));
        set4.add(set4Content);
        root.add(set4);
        return new DefaultTreeModel(root);
    }

    public static void main(String... args) {
        EventQueue.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(laf.getName())) {
                        UIManager.setLookAndFeel(laf.getClassName());
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JFrame f = new JFrame("Customer Tree Test");
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.getContentPane().add(new CustomScrollPane(new CustomerTree(makeModel())));
            f.setSize(320, 300);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
