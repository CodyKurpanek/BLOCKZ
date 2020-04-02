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

public class GamePanel extends JPanel implements KeyListener{
	
	private JLabel highScoreLabel;
	private JLabel scoreLabel;
	private Game controller;
	private ActionListener moveUser;
	private Timer t;
	private ArrayList<Obstacle> obstacles;
	private User user;
	private boolean space;
	private Graphics g;
	private int count = 0;
	private int score = 0;
	private int interval = 300;
	GamePanel a = this;
	
	public GamePanel(Game controller) {
		super();
		this.controller = controller;
		scoreLabel = new JLabel("Score: 0");
		
		highScoreLabel = new JLabel("High Score: " + controller.getHighScore());
		highScoreLabel.setFocusable(true);
		highScoreLabel.addKeyListener(this);
		obstacles = new ArrayList<Obstacle>();
		user = new User(this);
		this.setOpaque(false);

		
		addActionListeners();
		t = new Timer(10, moveUser);
		t.setInitialDelay(1000);

		startGame();
		
		
	}

	private void addComponents() {
		this.add(scoreLabel);
		this.add(highScoreLabel);
	}
	
	public int getScore() {
		return score;
	}


	public void setActionListeners() {
	}
	
	public void addActionListeners() {
		moveUser = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count += 1;
				for (int i = 0; i < obstacles.size(); i ++) {
					obstacles.get(i).setXPos(obstacles.get(i).getXPos() - obstacles.get(i).getSpeed());
					if (obstacles.get(i).isColliding(user) == 0) {
						controller.stop();
						controller.updateScore(score);
						t.stop();
					}
					else if (obstacles.get(i).isColliding(user) == 1) {
						obstacles.remove(i);
						i --;
						score += 1;
						scoreLabel.setText("Score: " + score);
					}
				}
				
				if (space == true) {
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
				
				if (count > interval) {
					obstacles.add(new Obstacle((int)(Math.random() * 7), a));
					count = 0;
					repaint();
					if (interval > 60) {
						interval = interval - 30;
					}
				}
			}
		};
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (obstacles.size() > 0) {
			for (Obstacle obs: obstacles) {
				obs.draw(g);
			}
		}
		user.draw(g);
	}
	
	public void repaint(Graphics g) {
		super.repaint();
		if (obstacles.size() > 0) {
			for (Obstacle obs: obstacles) {
				obs.draw(g);
			}
		}
		user.draw(g);
	}
	
	
	public void startGame() {
		this.addComponents();
		this.setEnabled(true);
		highScoreLabel.setEnabled(true);
		highScoreLabel.setVisible(true);
		highScoreLabel.isEnabled();
		highScoreLabel.isVisible();
		
		t.start();
		System.out.println("Started");
	}
	




	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 32) {
			space = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 32) {
			space = false;
		}
	}

	@Override 
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}