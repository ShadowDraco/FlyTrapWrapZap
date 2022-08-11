package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GraphicsHandler extends JPanel {

	private static final long serialVersionUID = -3685035358764283545L;

	Timer time;
	Player player;
	ArrayList<Fly> flies = new ArrayList<Fly>();

	Font font1 = new Font("Gulim", Font.ITALIC, 50);
	Integer score;

	boolean inGame = false;

	public GraphicsHandler(Level level) {
		this.player = level.player;
		this.flies = level.flies;

		setSize(500, 900);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void drawGame(Graphics2D g2) {
		AffineTransform old = g2.getTransform();
		AffineTransform playerImage = AffineTransform.getTranslateInstance(player.x, player.y);

		// Draw background
		g2.setColor(Color.blue);
		g2.fillRect(-1, -1, 502, 902);
		g2.setColor(Color.gray);
		g2.fillOval(-8, 0, 500, 900);

		// Set the transform to draw the image
		g2.setTransform(playerImage);
		g2.drawImage(player.img, 0, 0, null);

		for (int i = 0; i < flies.size(); i++) {
			AffineTransform flyImage = AffineTransform.getTranslateInstance(flies.get(i).x, flies.get(i).y);
			g2.setTransform(flyImage);
			g2.drawImage(flies.get(i).img, 0, 0, null);
		}

		// Set the transform to draw the bounding box
		g2.setTransform(old);
		g2.setColor(Color.black);
		g2.setFont(font1);
		g2.drawString("Score - " + score.toString(), 144 - score / 10, 80);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (inGame) {
			drawGame(g2);
		}
	}

}
