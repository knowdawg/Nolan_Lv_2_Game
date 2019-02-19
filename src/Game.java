import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game{
	JFrame gameFrame = new JFrame();
	PaintPanel gamePanel = new PaintPanel();
	static final int gameWidth = 1000;
	static final int gameHieght = 1000;
	
	public static void main(String[] args) {
		Game originalGame;	
		originalGame = new Game();
		originalGame.setUp();
	}
	
	void setUp() {
		gameFrame.add(gamePanel);
		gameFrame.setVisible(true);
		gameFrame.addKeyListener(gamePanel);
		gameFrame.setSize(1000, 1000);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

