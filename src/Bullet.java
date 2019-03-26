import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	double x;
	double y;
	int bulletMoveSpeed = 10;
	int moveToX;
	int moveToY;
	int xDirection;
	int yDirection;
	double xDistance;
	double yDistance;
	
	Bullet(int x, int y, int moveToX, int moveToY, int playerX, int playerY){
		
		double xdiff = x - moveToX;
		double ydiff = y - moveToY;
		double direction = Math.atan(ydiff/xdiff);
				
		this.moveToX = moveToY;
		this.moveToY = moveToY;
		xDistance = (Math.cos(direction) * bulletMoveSpeed);
		yDistance = (Math.sin(direction) * bulletMoveSpeed);
		
		if( x > moveToX ) {
			xDistance *= -1;
			yDistance *= -1;
		}
		
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
		g.fillRect((int)x, (int)y, bulletMoveSpeed, bulletMoveSpeed);
		
		x += xDistance;
		y += yDistance;
	}
			
}
