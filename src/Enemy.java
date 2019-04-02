import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy {
	
	Rectangle collisionBox;
	Random moveGenerator = new Random();
	boolean isAlive = true;
	final int roomWidth = 900;
	final int roomHeight = 900;
	final int timeTillNextEnlarge = 60;
	final int moveAmount = 5;
	int x;
	int y;
	int moveToX;
	int moveToY;
	
	int xDirection = 1;
	int yDirection = 1;
	
	double grow = 0;
	int growth = 0;
	Enemy (int x, int y){
		this.x = x;
		this.y = y;
		collisionBox = new Rectangle(x, y, 20, 20);
		moveToX = moveGenerator.nextInt(roomWidth);
		moveToY = moveGenerator.nextInt(roomHeight);
	}
	
	void refresh(Graphics g, int playerX, int playerY) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 20 + growth, 20 + growth);
		collisionBox.setBounds(x, y, 20 + growth, 20 + growth);
		g.setColor(Color.GREEN);
		g.drawLine(x + 10 + growth / 2, y + 10 + growth / 2, playerX + 12, playerY + 13);
		g.drawRect(x, y, 20 + growth, 20 + growth);
	}
	
	void move () {

		x += moveAmount * xDirection;
		y += moveAmount * yDirection;
		if (xDirection > 0 && x > moveToX) {
			newMoveToX();
		} else if (xDirection < 0 && x < moveToX) {
			newMoveToX();
		}
		
		if (yDirection > 0 && y > moveToY) {
			newMoveToY();
		} else if (yDirection < 0 && y < moveToY) {
			newMoveToY();
		}

		grow += 1;
		if (grow > timeTillNextEnlarge) {
			growth += 1;
			grow = 0;
		}
	}
	
	void newMoveToX () {
		moveToX = moveGenerator.nextInt(roomWidth);
		if (moveToX < x) {
			xDirection = -1;
		} else {
			xDirection = 1;
		}
	}
	void newMoveToY () {
		moveToY = moveGenerator.nextInt(roomHeight);
		if (moveToY < y) {
			yDirection = -1;
		} else {
			yDirection = 1;
		}
	}
}
