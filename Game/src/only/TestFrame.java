package only;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame extends JFrame implements KeyListener{
	
	private HomePanel homePanel;
	//private GamePanel gamePanel;
	
	private Game controller;
	private JPanel panelCards;
	private boolean space;
	private JLabel ALBot;
	
	public TestFrame(Game controller) {
		super();
		ALBot = new JLabel("j");
		ALBot.setVisible(true);
		ALBot.setFocusable(true);
		ALBot.addKeyListener(this);
		this.add(ALBot);
		this.panelCards = new JPanel(new CardLayout());
		this.controller = controller;
		this.setEnabled(true);
		this.homePanel = new HomePanel(controller);	
		loadFrame();
	}
		
	public void loadFrame() {
		panelCards.add(homePanel, "HOME");
		this.add(panelCards);
		panelCards.setVisible(true);
		this.setSize(controller.getSize()[0], controller.getSize()[1]);
		this.setVisible(true);
		this.setResizable(false);
		this.setEnabled(true);
		((CardLayout)panelCards.getLayout()).show(panelCards , "HOME");
	}
	
	
	public HomePanel getHomePanel() {
		return homePanel;
	}
	
	public void startScreen() {
		panelCards.remove(1);
		((CardLayout)panelCards.getLayout()).show(panelCards , "HOME");
		
	}
	
	public void gameScreen() {
		panelCards.add(new GamePanel(controller, this), "GAME");
		panelCards.setEnabled(true);
		((CardLayout)panelCards.getLayout()).show(panelCards , "GAME");
	}
	
	public boolean getSpace() {
		return space;
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