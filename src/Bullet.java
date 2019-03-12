import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	int x;
	int y;
	int moveToX;
	int moveToY;
	int xDirection;
	int yDirection;
	double xDistance;
	double yDistance;
	
	Bullet(int x, int y, int moveToX, int moveToY, int playerX, int playerY){
		
		if (moveToX < x) {
			xDirection = -1;
		} else {
			xDirection = 1;
		}
		
		if (moveToY < y) {
			yDirection = -1;
		} else {
			yDirection = 1;
		}
		
		this.moveToX = moveToY;
		this.moveToY = moveToY;
		xDistance = Math.abs(x - moveToX) / 30;
		yDistance = Math.abs(y - moveToY) / 30;
		//x = moveToX;
		//y = moveToY;
		
		this.x = x;
		this.y = y;
	}
	
	void refresh(Graphics g){
		
		/*
		if (xDirection > 0 && x > moveToX) {
			
		} else if (xDirection < 0 && x < moveToX) {
			
		}
		
		if (yDirection > 0 && y > moveToY) {

		} else if (yDirection < 0 && y < moveToY) {

		}
		*/
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 5, 5);
		
		x += xDistance * xDirection;
		y += yDistance * yDirection;
	}
			
}
