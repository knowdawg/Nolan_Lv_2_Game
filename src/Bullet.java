import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	
	double x;
	double y;
	Rectangle collisionBox;
	boolean isAlive = true;
	int bulletMoveSpeed = 20;
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
				
		this.moveToX = moveToX;
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
		collisionBox = new Rectangle(x, y, 10, 10);

	}
	
	void refresh(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, bulletMoveSpeed, bulletMoveSpeed);
		collisionBox.setBounds((int)x, (int)y, bulletMoveSpeed, bulletMoveSpeed);
		x += xDistance;
		y += yDistance;
	}
			
}












