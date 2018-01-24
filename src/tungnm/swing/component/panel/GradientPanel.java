/**
 * Copyright(C) 2016 NMT
 *
 * Class GradientPanel.java Jul 29, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.panel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;
import tungnm.swing.util.Colors;
import tungnm.swing.util.PanelType;
import tungnm.swing.util.Theme;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class GradientPanel extends JPanel {

	private int theme = Theme.STANDARD_SILVER_THEME;
	private int panelType = PanelType.PANEL_RECTANGULAR;
	private BufferedImage panelImage;

	public GradientPanel() {

	}

	/**
	 * Constructor which takes label of the button as argument.
	 * 
	 * @param text
	 *            label on the button
	 */
	public GradientPanel(int theme) {
		this.theme = theme;
	}

	/**
	 * Constructor which sets label of the button,button type and the button
	 * theme.
	 * 
	 * @param text
	 *            label of the button
	 * @param buttonType
	 *            type of the button.
	 * @param buttonTheme
	 */
	public GradientPanel(int theme, int panelType) {
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
		int w = getWidth();
		int h = getHeight();
		if (panelImage == null || panelImage.getWidth() != w
				|| panelImage.getHeight() != h) {
			createPanelImage(w, h);
		}
		g2d.drawImage(panelImage, null, 0, 0);
	}

	/**
	 * Creates Panel Image.
	 */
	private void createPanelImage(int w, int h) {

		panelImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = panelImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
				java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		List colors = Colors.getInStance().getGradientColor(theme, 0, h);
		drawShape(g2d, w, h, (GradientPaint) colors.get(0));
		g2d.dispose();
	}

	/**
	 * Draws the shape.
	 * 
	 * @param g2d
	 *            2d object
	 * @param w
	 *            width of the button
	 * @param h
	 *            height of the button
	 */
	private void drawShape(Graphics2D g2d, int w, int h, GradientPaint color) {
		if (panelType == PanelType.PANEL_ROUNDED_RECTANGLUR) {
			RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
					w - 1, h - 1, 8, 8);
			Shape clip = g2d.getClip();
			g2d.clip(r2d);
			g2d.setPaint(color);
			g2d.fillRoundRect(0, 0, w, h, 8, 8);
			g2d.setClip(clip);
			g2d.setColor(new Color(100, 100, 100));
			g2d.drawRoundRect(0, 0, w - 1, h - 1, 8, 8);
			g2d.setColor(new Color(255, 255, 255, 50));
			g2d.drawRoundRect(1, 1, w - 3, h - 3, 8, 8);
		} else if (panelType == PanelType.PANEL_RECTANGULAR) {
			Rectangle2D.Float r2d = new Rectangle2D.Float(0, 0, w - 1, h - 1);
			Shape clip = g2d.getClip();
			g2d.clip(r2d);
			g2d.setPaint(color);
			g2d.fillRect(0, 0, w, h);
			g2d.setClip(clip);
			g2d.setColor(new Color(100, 100, 100));
			g2d.drawRect(0, 0, w - 1, h - 1);
			g2d.setColor(new Color(255, 255, 255, 50));
			g2d.drawRect(1, 1, w - 3, h - 3);
		} else if (panelType == PanelType.PANEL_ROUNDED) {
			g2d.setPaint(color);
			g2d.fillRoundRect(1, 1, w - 2, h - 2, h - 5, h - 5);
			g2d.setPaint(new Color(100, 100, 100));
			g2d.drawRoundRect(0, 0, w - 1, h - 1, h - 3, h - 3);
			g2d.setColor(new Color(255, 255, 255, 50));
			g2d.drawRoundRect(1, 1, w - 3, h - 3, h - 3, h - 3);
		} else if (panelType == PanelType.PANEL_CIRCULAR) {
			g2d.setPaint(color);
			g2d.fillOval(1, 1, w - 20, w - 2);
			g2d.setPaint(new Color(100, 100, 100));
			g2d.drawOval(0, 0, w - 20, w - 1);
		} else if (panelType == PanelType.PANEL_ELLIPSE) {
			g2d.setPaint(color);
			Shape shape = new Ellipse2D.Double(1, 1, w - 2, h - 2);
			g2d.fill(shape);
			g2d.setPaint(new Color(100, 100, 100));
			shape = new Ellipse2D.Double(0, 0, w - 1, h - 1);
			g2d.draw(shape);

		}
	}

}

