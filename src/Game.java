import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game implements KeyListener{
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
		gameFrame.addKeyListener(this);
		gameFrame.setSize(1000, 1000);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			gamePanel.gameState += 1;
			System.out.println("PRESSED");
		}
	}
}
