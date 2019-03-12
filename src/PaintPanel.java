import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PaintPanel extends JPanel implements KeyListener, ActionListener, MouseListener{
	
	boolean scope = false;
	Timer refresh;
	int gameState = 0;
	private Color menuColor = Color.BLUE;
	private Color gameColor = Color.BLACK;
	private Color endColor = Color.RED;
	Player player = new Player(100, 100);
	Enemy enemy = new Enemy(200, 200);
	ArrayList <Bullet> bullets = new ArrayList <Bullet>();
	boolean movingLeft = false;
	boolean movingRight = false;
	boolean movingUp = false;
	boolean movingDown = false;
	
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
					player.refresh(g);
					enemy.refresh(g, player.x, player.y);
					enemy.move();
					PointerInfo a = MouseInfo.getPointerInfo();
					Point b = a.getLocation();
					int mouse_x = (int) b.getX();
					int mouse_y = (int) b.getY() - 50;
					
					if (scope) {
						g.setColor(Color.WHITE);
						g.drawLine(player.x + 12, player.y + 13, mouse_x, mouse_y);
					}
					
					for (Bullet bullet : bullets) {
						bullet.refresh(g);
						if (bullet.xDirection > 0 && bullet.x > bullet.moveToX) {
							bullets.remove(bullet);
						} else if (bullet.xDirection < 0 && bullet.x < bullet.moveToX) {
							bullets.remove(bullet);
						}
						
						if (bullet.yDirection > 0 && bullet.y > bullet.moveToY) {
							bullets.remove(bullet);
						} else if (bullet.yDirection < 0 && bullet.y < bullet.moveToY) {
							bullets.remove(bullet);
						}
					}
				} else
				
				if (gameState == 2) {
					g.setColor(endColor);
					g.fillRect( 0, 0, 1000, 1000);
					
				}
				
				if (movingLeft) {
					player.x -= 5;
				}
				if (movingRight) {
					player.x += 5;
				}
				if (movingUp) {
					player.y -= 5;
				}
				if (movingDown) {
					player.y += 5;
				}
				
				if (player.x < 0) {
					player.x = 0;
				}
				if (player.x > 975) {
					player.x = 975;
				}
				if (player.y < 0) {
					player.y = 0;
				}
				if (player.y > 900) {
					player.y = 900;
				}
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
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				movingLeft = true;
			} else {
				movingLeft = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				movingRight = true;
			}  else {
				movingRight = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				movingUp = true;
			} else {
				movingUp = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				movingDown = true;
			} else {
				movingDown = false;
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		scope = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		scope = false;
		int mouse_x = e.getX();
		int mouse_y = e.getY() - 20;
		bullets.add(new Bullet(player.x + 12, player.y + 13, mouse_x, mouse_y, player.x, player.y));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
