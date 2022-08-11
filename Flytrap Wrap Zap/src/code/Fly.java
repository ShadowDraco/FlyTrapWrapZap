
package code;

import java.awt.Image;

import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Fly {

	// Variables
	Image flyImage;
	Image img;

	double x;
	double y;
	double velX;
	double velY;

	double width;
	double height;

	Rectangle2D rect;

	public Fly(double x, double y, double velX, double velY) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		flyImage = new ImageIcon("src/assets/fly.png").getImage();
		img = flyImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		width = (double) img.getWidth(null);
		height = (double) img.getHeight(null);

		rect = new Rectangle2D.Double();
		rect.setRect(x, y, width, height);
	}

	public void move() {
		x += velX;
		y += velY;
		if (x > 450 || x < 0) {
			velX = -velX;
		}
	}

	public void update() {
		width = (double) img.getWidth(null);
		height = (double) img.getHeight(null);
		move();
		rect.setRect(x, y, width, height);
	}

}
