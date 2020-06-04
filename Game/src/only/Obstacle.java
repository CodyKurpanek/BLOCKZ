package only;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Obstacle{
	private double xPos, yPos;
	private int height, width;
	private double[] NW, NE, SE, SW;
	private double speed = (int)(Math.random() * 5) + 1;
	private GamePanel controller;

	public Obstacle(int type, GamePanel controller) {
		this.controller = controller;

		setWidth(100);
		setHeight(100);
		NW = new double[2];
		NE = new double[2];
		SE = new double[2];
		SW = new double[2];
		setXPos(730);
		setYPos(700 - 100 * type);
	}
	
	public Obstacle(double xPos, double yPos, int height, int width, GamePanel controller) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		this.controller = controller;
		controller.repaint();
		NW = new double[] {xPos - this.width / 2, yPos - this.height / 2};
		NE = new double[] {xPos + this.width / 2, yPos - this.height / 2};
		SE = new double[] {xPos + this.width / 2, yPos + this.height / 2};
		SW = new double[] {xPos - this.width / 2, yPos + this.height / 2};
	}
	
	public double getXPos() {
		return xPos;
	}
	public double getYPos() {
		return yPos;
	}
	public double[] getNW(){
		return NW;
	}
	public double[] getNE() {
		return NE;
	}
	public double[] getSE() {
		return SE;
	}
	public double[] getSW() {
		return SW;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public double getSpeed(){
		return speed;
	}
	
	
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
	public void setXPos(double xPos) {
		this.xPos = xPos;
		NW[0] = xPos - this.width / 2;
		NE[0] = xPos + this.width / 2;
		SE[0] = xPos + this.width / 2;
		SW[0] = xPos - this.width / 2;
		controller.repaint();
	}
	
	public void setYPos(double yPos) {
		this.yPos = yPos;
		
		NW[1] = yPos - this.height / 2;
		NE[1] = yPos - this.height / 2;
		SE[1] = yPos + this.height / 2;
		SW[1] = yPos + this.height / 2;
		controller.repaint();
	}
	
	public void setN(double n) {
		this.yPos = n + this.height / 2;
		
		NW[1] = yPos - this.height / 2;
		NE[1] = yPos - this.height / 2;
		SE[1] = yPos + this.height / 2;
		SW[1] = yPos + this.height / 2;
		controller.repaint();
	}
	
	public void setS(double s) {
		this.yPos = s - this.height / 2;
		
		NW[1] = yPos - this.height / 2;
		NE[1] = yPos - this.height / 2;
		SE[1] = yPos + this.height / 2;
		SW[1] = yPos + this.height / 2;
		controller.repaint();
	}
	
	void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)NW[0], (int)NW[1], width, height);
		/*g.setColor(Color.cyan);
		g.drawRect((int)SW[0], (int)SW[1], width, height);
		g.setColor(Color.gray);
		g.fillRect((int)SE[0], (int)SE[1], width, height);
		g.setColor(Color.green);
		g.drawRect((int)NE[0], (int)NE[1], width, height);
		*/
	}
	
	public int isColliding(User user) {
		if (NW[0] < user.getNE()[0] && NE[1] < user.getSE()[1] &&
				NE[0] > user.getSW()[0] && SE[1] > user.getNE()[1]) {
			return 0;
		}
		if (NE[0] <= 0) {
			return 1;
		}
		return -1;
	}


	
}