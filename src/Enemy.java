import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy {
	
	Random moveGenerator = new Random();
	int x;
	int y;
	double grow = 0;
	int growth = 0;
	Enemy (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	void refresh(Graphics g, int playerX, int playerY) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 20 + growth, 20 + growth);
		g.setColor(Color.GREEN);
		g.drawLine(x + 10 + growth / 2, y + 10 + growth / 2, playerX + 12, playerY + 13);
	}
	
	void move () {
		
		x += moveGenerator.nextInt(7)- 3;
		y += moveGenerator.nextInt(7)- 3;
		
		if (x < 0) {
			x = 0;
		}
		if (x > 500) {
			x = 500;
		}
		if (y < 0) {
			y = 0;
		}
		if (y > 500) {
			y = 500;
		}

		grow += 1;
		if (grow > 60) {
			growth += 1;
			grow = 0;
		}
	}
}
