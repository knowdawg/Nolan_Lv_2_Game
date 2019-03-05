import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player{
	int x;
	int y;
	Player (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	void refresh(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 25, 25);
	}
}
