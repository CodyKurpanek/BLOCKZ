package only;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame implements KeyListener{
	
	private HomePanel homePanel;
	//private GamePanel gamePanel;
	
	private Game controller;
	private JPanel panelCards;
	private boolean space;
	private JLabel LabelForKeyListener;
	
	public Frame(Game controller) {
		//calls Jframe constructor
		super();
		LabelForKeyListener = new JLabel("j");
		LabelForKeyListener.setVisible(true);
		LabelForKeyListener.setFocusable(true);
		LabelForKeyListener.addKeyListener(this);
		this.add(LabelForKeyListener);
		//panelCards keeps track of HomePanel and GamePanel
		this.panelCards = new JPanel(new CardLayout());
		this.controller = controller;
		this.setEnabled(true);
		this.homePanel = new HomePanel(controller);	
		loadFrame();
	}
		
	public void loadFrame() {
		//add homePanel to panelCards with key "HOME"
		panelCards.add(homePanel, "HOME");
		this.add(panelCards);
		panelCards.setVisible(true);
		this.setSize(controller.getSize()[0], controller.getSize()[1]);
		this.setVisible(true);
		this.setResizable(false);
		this.setEnabled(true);
		//show HomePanel
		((CardLayout)panelCards.getLayout()).show(panelCards , "HOME");
	}
	
	
	public HomePanel getHomePanel() {
		return homePanel;
	}

	/**
 	* Deletes the current GamePanel and sets HomePanel as the primary panel
 	*/
	public void startScreen() {
		panelCards.remove(1);
		((CardLayout)panelCards.getLayout()).show(panelCards , "HOME");
		
	}
	
	/**
 	* Creates a new GamePanel, with initialized timers, then sets it as the primary panel
 	*/
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