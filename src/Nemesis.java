import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Nemesis {
	
	Rectangle collisionBox;
	Random moveGenerator = new Random();
	boolean isAlive = true;
	final int roomWidth = 900;
	final int roomHeight = 900;
	final int moveAmount = 5;
	int x;
	int y;
	int moveToX;
	int moveToY;
	double xDistance;
	double yDistance;
	int xDirection = 1;
	int yDirection = 1;
	int xTarget;
	int yTarget;
	int targetTime = 0;
	Graphics g;
	boolean target = false;

	Nemesis(int x, int y, int playerX, int playerY){
		this.x = x;
		this.y = y;
		collisionBox = new Rectangle(x, y, 20, 20);
	}
	
	void refresh(Graphics g, int playerX, int playerY) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, 20, 20);
		collisionBox.setBounds(x, y, 20, 20);
		
		g.setColor(Color.ORANGE);
		g.drawLine(x + 10, y + 10, xTarget, yTarget);
		
		g.drawRect(x, y, 20, 20);
		x += xDistance;
		y += yDistance;
		if (target == false) {
			setTarget(g, playerX, playerY);
		}
		
		targetTime += 1;
		
		if (targetTime == 5) {
			setTarget(g, playerX, playerY);
			targetTime = 0;
		}
	}
	
	void setTarget(Graphics g, int playerX, int playerY) {

		double xdiff = x - moveToX;
		double ydiff = y - moveToY;
		double direction = Math.atan(ydiff/xdiff);
		
		int moveDifX = moveGenerator.nextInt(100) - 50;
		int moveDifY = moveGenerator.nextInt(100) - 50;
		
		xTarget = playerX + 12 + moveDifX;
		yTarget = playerY + 13 + moveDifY;
		
		moveToX = playerX + moveDifX;
		moveToY = playerY + moveDifY;
		
		xDistance = (Math.cos(direction) * 10);
		yDistance = (Math.sin(direction) * 10);
		
		if( x > moveToX ) {
			xDistance *= -1;
			yDistance *= -1;
		}
		
		target = true;
		
	}
	
}
