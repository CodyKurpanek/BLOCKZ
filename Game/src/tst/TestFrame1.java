package tst;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TestFrame1 extends JFrame{
	
	private HomePanel1 homePanel;
	//private GamePanel gamePanel;
	
	private Game1 controller;
	private JPanel panelCards;

	
	public TestFrame1(Game1 controller) {
		super();
		this.panelCards = new JPanel(new CardLayout());
		this.controller = controller;
		this.homePanel = new HomePanel1(controller);	
		loadFrame();
	}
		
	public void loadFrame() {
		panelCards.add(homePanel, "HOME");
		this.add(panelCards);
		panelCards.setVisible(true);
		this.setSize(1300, 800);
		this.setVisible(true);
		this.setResizable(false);
		this.setEnabled(true);
		((CardLayout)panelCards.getLayout()).show(panelCards , "HOME");
	}

	public HomePanel1 getHomePanel() {
		return homePanel;
	}
	
	public void startScreen() {
		panelCards.remove(1);
		((CardLayout)panelCards.getLayout()).show(panelCards , "HOME");
		
	}
	
	public void gameScreen() {
		panelCards.add(new GamePanel1(controller, this), "GAME");
		panelCards.setEnabled(true);
		((CardLayout)panelCards.getLayout()).show(panelCards , "GAME");
	}
}
	
