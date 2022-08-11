package code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GameManager game;
	Player player;
	
	public KeyHandler(Player player, GameManager game) {
		this.player = player;
		this.game = game;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.startMovement(e);
		
		if (e.getKeyCode() == KeyEvent.VK_P) {
			game.setGameState("menu");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.endMovement(e);
	}

}
