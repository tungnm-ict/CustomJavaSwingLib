/**
 * Copyright(C) 2016 NMT
 *
 * Class MyScrollPane.java May 6, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.scrollbar;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class CustomScrollPane extends JScrollPane {

    public CustomScrollPane() {
        this.setAutoscrolls(true);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.getVerticalScrollBar().setUI(new CustomScrollBarUI());
    }

    public CustomScrollPane(Component view) {
        super(view);
        this.setAutoscrolls(true);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.getVerticalScrollBar().setUI(new CustomScrollBarUI());
    }

}
