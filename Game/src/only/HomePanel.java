package only;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
	
	private JButton playButton;
	private JLabel highScoreLabel;
	private JLabel instructions;	
	private JLabel title;
	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel d;
	private JLabel e;
	
	

	public HomePanel(Game game) {
		super();
		this.controller = game;
		
		this.setLayout(new GridLayout(3, 2));
		
		a = new JLabel();
		highScoreLabel = new JLabel("High Score: 0");
		instructions = new JLabel("(Press Space to move up, release to move down!)");
		b = new JLabel();
		playButton = new JButton("PLAY"); 
		c = new JLabel();
		d = new JLabel();
		title = new JLabel ("BLOCKZ");
		e = new JLabel();
		title.setFont(new Font("serif", Font.PLAIN, 105));
		playButton.setFont(new Font("serif", Font.PLAIN, 80));
		instructions.setFont(new Font("serif", Font.PLAIN, 20));
		highScoreLabel.setFont(new Font("serif", Font.PLAIN, 30));
		
		
		addComponents();
		setActionListeners();
	}
	
	
	public void addComponents() {
		
		this.add(a);
		this.add(highScoreLabel);
		this.add(instructions);
		this.add(b);
		this.add(title);
		this.add(c);
		this.add(d);
		this.add(playButton);
		this.add(e);

	}
	
	//actionListener that checks for whether the space bar is pressed
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