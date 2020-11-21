package only;

import javax.swing.JFrame;

public class Game{
	private Frame window;
	private int width;
	private int height;
	private int highScore = 0;
	
	public Game() {
		//Creates the JFrame that will contain the HomePanel and GamePanel
		window = new Frame(this);
	}
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		//Creates the JFrame that will contain the HomePanel and GamePanel
		window = new Frame(this);
	}
	
	public void play() {		
		window.gameScreen();
	}
	
	public void stop() {
		window.startScreen();
	}
	
	public int getHighScore() {
		return highScore;
	}
	
	public void updateScore(int score) {
		if (score > highScore) {
			highScore = score;
		}
		window.getHomePanel().setHighScoreLabel("High Score: " + highScore);
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int[] getSize() {
		int[] size = {width, height};
		return size;
	}
}