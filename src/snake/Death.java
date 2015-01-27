package snake;

import java.awt.Point;
import java.awt.Rectangle;

public class Death {
    Rectangle rectRetry;
	Point retry;
	Rectangle mouse;

	Death(){
	retry=new Point (25,145);
	rectRetry= new Rectangle(retry.x,retry.y,248,64);
	mouse=new Rectangle (0,0,3,3);
	}
	
	public void updateMouse(int x,int y){
		mouse.x=x;
		mouse.y=y;
	}
	
	public Rectangle getRectMouse() {
		return mouse;
	}	
	
	public Rectangle getRectRetry() {
		return rectRetry;
	}

}
