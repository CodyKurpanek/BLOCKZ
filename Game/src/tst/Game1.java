package tst;

public class Game1{
	private TestFrame1 window;
	
	public Game1() {
		window = new TestFrame1(this);
	}

	public void play() {		
		window.gameScreen();
	}
	
	public void stop() {
		window.startScreen();
	}

}
