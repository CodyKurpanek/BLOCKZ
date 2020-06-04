package tst;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel1 extends JPanel{
	
	private Game1 controller;
	private TestFrame1 window;
	
	
	// for when this is referring to an action listener
	GamePanel1 a = this;

	public GamePanel1(Game1 controller, TestFrame1 window) {
		super();
		this.controller = controller;
		this.window = window;
		this.setOpaque(false);
		
}

		
		//addActionListeners();
		//startGame();


	public void startGame() {
		//this.addComponents();
	}
}
