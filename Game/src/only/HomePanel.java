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

public class HomePanel extends JPanel{
	private Game controller;
	
	private JRadioButton RadioButton1;
	private JRadioButton radioButton2;
	private JButton playButton;
	private JLabel highScoreLabel;
	private JTextField textField;
	private JLabel instructions;	
	
	
	private String labelText;
	
	public HomePanel(Game controller) {
		super();
		this.controller = controller;
		RadioButton1 = new JRadioButton("This button has text!!");
		highScoreLabel = new JLabel("High Score: 0");
		playButton = new JButton("PLAY"); 
		instructions = new JLabel("(Press Space to move up, release to move down. "
				+ "Close and open the window first, there is  )");
		
		addComponents();
		setActionListeners();
	}
	
	
	public void addComponents() {
		this.add(playButton);
		this.add(highScoreLabel);
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