package only;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;




public class GamePanel extends JPanel{
	
	private JLabel highScoreLabel;
	private JLabel scoreLabel;
	private Game controller;
	private Frame window;
	
	private Timer t;
	private ActionListener newFrame;

	
	private ArrayList<Obstacle> obstacles;
	private User user;
	private int timeSinceLastSpawn = 0;
	private int score = 0;
	private int intervalBtwnSpawn = 300;
	// for when this is referring to an action listener
	GamePanel a = this;
	
	public GamePanel(Game controller, Frame window) {
		super();
		this.controller = controller;
		this.window = window;
		scoreLabel = new JLabel("Score: 0");
		highScoreLabel = new JLabel("High Score: " + controller.getHighScore());
		
		obstacles = new ArrayList<Obstacle>();
		user = new User(this);
		this.setOpaque(false);

		addActionListeners();
		//After 1 second, start a timer that ticks every 10 ms. Used for Obstacle Creation
		t = new Timer(10, newFrame);
		t.setInitialDelay(1000);

		startGame();
	}

	public void startGame() {
		this.addComponents();
		this.setEnabled(true);
		t.start();
		highScoreLabel.setEnabled(true);
		highScoreLabel.setVisible(true);
		System.out.println("Started");
	}

	private void addComponents() {
		this.add(scoreLabel);
		this.add(highScoreLabel);
	}
	
	public int getScore() {
		return score;
	}
	
	public void addActionListeners() {
		//Action listener for object creation
		newFrame = new ActionListener() {
			//When the timer fires
			public void actionPerformed(ActionEvent e) {
				//For each obstacle, move it, then check for collision with user
				for (int i = 0; i < obstacles.size(); i ++) {
					obstacles.get(i).setXPos(obstacles.get(i).getXPos() - obstacles.get(i).getSpeed());
					//if collding with user, call game.stop() and update scores and timers
					if (obstacles.get(i).isColliding(user) == 1) {
						controller.stop();
						controller.updateScore(score);
						t.stop();
					}
					//if colliding with edge of screen, remove object
					else if (obstacles.get(i).isColliding(user) == 2) {
						obstacles.remove(i);
						i --;
						score += 1;
						scoreLabel.setText("Score: " + score);
					}
				}
				//Move user upwards depending on whether Frame detects space is clicked
				if (window.getSpace() == true) {
					if (user.getNE()[1] >= 50 && user.getSE()[1] <= 770) {
						user.setSpeed(user.getSpeed() + 0.2);
						user.setYPos(user.getYPos() - user.getSpeed());
					}
					else {
						if (user.getNE()[1] < 50) {
							user.setN(50);
						}
						else {
							user.setS(770);
						}
						user.setSpeed(0);
					}
				}
				//else, move downwards
				else{
					if(user.getNE()[1] >= 50 && user.getSE()[1] <= 770){
						user.setSpeed(user.getSpeed() - 0.2);
						user.setYPos(user.getYPos() - user.getSpeed());
					}
					else {
						if (user.getNE()[1] < 50) {
							user.setN(50);
						}
						else {
							user.setS(770);
						}
						user.setSpeed(0);
					}
				}
				//timeSinceLastSpawn is continuously increased every time the timer fires
				timeSinceLastSpawn += 1;
				//if timeSinceLastSpawn reaches intervalBtwnSpawn, add a new object 
				if (!(timeSinceLastSpawn < intervalBtwnSpawn)) {
					obstacles.add(new Obstacle((int)(Math.random() * 7), a));
					timeSinceLastSpawn = 0;
					repaint();
					if (intervalBtwnSpawn > 60) {
						intervalBtwnSpawn = intervalBtwnSpawn - 30;
					}
				}
			}
		};
	}
	
	//This method is onstantly called by Jpanel; used to draw
	//all of the current obstacles and the user
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (obstacles.size() > 0) {
			for (Obstacle obs: obstacles) {
				obs.draw(g);
			}
		}
		user.draw(g);
	}
	
	public Frame getWindow() {
		return window;
	}
}