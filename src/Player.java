import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player{
	int x;
	int y;
	int lives = 799;
	int score = 0;
	Rectangle collisionBox;
	
	Player (int x, int y){
		this.x = x;
		this.y = y;
		collisionBox = new Rectangle(x, y, 25, 25);
	}
	
	void refresh(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 25, 25);
		
		g.setColor(Color.BLUE);
		g.drawRect(100, 0, 800, 20);
		
		if (lives >= 800) {
			lives = 800;
			g.setColor(Color.WHITE);
		} else if (lives < 200) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.GREEN);
		}

		g.fillRect(100, 0, lives, 20);
		
		collisionBox.setBounds(x, y, 25, 25);
	}
}
