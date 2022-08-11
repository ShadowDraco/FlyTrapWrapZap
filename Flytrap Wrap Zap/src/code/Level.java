package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;
import java.util.ArrayList;

public class Level implements ActionListener {

	Random rand = new Random();
	Timer flyTime;
	Player player;
	ArrayList<Fly> flies = new ArrayList<Fly>();
	int fliesAllowed = 2;
	int timePassed = 0;
	int nextFlyTime = 100;

	int score = 0;
	
	public Level(int numFlies) {
		player = new Player(150, 985);
		for (int i = 0; i < numFlies; i++) {
			flies.add(generateFly());
		}
	}

	public void flyTimer(Timer flyTime) {
		if (timePassed > nextFlyTime) {
			flies.add(generateFly());
			nextFlyTime -= 10;
			fliesAllowed += 2;
			timePassed = 0;
		}
	}

	public Fly generateFly() {
		double x = rand.nextDouble(450);
		double y = -rand.nextDouble(100) - 50;
		double velY = rand.nextDouble(3) + 1;
		double velX;

		if (x > 250 / 2) {
			velX = rand.nextDouble(2) + 1;
		} else {
			velX = -rand.nextDouble(2) + 1;
		}

		return new Fly(x, y, velX, velY);
	}

	public void checkCollisions(Fly fly) {
		if (player.rect.intersects(fly.rect)) {
			score += 5;
			flies.remove(fly);
		}
	}
	
	public void update() {
		flyTimer(flyTime);
		player.update();
		for (int i = 0; i < fliesAllowed; i++) {
			flies.get(i).update();
			if (flies.get(i).y > 900) {
				flies.remove(i);
			}
			checkCollisions(flies.get(i));
		}
	}

	public void actionPerformed(ActionEvent e) {
		timePassed++;
	}
}
