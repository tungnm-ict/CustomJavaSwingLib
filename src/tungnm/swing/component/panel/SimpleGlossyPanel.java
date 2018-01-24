/**
 * Copyright(C) 2016 NMT
 *
 * Class SimpleGlossyPanel.java Jul 29, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.panel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import javax.swing.JPanel;
import tungnm.swing.util.Colors;
import tungnm.swing.util.PanelType;
import tungnm.swing.util.Theme;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class SimpleGlossyPanel extends JPanel {

	private int theme;
	private int panelType = PanelType.PANEL_RECTANGULAR;
	private Paint glossyBgColor;
	private GradientPaint glossyFgColor;

	public SimpleGlossyPanel() {
		theme = Theme.GLOSSY_SILVER_THEME;
	}

	/**
	 * Constructor with theme of the panel.
	 * 
	 * @param theme
	 *            theme of the panel
	 */
	public SimpleGlossyPanel(int theme) {
		this.theme = theme;
	}

	/**
	 * Constructor with theme and panel type.
	 * 
	 * @param theme
	 *            theme of the panel
	 * @param panelType
	 *            type of the panel
	 */
	public SimpleGlossyPanel(int theme, int panelType) {
		this.panelType = panelType;
		this.theme = theme;

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
				java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		int h = getHeight();
		int w = getWidth();
		List glossyColors = Colors.getInStance()
				.getGlossyColor(theme, 0, h / 2);
		glossyFgColor = (GradientPaint) glossyColors.get(0);
		glossyBgColor = (Paint) glossyColors.get(1);

		drawShape(g2d, w, h);
	}

	/**
	 * Draws the shape.
	 * 
	 * @param g2d
	 *            2D Graphics object.
	 * @param w
	 *            width of the button
	 * @param h
	 *            height of the Button
	 */
	private void drawShape(Graphics2D g2d, int w, int h) {
		if (panelType == PanelType.PANEL_ROUNDED_RECTANGLUR) {
			RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
					w - 1, h - 1, 8, 8);
			Shape clip = g2d.getClip();
			g2d.clip(r2d);
			g2d.setPaint(glossyBgColor);
			g2d.fillRoundRect(0, 0, w, h, 8, 8);
			g2d.setClip(clip);
			g2d.setPaint(glossyFgColor);
			g2d.fillRoundRect(2, 2, w - 4, h / 2, 5, 5);

			g2d.setColor(new Color(50, 50, 50, 200));
			g2d.drawRoundRect(0, 0, w - 1, h - 1, 8, 8);

			g2d.setColor(new Color(255, 255, 255, 100));
			g2d.drawRoundRect(1, 1, w - 3, h - 3, 8, 8);
		} else if (panelType == PanelType.PANEL_RECTANGULAR) {

			g2d.setPaint(glossyBgColor);
			g2d.fillRect(0, 0, w, h);

			g2d.setPaint(glossyFgColor);
			g2d.fillRect(2, 2, w - 4, h / 2);

			g2d.setColor(new Color(0, 0, 0, 100));
			g2d.drawRect(0, 0, w - 1, h - 1);
			g2d.setColor(new Color(255, 255, 255, 100));
			g2d.drawRect(1, 1, w - 3, h - 3);

		} else if (panelType == PanelType.PANEL_ROUNDED) {

			RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
					w - 1, h - 1, 8, 8);
			Shape clip = g2d.getClip();
			g2d.clip(r2d);

			g2d.setPaint(glossyBgColor);
			g2d.fillRoundRect(0, 0, w, h, h - 3, h - 3);
			g2d.setClip(clip);

			g2d.setPaint(glossyFgColor);
			g2d.fillRoundRect(2, 2, w - 4, h / 2, h - 5, h - 5);

			g2d.setColor(new Color(100, 100, 100));
			g2d.drawRoundRect(0, 0, w - 1, h - 1, h - 3, h - 3);
			g2d.setColor(new Color(255, 255, 255, 100));
			g2d.drawRoundRect(1, 1, w - 3, h - 3, h - 3, h - 3);

			
			
		}
	}

}

