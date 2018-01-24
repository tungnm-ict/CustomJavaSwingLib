/**
 * Copyright(C) 2016 NMT
 *
 * Class PanelDemo.java Jul 29, 2016 Nguyen Manh Tung
 */

package tungnm.swing.demo.panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import tungnm.swing.component.panel.GlossyCurvedPanel;
import tungnm.swing.component.panel.GradientPanel;
import tungnm.swing.component.panel.SimpleGlossyPanel;
import tungnm.swing.component.panel.StandardCurvedPanel;
import tungnm.swing.component.panel.StandardPanel;
import tungnm.swing.component.panel.TitlePanel;
import tungnm.swing.component.panel.Translucent;
import tungnm.swing.util.PanelType;
import tungnm.swing.util.ThemesList;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class PanelDemo {

	private CardLayout cardLayout = new CardLayout();
	private JPanel cardLayoutPanel = new JPanel();

	public PanelDemo() {
		cardLayoutPanel.setLayout(cardLayout);
		cardLayoutPanel.add("Standard", createStandardPanels());
		cardLayoutPanel.add("Gradient", createGradientPanels());
		cardLayoutPanel.add("Glossy", createGlossyPanels());
		cardLayoutPanel.add("Simple Glossy", createSimpleGlossyPanels());
		cardLayoutPanel.add("Titled", createTitledPanels());
		cardLayoutPanel.add("Translucent", createTranslucentPanel());

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e) {
			// TODO: handle exception
		}
		final PanelDemo pnlDemo = new PanelDemo();
		
		Vector<String> list = new Vector<String>();
		list.add("Standard");
		list.add("Gradient");
		list.add("Simple Glossy");
		list.add("Glossy");
		list.add("Titled");
		list.add("Translucent");
		final JList listPanel = new JList();
		listPanel.setListData(list);
		// listPanel.setOpaque(false);
		listPanel.setBackground(new Color(20, 20, 20));
		listPanel.setForeground(new Color(255, 255, 255));
		listPanel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent le) {
				pnlDemo.getCardLayout().show(pnlDemo.getCardLayoutPanel(),
						listPanel.getSelectedValue().toString());
			}

		});
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(listPanel);

		// PanelDemo demo = new PanelDemo();
		JFrame frame = new JFrame();
		frame.add(panel, BorderLayout.LINE_START);
		frame.add(pnlDemo.getCardLayoutPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 600);
		frame.setVisible(true);
	}

	public JTabbedPane createStandardPanels() {
		JTabbedPane pane = new JTabbedPane();
		JPanel outerPanel = new JPanel(new BorderLayout());
		JPanel rectMainPanel = new JPanel();
		JPanel roundRectMainPanel = new JPanel();

		List<Integer> themes = ThemesList.createStandardThemesList();
		for (Integer theme : themes) {
			StandardPanel rectPnl = new StandardPanel(theme);
			StandardPanel roundRectPnl = new StandardPanel(theme,
					PanelType.PANEL_CIRCULAR);

			rectPnl.setPreferredSize(new Dimension(200, 100));
			roundRectPnl.setPreferredSize(new Dimension(150, 150));
			rectMainPanel.add(rectPnl);
			roundRectMainPanel.add(roundRectPnl);
		}
		rectMainPanel.setPreferredSize(new Dimension(200, 1500));
		roundRectMainPanel.setPreferredSize(new Dimension(200, 1500));
		rectMainPanel.setBackground(new Color(255, 255, 255));
		roundRectMainPanel.setBackground(new Color(255, 255, 255));

		pane.add("Rectangular", new JScrollPane(rectMainPanel));
		pane.add("Rounded Rectangular", new JScrollPane(roundRectMainPanel));

		return pane;
	}

	public JTabbedPane createGradientPanels() {
		JTabbedPane pane = new JTabbedPane();
		JPanel rectMainPanel = new JPanel();
		JPanel roundRectMainPanel = new JPanel();

		List<Integer> themes = ThemesList.createGradientThemesList();
		for (Integer theme : themes) {
			GradientPanel rectPnl = new GradientPanel(theme);
			GradientPanel roundRectPnl = new GradientPanel(theme,
					PanelType.PANEL_CIRCULAR);

			rectPnl.setPreferredSize(new Dimension(200, 100));
			roundRectPnl.setPreferredSize(new Dimension(150, 150));
			rectMainPanel.add(rectPnl);
			roundRectMainPanel.add(roundRectPnl);
		}
		rectMainPanel.setPreferredSize(new Dimension(200, 1500));
		roundRectMainPanel.setPreferredSize(new Dimension(200, 1500));
		rectMainPanel.setBackground(new Color(0, 0, 0));
		roundRectMainPanel.setBackground(new Color(0, 0, 0));

		pane.add("Rectangular", new JScrollPane(rectMainPanel));
		pane.add("Rounded Rectangular", new JScrollPane(roundRectMainPanel));

		return pane;
	}

	public JTabbedPane createGlossyPanels() {
		JTabbedPane pane = new JTabbedPane();
		JPanel standardCPanel = new JPanel();
		JPanel golssyCPanel = new JPanel();

		JPanel mainPanel = new JPanel(new BorderLayout());
		List<Integer> themes = ThemesList.createThemesList();
		JPanel rootPanel = new JPanel();
		for (Integer theme : themes) {
			StandardCurvedPanel panel = new StandardCurvedPanel(theme);
			panel.setPreferredSize(new Dimension(250, 200));
			GlossyCurvedPanel gpanel = new GlossyCurvedPanel(theme);
			gpanel.setPreferredSize(new Dimension(250, 200));

			standardCPanel.add(panel);
			golssyCPanel.add(gpanel);
		}
		standardCPanel.setPreferredSize(new Dimension(200, 5000));
		golssyCPanel.setPreferredSize(new Dimension(200, 5000));

		// mainPanel.add(new JScrollPane(rootPanel));
		standardCPanel.setBackground(new Color(0, 0, 0));
		golssyCPanel.setBackground(new Color(0, 0, 0));
		pane.add("Standard Curved", new JScrollPane(standardCPanel));
		pane.add("Glossy Curved", new JScrollPane(golssyCPanel));

		return pane;
	}

	public JTabbedPane createSimpleGlossyPanels() {
		JTabbedPane pane = new JTabbedPane();
		JPanel rectMainPanel = new JPanel();
		JPanel roundRectMainPanel = new JPanel();

		List<Integer> themes = ThemesList.createThemesList();
		for (Integer theme : themes) {
			SimpleGlossyPanel rectPnl = new SimpleGlossyPanel(theme);
			SimpleGlossyPanel roundRectPnl = new SimpleGlossyPanel(theme,
					PanelType.PANEL_ROUNDED_RECTANGLUR);

			rectPnl.setPreferredSize(new Dimension(200, 100));
			roundRectPnl.setPreferredSize(new Dimension(200, 100));
			rectMainPanel.add(rectPnl);
			roundRectMainPanel.add(roundRectPnl);
		}
		rectMainPanel.setBackground(new Color(0, 0, 0));
		roundRectMainPanel.setBackground(new Color(0, 0, 0));
		rectMainPanel.setPreferredSize(new Dimension(200, 1600));
		roundRectMainPanel.setPreferredSize(new Dimension(200, 1600));

		pane.add("Rectangular", new JScrollPane(rectMainPanel));
		pane.add("Rounded Rectangular", new JScrollPane(roundRectMainPanel));

		return pane;
	}

	public JTabbedPane createTitledPanels() {
		JTabbedPane tabPane = new JTabbedPane();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel rectPanel = new JPanel();
		JPanel roundRectPanel = new JPanel();

		JPanel stdrectPanel = new JPanel();
		JPanel stdroundRectPanel = new JPanel();
		JPanel gradrectPanel = new JPanel();
		JPanel gradroundRectPanel = new JPanel();

		List<Integer> themes = ThemesList.createThemesList();
		for (Integer theme : themes) {
			JTree tree = new JTree();
			tree.setCellRenderer(new MyTreeCellRendrer());
			TitlePanel titlepanel = new TitlePanel("Glossy TitlePanel", theme,
					tree, PanelType.PANEL_RECTANGULAR,
					"resources/images/16_graph_multicolor.png");
			titlepanel.setPreferredSize(new Dimension(300, 180));
			rectPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			rectPanel.add(titlepanel);
			JTree tree2 = new JTree();
			tree2.setCellRenderer(new MyTreeCellRendrer());

			TitlePanel titlepanel2 = new TitlePanel("Glossy TitlePanel", theme,
					tree2, "resources/images/16_graph_multicolor.png");
			titlepanel2.setPreferredSize(new Dimension(300, 180));
			roundRectPanel.setBorder(BorderFactory
					.createEmptyBorder(5, 5, 5, 5));
			roundRectPanel.add(titlepanel2);
		}
		List<Integer> standardthemes = ThemesList.createStandardThemesList();
		for (Integer theme : standardthemes) {
			JTree tree = new JTree();
			tree.setCellRenderer(new MyTreeCellRendrer());

			TitlePanel titlepanel = new TitlePanel("Standard TitlePanel",
					theme, tree, PanelType.PANEL_RECTANGULAR,
					"resources/images/16_graph_multicolor.png");
			titlepanel.setPreferredSize(new Dimension(300, 180));
			stdrectPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			stdrectPanel.add(titlepanel);

			JTree tree2 = new JTree();
			tree2.setCellRenderer(new MyTreeCellRendrer());

			TitlePanel titlepanel2 = new TitlePanel("Standard TitlePanel",
					theme, tree2, "resources/images/16_graph_multicolor.png");
			titlepanel2.setPreferredSize(new Dimension(300, 180));
			stdroundRectPanel.setBorder(BorderFactory.createEmptyBorder(5, 5,
					5, 5));
			stdroundRectPanel.add(titlepanel2);
		}

		List<Integer> gradientThemes = ThemesList.createGradientThemesList();
		for (Integer theme : gradientThemes) {
			JTree tree = new JTree();
			tree.setCellRenderer(new MyTreeCellRendrer());

			TitlePanel titlepanel = new TitlePanel("Gradient TitlePanel",
					theme, tree, PanelType.PANEL_RECTANGULAR,
					"resources/images/16_graph_multicolor.png");
			titlepanel.setPreferredSize(new Dimension(300, 180));
			gradrectPanel
					.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			gradrectPanel.add(titlepanel);

			JTree tree2 = new JTree();
			tree2.setCellRenderer(new MyTreeCellRendrer());

			TitlePanel titlepanel2 = new TitlePanel("Gradient TitlePanel",
					theme, tree2, "resources/images/16_graph_multicolor.png");
			titlepanel2.setPreferredSize(new Dimension(300, 180));
			gradroundRectPanel.setBorder(BorderFactory.createEmptyBorder(5, 5,
					5, 5));
			gradroundRectPanel.add(titlepanel2);
		}

		stdrectPanel.setPreferredSize(new Dimension(300, 8000));
		JScrollPane pane3 = new JScrollPane(stdrectPanel);
		stdroundRectPanel.setPreferredSize(new Dimension(300, 8000));
		JScrollPane pane4 = new JScrollPane(stdroundRectPanel);
		stdrectPanel.setBackground(new Color(0, 0, 0));

		rectPanel.setPreferredSize(new Dimension(300, 8000));
		JScrollPane pane = new JScrollPane(rectPanel);
		roundRectPanel.setPreferredSize(new Dimension(300, 8000));
		JScrollPane pane2 = new JScrollPane(roundRectPanel);
		rectPanel.setBackground(new Color(0, 0, 0));

		gradrectPanel.setPreferredSize(new Dimension(300, 8000));
		JScrollPane pane5 = new JScrollPane(gradrectPanel);
		gradroundRectPanel.setPreferredSize(new Dimension(300, 8000));
		JScrollPane pane6 = new JScrollPane(gradroundRectPanel);
		gradrectPanel.setBackground(new Color(0, 0, 0));

		// roundRectPanel.setBackground(new Color(0, 0, 0));

		// mainPanel.add(pane);
		tabPane.add("Glossy Rectangular", pane);
		tabPane.add("Glossy Round Rectangular", pane2);
		tabPane.add("Standard Rectangular", pane3);
		tabPane.add("Standard Round Rectangular", pane4);
		tabPane.add("Gradient Rectangular", pane5);
		tabPane.add("Gradient Round Rectangular", pane6);

		return tabPane;
	}

	public JPanel createTranslucentPanel() {
		JPanel rootPanel = new JPanel(new BorderLayout());

		JPanel checkerboard = new Checkerboard();
		checkerboard.setPreferredSize(new Dimension(300, 2500));
		List<Integer> themes = ThemesList.createStandardThemesList();
		for (Integer theme : themes) {
			Translucent translucentPNL = new Translucent(theme);
			translucentPNL.setPreferredSize(new Dimension(250, 200));
			checkerboard.add(translucentPNL);

		}
		rootPanel.add(new JScrollPane(checkerboard));
		return rootPanel;
	}

	

	private static class Checkerboard extends JPanel {
		private static final int DIVISIONS = 10;

		static final int CHECKER_SIZE = 60;

		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.white);
			g2d.fillRect(0, 0, getWidth(), getHeight());
			g2d.setColor(Color.BLACK);
			for (int stripeX = 0; stripeX < getWidth(); stripeX += CHECKER_SIZE) {
				for (int y = 0, row = 0; y < getHeight(); y += CHECKER_SIZE / 2, ++row) {
					int x = (row % 2 == 0) ? stripeX
							: (stripeX + CHECKER_SIZE / 2);
					g2d.fillRect(x, y, CHECKER_SIZE / 2, CHECKER_SIZE / 2);
				}
			}

			g2d.drawImage(new ImageIcon(
					"resources/images/Butterflies_desktop_backgrounds.jpg")
					.getImage(), 0, 0, null);
		}
	}

	public JPanel getCardLayoutPanel() {
		return cardLayoutPanel;
	}

	public void setCardLayoutPanel(JPanel cardLayoutPanel) {
		this.cardLayoutPanel = cardLayoutPanel;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	class MyTreeCellRendrer extends DefaultTreeCellRenderer {
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean arg2, boolean arg3, boolean arg4, int arg5, boolean arg6) {
			JLabel label = (JLabel) super.getTreeCellRendererComponent(tree,
					value, arg2, arg3, arg4, arg5, arg6);

			// TODO Auto-generated method stub
			System.out.println(tree.getSelectionPath());
			if (!label.getText().equalsIgnoreCase("JTree")
					&& !label.getText().equalsIgnoreCase("colors")
					&& !label.getText().equalsIgnoreCase("sports")
					&& !label.getText().equalsIgnoreCase("food"))
				label.setIcon(new ImageIcon(
						"resources/images/bullet_ball_glass_red.png"));

			return label;
		}

		MyTreeCellRendrer() {
			super();
		}

		// setIcon(new ImageIcon("resources/images/bullet_ball_glass_red.png"));

	}

}
