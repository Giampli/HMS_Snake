package snake;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Head{

    int x;
    int y;
    int dx;
    int dy;
    boolean pause=false;
    Rectangle head;
    Rectangle hitbox;
    
    public Head(int scrHeight, int scrWidth) {
        x = (scrHeight-20)/2;
        y = (scrWidth-40)/2;
    	head=new Rectangle(x,y,10,10);
    	hitbox=new Rectangle(x+3,y+3,3,3);
    }

	public void move() {
		head.x += dx;
		head.y += dy;
		hitbox.x += dx;
		hitbox.y += dy;
        }

	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_P) {
            if(pause)
            	pause=false;
            else
            	pause=true;
        }
            	
        if (key == KeyEvent.VK_A) {
            if(dx!=1){
            	dx = -1;
            	dy = 0;
            }
        }

        else if (key == KeyEvent.VK_D) {
            if(dx!=-1){
            	dx = 1;
            	dy = 0;
            }
        }

        else if (key == KeyEvent.VK_W) {
        	if(dy!=1){
        		dy = -1;
            	dx = 0;
        	}
        }

        else if (key == KeyEvent.VK_S) {
        	if(dy!=-1){
        		dy = 1;
        		dx = 0;
        	}
        }
	}

    public Rectangle getHead() {
		return head;
	}
    
	public Rectangle getHitbox() {
		return hitbox;
	}
    
    public void updateCazzillo(){
    	move();
    }

	public int getX() {
		return head.x;
	}

	public int getY() {
		return head.y;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
	
	public boolean getPause() {
		return pause;
	}
}