package only;
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

import tst.Game1;

public class HomePanel extends JPanel{
	private Game controller;
	
	private JButton playButton;
	private JLabel highScoreLabel;
	private JTextField textField;
	private JLabel instructions;	
	
	
	private String labelText;
	
	public HomePanel(Game game) {
		super();
		this.controller = game;
		
		highScoreLabel = new JLabel("High Score: 0");
		playButton = new JButton("PLAY"); 
		instructions = new JLabel("(Press Space to move up, release to move down!");
		
		addComponents();
		setActionListeners();
	}
	
	
	public void addComponents() {
		this.add(playButton);
		this.add(highScoreLabel);
		this.add(instructions);
	}
	
	public void setActionListeners(){
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent mouseClick)
			{
				controller.play();
			}
		});
    }
	
	public void setHighScoreLabel(String text) {
		highScoreLabel.setText(text);
	}
}