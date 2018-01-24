/**
 * Copyright(C) 2016 NMT
 *
 * Class HeadingPanel.java Jul 29, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import tungnm.swing.util.Colors;
import tungnm.swing.util.PanelType;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class HeadingPanel extends JPanel {

	private int theme;
	private String themeType;
	private ImageIcon icon;
	private String title = "";
	private String iconPath;
	private BufferedImage panelImage;
	private Font font;
	private int panelType = PanelType.PANEL_ROUNDED_RECTANGLUR;

	/**
	 * Constructor with title and theme of the Panel.
	 * 
	 * @param title
	 *            text on the panel
	 * @param theme
	 *            theme of the panel
	 */
	public HeadingPanel(String title, int theme) {
		this.title = title;
		this.theme = theme;
		this.themeType = getThemeType();
		font = new Font("Thoma", Font.BOLD, 12);
	}

	/**
	 * Constructor with title,theme and panel type.
	 * 
	 * @param title
	 *            text on the panel
	 * @param theme
	 *            theme of the panel
	 * @param panelType
	 *            panel type.
	 */
	public HeadingPanel(String title, int theme, int panelType) {
		this.title = title;
		this.theme = theme;
		this.themeType = getThemeType();
		this.panelType = panelType;
		font = new Font("Thoma", Font.BOLD, 12);
	}

	/**
	 * Constructor with title,theme and icon path.
	 * 
	 * @param title
	 *            text on the panel
	 * @param theme
	 *            theme of the panel
	 * @param iconpath
	 *            icon path
	 */
	public HeadingPanel(String title, int theme, String iconpath) {
		this.theme = theme;
		this.title = title;
		this.iconPath = iconpath;
		this.themeType = getThemeType();
		font = new Font("Thoma", Font.BOLD, 12);

	}

	/**
	 * Constructor with title,theme,icon path and panelType.
	 * 
	 * @param title
	 *            text on the panel
	 * @param theme
	 *            theme of the panel
	 * @param iconpath
	 *            path of the icon
	 * @param panelType
	 *            type of panel
	 */
	public HeadingPanel(String title, int theme, String iconpath, int panelType) {
		this.theme = theme;
		this.title = title;
		this.iconPath = iconpath;
		System.out.println(iconPath);
		this.themeType = getThemeType();
		this.panelType = panelType;
		font = new Font("Thoma", Font.BOLD, 12);

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
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
	 * Creates the panel Image.
	 */
	private void createPanelImage() {
		panelImage = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = panelImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
				java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		int width = getWidth();
		int height = getHeight();
		int titlePos = 10;
		List colors = null;
		Paint bgColor = null;
		GradientPaint fgColor = null;
		Color textColor = new Color(0, 0, 0);
		if (themeType.equalsIgnoreCase("GLOSSY")) {
			System.out.println("Height" + height);
			colors = Colors.getInStance().getGlossyColor(theme, 0,
					getHeight() / 2);
			textColor = (Color) colors.get(2);
			bgColor = (Paint) colors.get(1);
			fgColor = (GradientPaint) colors.get(0);
			if (panelType == PanelType.PANEL_ROUNDED_RECTANGLUR) {
				g2d.setPaint((Paint) colors.get(1));
				g2d.fill(getBGShape(width, height));
				g2d.setPaint((Paint) colors.get(0));
				g2d.fill(getGlossyShape(width, height));
				g2d.setPaint(new Color(255, 255, 255, 120));
				g2d.draw(getInnerBGShape(width, height));
				g2d.setColor(new Color(100, 100, 100, 150));
				g2d.draw(getBGShape(width, height));
			} else if (panelType == PanelType.PANEL_RECTANGULAR) {
				g2d.setPaint(bgColor);
				g2d.fillRect(0, 0, width, height);
				g2d.setPaint(fgColor);
				g2d.fillRect(2, 2, width - 4, height / 2);
				g2d.setColor(new Color(255, 255, 255, 100));
				g2d.drawRect(1, 1, width - 3, height - 3);
				g2d.setColor(new Color(100, 100, 100, 150));
				g2d.drawRect(0, 0, width - 1, height - 1);

			}

		} else {
			if (themeType.equalsIgnoreCase("Standard")) {
				colors = Colors.getInStance().getStandardColor(theme, 0,
						getHeight());
			} else {
				colors = Colors.getInStance().getGradientColor(theme, 0,
						getHeight());

			}
			textColor = (Color) colors.get(1);
			if (panelType == PanelType.PANEL_ROUNDED_RECTANGLUR) {
				g2d.setPaint((Paint) colors.get(0));
				g2d.fill(getBGShape(width, height));
				g2d.setPaint(new Color(255, 255, 255, 120));
				g2d.draw(getInnerBGShape(width, height));
				g2d.setColor(new Color(50, 50, 50, 150));
				g2d.draw(getBGShape(width, height));
			} else {
				g2d.setPaint((Paint) colors.get(0));
				g2d.fillRect(0, 0, width, height);
				g2d.setPaint(new Color(50, 50, 50, 150));
				g2d.drawRect(0, 0, width - 1, height - 1);
				g2d.setPaint(new Color(255, 255, 255, 50));
				g2d.drawRect(1, 1, width - 3, height - 3);

			}

		}

		if (this.iconPath != null) {
			icon = new ImageIcon(this.iconPath);
			titlePos = icon.getIconWidth();
			g2d.drawImage(icon.getImage(), 8, height / 4, null);

		}
		g2d.setFont(font);
		if (textColor == Color.WHITE) {
			g2d.setColor(new Color(0, 0, 0));
		} else {
			g2d.setColor(new Color(255, 255, 255));
		}
		g2d.drawString(title, titlePos + 10, (height + 10) / 2 + 1);
		g2d.setColor(textColor);
		g2d.drawString(title, titlePos + 10, (height + 10) / 2);
	}

	private Shape getGlossyShape(int width, int height) {
		RoundRectangle2D roundRect = new RoundRectangle2D.Float(2, 1,
				width - 3, height, 6, 6);
		Rectangle2D rect = new Rectangle2D.Float(2, height / 2 + 2, width - 3,
				height - 2);
		Area shape = new Area(roundRect);
		shape.subtract(new Area(rect));
		return shape;
	}

	/**
	 * Gets the Background Shape.
	 * 
	 * @param width
	 *            width of the panel
	 * @param height
	 *            height of the panel
	 * @return Shape.
	 */
	private Shape getBGShape(int width, int height) {
		RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0,
				width - 1, height + 10, 8, 8);
		Rectangle2D rect = new Rectangle2D.Float(0, height, width - 1,
				height - 2);
		Area shape = new Area(roundRect);
		shape.subtract(new Area(rect));
		return shape;
	}

	/**
	 * Gets the Inner Shape.
	 * 
	 * @param width
	 *            width of the panel
	 * @param height
	 *            height of the panel
	 * @return
	 */
	private Shape getInnerBGShape(int width, int height) {
		RoundRectangle2D roundRect = new RoundRectangle2D.Float(1, 1,
				width - 3, height + 2, 8, 8);
		Rectangle2D rect = new Rectangle2D.Float(1, height - 1, width - 2,
				height - 2);
		Area shape = new Area(roundRect);
		shape.subtract(new Area(rect));
		return shape;
	}

	/**
	 * Return the ThemeType.
	 * 
	 * @return themeType
	 */
	public String getThemeType() {
		if (theme > 200) {
			themeType = "STANDARD";
		} else if (theme > 100) {
			themeType = "GRADIENT";
		} else {
			themeType = "GLOSSY";
		}

		return themeType;
	}

	/**
	 * Returns the font.
	 * 
	 * @return font.
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * Sets the font.
	 */
	public void setFont(Font font) {
		this.font = font;
	}

}

