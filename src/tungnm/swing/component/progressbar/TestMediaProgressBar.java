/**
 * Copyright(C) 2016 NMT
 *
 * Class TestMediaProgressBar.java Aug 19, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.progressbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class TestMediaProgressBar {

    public static void main(String[] args) {
        new TestMediaProgressBar();
    }

    public TestMediaProgressBar() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing Media Progress Bar");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private MediaProgressBar pb;
        private int value = 0;
        private int delta = 5;

        public TestPane() {
//            setBackground(Color.BLACK);
            setLayout(new GridBagLayout());
            pb = new MediaProgressBar(4,new Color(102, 203, 54).darker(),new Color(102, 203, 54),MediaProgressBar.ProgressBackgroudType.LINEFIT);
            pb.setPreferredSize(new Dimension(200, 20));
            add(pb);

            Timer timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (value + delta > 100) {
                        value = 0;
                    }
                    value += delta;
                    pb.setValue(value);
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }
    }

}
