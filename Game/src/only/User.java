package only;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class User extends Obstacle{
	
	
	public User(GamePanel controller){
		super(100, 700, 50, 50, controller);
		setSpeed(0);
	}
	
	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)getNW()[0], (int)getNW()[1], getWidth(), getHeight());
	}
	
	public boolean isColliding(Obstacle obs) {
		if (obs.getNW()[0] < this.getNE()[0] && obs.getSW()[1] > this.getNW()[1] && obs.getNW()[1] < this.getSW()[1] && obs.getNE()[0] > this.getNW()[0]) {
			return true;
		}
		return false;
	}
}