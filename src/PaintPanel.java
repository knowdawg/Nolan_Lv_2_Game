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
	int gameSize = 100;
	final int playerSpeed = 5;
	final int enemySpawnTime = 60;
	int nemieSpawnTime = 120;
	int timeTillNemieSpawn = 0;
	int timeTillEnemySpawn = 0;
	private Color menuColor = Color.BLUE;
	private Color gameColor = Color.BLACK;
	private Color endColor = Color.RED;
	Player player = new Player(100, 100);
	ArrayList <Bullet> bullets = new ArrayList <Bullet>();
	ArrayList <Enemy> enemies = new ArrayList <Enemy>();
	ArrayList <Nemesis> nemesis = new ArrayList <Nemesis>();
	boolean movingLeft = false;
	boolean movingRight = false;
	boolean movingUp = false;
	boolean movingDown = false;
	
	PaintPanel (){
		refresh = new Timer(1000 / 60, this);
		refresh.start();
		nemesis.add(new Nemesis(0,0, player.x, player.y));
	}

		public void paintComponent(Graphics g) {
				if (gameState == 0) {
					g.setColor(menuColor);
					g.fillRect( 0, 0, 1000, 1000);
				} else
		
				if (gameState == 1) {
					g.setColor(gameColor);
					g.fillRect( 0, 0, 1000, 1000);
					g.setColor(Color.GRAY);
					g.drawRect(0, 0, 100, 1000);
					g.drawRect(0, 0, 1000, 100);
					g.drawRect(900, 0, 100, 1000);
					g.drawRect(0, 875, 1000, 125);
					
					player.refresh(g);
					
					for (Enemy enemy : enemies) {
						enemy.refresh(g, player.x, player.y);
						enemy.move();
					}
					
					for (Nemesis nemies : nemesis) {
						nemies.refresh(g, player.x, player.y);
					}
					
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
					}
					
				  for(Bullet l : bullets){
					  for(Enemy f : enemies){
					        if(f.collisionBox.intersects(l.collisionBox)){
					        		f.isAlive = false;
					             l.isAlive = false;
				            	 player.score += 1;
					             if (f.growth > 5) {
					            	 	player.lives -= f.growth / 2;
					            	 	g.setColor(Color.RED);
						            	g.fillRect(0, 0, 1000, 1000);
					             }
					        	}
				        	}
				  }
				  
				  for(Bullet l : bullets){
					  for(Nemesis n : nemesis){
					        if(n.collisionBox.intersects(l.collisionBox)){
					        		n.isAlive = false;
					             l.isAlive = false;
				            	 player.score += 1;
					        	}
				        	}
				  }
				  

					  for(Nemesis n : nemesis){
					        if(n.collisionBox.intersects(player.collisionBox)){
					        		n.isAlive = false;
					        		player.lives -= 20;
					            	g.setColor(Color.RED);
					            	g.fillRect(0, 0, 1000, 1000);
					            	 player.score += 1;
					        	}
				        	}
				  

				  for(Enemy f : enemies){
					  if(f.collisionBox.intersects(player.collisionBox)){
					   	f.isAlive = false;
					       if (f.growth > 5) {
					            	 player.lives -= f.growth * 2;
					            	 g.setColor(Color.RED);
					            	 g.fillRect(0, 0, 1000, 1000);
					           }
			            	 player.score += 1;
					       }
				       }
				 
				  
				  for (int d = 0; d < bullets.size(); d ++) {
					  
						if (bullets.get(d).isAlive == false) {
							bullets.remove(d);
						}
					}
				  
				  for (int c = 0; c < enemies.size(); c ++) {
						
						if (enemies.get(c).isAlive == false) {
							enemies.remove(c);
						}
						
					}
				  
				  for (int c = 0; c < nemesis.size(); c ++) {
						
						if (nemesis.get(c).isAlive == false) {
							nemesis.remove(c);
						}
						
					}
				} else
				
				if (gameState == 2) {
					g.setColor(endColor);
					g.fillRect( 0, 0, gameSize, gameSize);
					
				}
				
				if (movingLeft) {
					player.x -= playerSpeed;
				}
				if (movingRight) {
					player.x += playerSpeed;
				}
				if (movingUp) {
					player.y -= playerSpeed;
				}
				if (movingDown) {
					player.y += playerSpeed;
				}
				
				if (player.x < 100) {
					player.x = 100;
				}
				if (player.x > 875) {
					player.x = 875;
				}
				if (player.y < 100) {
					player.y = 100;
				}
				if (player.y > 850) {
					player.y = 850;
				}
				
				if (player.x < 100) {
					player.x = 100;
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
		timeTillEnemySpawn += 1;
		timeTillNemieSpawn += 1;
		
		if (enemySpawnTime == timeTillEnemySpawn) {
			enemies.add(new Enemy(0, 0));
			timeTillEnemySpawn = 0;
		}
		if (nemieSpawnTime == timeTillNemieSpawn) {
			nemesis.add(new Nemesis(0,0, player.x, player.y));
			timeTillNemieSpawn = 0;
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
