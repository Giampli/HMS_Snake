package snake;

import java.awt.Rectangle;
import java.util.Random;

public class Eat {

	int x;
    int y;
    int n;
	Random rand = new Random();
	Rectangle point;
    
    Eat (int scrHeight, int scrWidth){
    	x=rand.nextInt(scrHeight-20);
    	y=rand.nextInt(scrHeight-40);
    	point=new Rectangle(x,y,10,10);
    	n=rand.nextInt(8);
    }
    
	int getRandFruit(){
		return n;
	}
	
    
    public Rectangle getPoint() {
		return point;
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
}
