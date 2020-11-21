package only;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Scanner;


public class User extends Obstacle{
	private String color;
	private Color a;
	


	public User(GamePanel controller){
		super(100, 700, 50, 50, controller);
		setSpeed(0);
		color = "blue";
		
		

		try {
		      File choseC = new File("Game/src/only/Color.txt");
		      Scanner i = new Scanner(choseC);
		        color = i.nextLine();
		        a = Color.getColor(color);
		        System.out.println(color);
		      i.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Error:");
		      e.printStackTrace();
		    }
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.red);
		if (color.equalsIgnoreCase("green")) {
			g.setColor(Color.green);
		}
		if (color.equalsIgnoreCase("blue")) {
			g.setColor(Color.blue);
		}
		if (color.equalsIgnoreCase("yellow")) {
			g.setColor(Color.yellow);
		}
		g.fillRect((int)getNW()[0], (int)getNW()[1], getWidth(), getHeight());
	}
	
	public boolean isColliding(Obstacle obs) {
		if (obs.getNW()[0] < this.getNE()[0] && obs.getSW()[1] > this.getNW()[1] && obs.getNW()[1] < this.getSW()[1] && obs.getNE()[0] > this.getNW()[0]) {
			return true;
		}
		return false;
	}
}