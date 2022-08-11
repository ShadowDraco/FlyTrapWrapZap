package code;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class GameManager {

	Screen screen;
	GUI gui;
	Level level;
	String state = "menu";
	GraphicsHandler graphics;

	// Menu images
	Image resizedCoverArt = new ImageIcon("src/assets/coverArt.png").getImage().getScaledInstance(500, 815, Image.SCALE_SMOOTH);
	ImageIcon coverImage = new ImageIcon(resizedCoverArt);

	public GameManager(Timer time, Screen screen) {

		this.screen = screen;
		level = new Level(100);
		gui = new GUI(this, coverImage);
		graphics = new GraphicsHandler(level);

		screen.add(gui);
		screen.setVisible(true);

	}

	public void setGameState(String state) {
		this.state = state;
		if (state == "menu") {
			// Add GUI
			screen.remove(graphics);
			screen.repaint();
			screen.add(gui);
			graphics.inGame = false;
		}

		if (state == "game") {
			screen.remove(gui);

			level = new Level(100);
			graphics = new GraphicsHandler(level);
			// Add Graphics
			screen.add(graphics);
			screen.addKeyListener(new KeyHandler(level.player, this));
			graphics.inGame = true;
		}
	}

	public void update() {
		if (state == "game") {
			graphics.inGame = true;
			level.update();
			graphics.score = level.score;
			graphics.repaint();
		}
		if (state == "menu") {
			graphics.inGame = false;
		}
	}
}