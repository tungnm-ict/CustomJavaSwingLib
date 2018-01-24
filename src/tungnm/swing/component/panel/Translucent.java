/**
 * Copyright(C) 2016 NMT
 *
 * Class Translucent.java Jul 29, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.panel;

import java.awt.AlphaComposite;
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
import java.util.List;

import javax.swing.JPanel;
import tungnm.swing.util.Colors;
import tungnm.swing.util.Theme;



/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class Translucent extends JPanel {

	private String title = "";
	private int theme = Theme.STANDARD_BLACK_THEME;

	/**
	 * Default Constructor.
	 */
	public Translucent() {
		super();
	}

	/**
	 * Constructor with theme
	 * 
	 * @param theme
	 */
	public Translucent(int theme) {
		this.theme = theme;
	}

	@Override
	public void paintComponent(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Shape shape = null;
		Paint paint = null;
		int width = getWidth();
		int height = getHeight();
       
		//Set Transparency
		AlphaComposite newComposite = AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, .9f);
		g.setComposite(newComposite);

		// Background shape
		List colors = Colors.getInStance().getStandardColor(theme, 0, height);
		paint = (Paint) colors.get(0);
		shape = new RoundRectangle2D.Double(0, 0, width, height, 26, 26);
		g.setPaint(paint);
		g.fill(shape);
		
		//Set Transparency
		newComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f);
		g.setComposite(newComposite);
		
		paint = new GradientPaint(0, 0, new Color(255, 255, 255), 0, 50,
				((GradientPaint) colors.get(0)).getColor1());
		// Curved shape
		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(15.1308, 1.8172914);
		((GeneralPath) shape).curveTo(9.820799, 1.8172914, 2.1307993, 4.507291,
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
		g.setPaint(paint);
		g.fill(shape);
		
		// Drawing outer Shape
		shape = new RoundRectangle2D.Double(1, 1, width - 3, height - 3, 18, 18);
		g.setStroke(new BasicStroke(3));
		g.setPaint(new Color(255, 255, 255));
		g.draw(shape);
		
		g.setFont(new Font("Microsoft Sanserif", Font.BOLD, 20));
		g.setColor(new Color(0, 0, 0));
		g.drawString(title, width / 4 + 1, 31);
		g.setColor(new Color(0, 255, 0));
		g.drawString(title, width / 4, 30);
	
	
	}

	/**
	 * Returns the title.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            text on the panel
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
