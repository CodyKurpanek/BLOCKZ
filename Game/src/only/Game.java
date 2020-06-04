package only;

import javax.swing.JFrame;

public class Game{
	private TestFrame window;
	private int width;
	private int height;
	private int highScore = 0;
	
	public Game() {
		window = new TestFrame(this);
	}
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		window = new TestFrame(this);
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
	
	public void setSize() {
		
	
	}
	public int[] getSize() {
		int[] size = {width, height};
		return size;
	}
}