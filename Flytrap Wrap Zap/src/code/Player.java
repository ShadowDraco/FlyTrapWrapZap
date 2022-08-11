package code;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Player {
	
	// Variables
	Image plantImage;
	Image img;
	
	double x;
	double y;
	
	double width;
	double height;
	double speed = 3;
	
	boolean movingUp;
	boolean movingDown;
	boolean movingLeft;
	boolean movingRight;

	Rectangle2D rect;

	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		
		plantImage = new ImageIcon("src/assets/plant.png").getImage();
		img = plantImage.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
		
		width = (double) img.getWidth(null);
		height = (double) img.getHeight(null);
		
		rect = new Rectangle2D.Double();
		rect.setRect(x, y, width, height);
	}
	
	public void startMovement(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			movingUp = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			movingDown = true;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			movingLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			movingRight = true;
		}
	}
	public void endMovement(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			movingUp = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			movingDown = false;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			movingLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			movingRight = false;
		}
	}
	
	public void move() {
		if (movingUp) {
			y-= speed;
		}
		if (movingDown) {
			y+= speed;
		}
		if (movingLeft) {
			x-= speed;
		}
		if (movingRight) {
			x+= speed;
		}
		
		if (y > 775) {
			y = 776;
		}
		
		if (y < 735) {
			y = 734;
		}
		
		if (x < 1) {
			x = 1;
		}
		if (x > 390) {
			x = 389;
		}
	}

	public void update() {
		width = (double) img.getWidth(null);
		height = (double) img.getHeight(null);
		move();
		rect.setRect(x, y, width, height);
	}

}
