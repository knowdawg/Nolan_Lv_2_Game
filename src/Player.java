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
	int lives = 200;
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
		
		g.setColor(Color.GREEN);
		g.drawRect(400, 0, 200, 20);
		
		g.setColor(Color.RED);
		g.fillRect(400, 0, lives, 20);
		
		collisionBox.setBounds(x, y, 25, 25);
		System.out.println(score);
	}
}
