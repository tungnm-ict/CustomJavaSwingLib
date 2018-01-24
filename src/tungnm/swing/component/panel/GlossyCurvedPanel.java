/**
 * Copyright(C) 2016 NMT
 *
 * Class GlossyCurvedPanel.java Jul 29, 2016 Nguyen Manh Tung
 */



/**
 * Copyright (c) 2012, Dhilshuk Reddy All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute SwingJD software is freely
 * granted, provided that this notice is preserved.
 */
package tungnm.swing.component.panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;
import tungnm.swing.util.Colors;
import tungnm.swing.util.Theme;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class GlossyCurvedPanel extends JPanel {

	private int theme = Theme.GLOSSY_BLUEGRAY_THEME;
	private String title = "";
	private BufferedImage panelImage;
	private Font FONT;
	private Paint bgColor;
	private GradientPaint fgColor;
	private Color textColor;
	private List colors;

	public GlossyCurvedPanel() {

	}

	/**
	 * Constructor with title.
	 * 
	 * @param title
	 *            text on the Panel
	 */
	public GlossyCurvedPanel(String title) {
		this.title = title;
		init();
	}

	/**
	 * Constructor with the theme of the panel.
	 * 
	 * @param theme
	 *            theme of the Panel.
	 */
	public GlossyCurvedPanel(int theme) {
		this.theme = theme;
		init();
	}

	/**
	 * Constructor with title and theme of the Panel.
	 * 
	 * @param title
	 *            text on the panel
	 * @param theme
	 *            theme of the panel
	 */
	public GlossyCurvedPanel(String title, int theme) {
		this.title = title;
		this.theme = theme;
		init();
	}

	/**
	 * Constructor with the title,theme and color of the text.
	 * 
	 * @param title
	 *            text on the panel
	 * @param theme
	 *            theme of the panel
	 * @param textColor
	 *            color of the text
	 */
	public GlossyCurvedPanel(String title, int theme, Color textColor) {
		this.title = title;
		this.theme = theme;
		this.textColor = textColor;
		init();
	}

	/**
	 * Initilizes.
	 */
	private void init() {
		colors = Colors.getInStance().getGlossyColor(theme, 0, 50);
		fgColor = (GradientPaint) colors.get(0);
		if (colors.get(1) instanceof GradientPaint) {
			bgColor = ((GradientPaint) colors.get(1)).getColor1();
		} else {
			bgColor = (Paint) colors.get(1);
		}
		if (textColor == null) {
			textColor = (Color) colors.get(2);
		}
		this.FONT = new Font("Thoma", 1, 16);

	}

	@Override
	public void paintComponent(Graphics g2) {
		Graphics2D g2d = (Graphics2D) g2;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
				java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		int w = getWidth();
		int h = getHeight();
		if (panelImage == null || panelImage.getWidth() != w
				|| panelImage.getHeight() != h) {
			createPanelImage();
		}
		g2d.drawImage(panelImage, null, 0, 0);
	}

	/**
	 * Creates Panel Image.
	 */
	private void createPanelImage() {
		panelImage = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = panelImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
				java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Shape shape = null;
		Paint paint = null;
		int width = getWidth();
		int height = getHeight();

		// Background Panel
		shape = new RoundRectangle2D.Double(0, 0, width, height, 26, 26);
		paint = new GradientPaint(0, 0, (Color) bgColor, 0, 2 * getHeight(),
				Color.WHITE);
		g2d.setPaint(paint);
		g2d.fill(shape);

		paint = new GradientPaint(0, 2, new Color(255, 255, 255, 200), 0, 50,
				fgColor.getColor2());

		shape = createShape(width);
		g2d.setPaint(paint);
		g2d.fill(shape);

		// Outer Border
		g2d.setStroke(new BasicStroke(3));
		paint = new GradientPaint(0, 0, new Color(200, 200, 200), 0, height,
				new Color(70, 70, 70));
		shape = new RoundRectangle2D.Double(1, 1, width - 3, height - 3, 18.0,
				18.0);
		g2d.setPaint(paint);
		g2d.draw(shape);

		g2d.setFont(FONT);
		if (textColor == Color.WHITE) {
			g2d.setColor(new Color(0, 0, 0));
		} else {
			g2d.setColor(new Color(255, 255, 255));
		}
		g2d.drawString(title, width / 4, 31);

		g2d.setColor(textColor);
		g2d.drawString(title, width / 4, 30);

		g2d.dispose();

	}

	/**
	 * Creates Shape.
	 * 
	 * @param width
	 * @return
	 */
	private Shape createShape(int width) {
		Shape shape = new GeneralPath();
		((GeneralPath) shape).moveTo(15.1308, 1.8172914);
		((GeneralPath) shape).curveTo(6.820799, 1.8172914, 2.1307993, 4.507291,
				2.1307993, 13.817291);
		((GeneralPath) shape).lineTo(2.1307993, 31.78604);
		((GeneralPath) shape).curveTo(39.09004, 37.30802, 86.78241, 40.69229,
				width / 2, 40.69229);
		((GeneralPath) shape).curveTo(width / 2, 40.69229, width / 2 + 30,
				38.130333, width - 1, 33.84854);
		((GeneralPath) shape).lineTo(width - 1, 11.817291);
		((GeneralPath) shape).curveTo(width - 1, 6.507291, width - 5,
				2.8172914, width - 13, 1.8172914);
		((GeneralPath) shape).lineTo(18.1308, 1.8172914);
		((GeneralPath) shape).closePath();
		return shape;
	}

	/**
	 * Returns the text on the panel.
	 * 
	 * @return text on the panel
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Text on the Panel.
	 * 
	 * @param title
	 *            text of the panel.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}

