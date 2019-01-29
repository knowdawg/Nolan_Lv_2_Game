import java.awt.Color;
import java.awt.Graphics;

public class Player {
	int x;
	int y;
	Player (int x, int y, Graphics g){
		this.x = x;
		this.y = y;
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 25, 25);
	}
	void move(int xDistance, int yDistance) {
		x += xDistance;
		y += yDistance;
	}
}
