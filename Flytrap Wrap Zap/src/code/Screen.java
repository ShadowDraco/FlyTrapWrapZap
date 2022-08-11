package code;

import java.awt.CardLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JFrame implements ActionListener{

	private static final long serialVersionUID = -9213354843400750472L;
	
	Timer time;
	GameManager game;
	JPanel screens;
	
	public Screen () {
		time  = new Timer(1, this);
		game = new GameManager(time, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 900);
		setLocationRelativeTo(null);
		setFocusable(true);
		setResizable(false);
		// Set Layout 
		screens = new JPanel(new CardLayout());
		
		time.start(); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.update();
	}
	
	
}
