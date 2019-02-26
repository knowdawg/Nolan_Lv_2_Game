import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PaintPanel extends JPanel implements KeyListener, ActionListener{
	
	Timer refresh;
	//Player player = new Player(0, 0, );
	int gameState = 0;
	private Color menuColor = Color.BLUE;
	private Color gameColor = Color.BLACK;
	private Color endColor = Color.RED;
	Player player = new Player(100, 100);
	Enemy enemy = new Enemy(200, 200);
	
	PaintPanel (){
		refresh = new Timer(1000 / 60, this);
		refresh.start();
	}

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
				
				player.refresh(g);
				enemy.refresh(g, player.x, player.y);
		}
		
//																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (gameState > 3) {
				gameState = 1;
			} else {
				gameState += 1;
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		enemy.move();
	}
	
	
	
	
	
	
	
	// Totally Important stuff
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
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.x -= 10;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				player.x += 10;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				player.y -= 10;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				player.y += 10;
			}
	}


}
