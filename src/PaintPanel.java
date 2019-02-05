import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PaintPanel extends JPanel implements KeyListener{
	
	int gameState = 0;
	private Color menuColor = Color.BLUE;
	private Color gameColor = Color.BLACK;
	private Color endColor = Color.RED;
	public void paintComponent(Graphics g) {
		if (gameState == 0) {
			g.setColor(menuColor);
			g.fillRect( 0, 0, 1000, 1000);
		} else

		if (gameState == 1) {
			g.setColor(gameColor);
			g.fillRect( 0, 0, 1000, 1000);
		} else
		
		if (gameState == 2) {
			g.setColor(endColor);
			g.fillRect( 0, 0, 1000, 1000);
		}
	}
	
	public int getGameState() {
		return gameState;
	}
	
	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
		}
		
	}
}
