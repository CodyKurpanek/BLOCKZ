package tst;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class HomePanel1 extends JPanel{
	private Game1 controller;
	private JButton playButton;


	public HomePanel1(Game1 game) {
		super();
		this.controller = game;
		playButton = new JButton("PLAY"); 
		
		
		addComponents();
		setActionListeners();
		
	}
	
	public void addComponents() {
		this.add(playButton);
	}
	
	public void setActionListeners(){
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent mouseClick)
			{
				controller.play();
			}
		});
	}
	
	
}
