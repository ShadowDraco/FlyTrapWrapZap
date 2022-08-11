package code;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8978606865621560857L;

	JButton[] buttons = new JButton[3];
	String[] buttonNames = { "New Game", "Heyyy", "Exit" };
	GameManager game;

	JPanel buttonPanel;
	JLabel caLabel;

	public GUI(GameManager game, ImageIcon coverArt) {
		this.game = game;

		caLabel = new JLabel();
		caLabel.setIcon(coverArt);

		// Panel for buttons
		buttonPanel = new JPanel();

		setBackground(Color.LIGHT_GRAY);

		// Set the size of the panels and labels

		// Add everything
		add(caLabel);
		add(buttonPanel);
		// Create buttons and add them
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].addActionListener(this);
			buttons[i].setVisible(true);
			buttonPanel.add(buttons[i]);
		}

	}

	public void pressButton(int buttonNumber) {
		// Button 1 is new Game
		// Button 2 is nothing
		// Button 3 is quit game

		if (buttonNumber + 1 == 1) {
			game.setGameState("game");
		}
		if (buttonNumber + 1 == 2) {
			System.out.println("heeyyy");
		}
		if (buttonNumber + 1 == 3) {
			System.exit(0);
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object buttonPressed = e.getSource();

		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == buttonPressed) {
				pressButton(i);
			}
		}

	}

}
