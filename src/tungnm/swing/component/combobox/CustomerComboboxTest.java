/**
 * Copyright(C) 2016 NMT
 *
 * Class CustomComboboxTest.java Aug 22, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.combobox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class CustomerComboboxTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("RoundedComboBox");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(300, 70));

        CustomerCombobox<String> c = new CustomerCombobox();
        c.setPreferredSize(new Dimension(200, 30));
        c.setFont(new Font("Tahoma", Font.BOLD, 12));

//        Color color = new Color(102, 204, 53);
        Color color = new Color(255, 153, 0);
        c.setForeground(color);
//        c.setBackground(new Color(230, 230, 230));
        c.setBorderColor(color);
        c.updateCombobox();
        c.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println(c.getSelectedItem());
                }
            }
        });
        for (int i = 0; i < 20; i++) {
            c.addElement("Nguyen Manh TUng" + i);
        }
        p.add(c);
        frame.getContentPane().add(p);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
