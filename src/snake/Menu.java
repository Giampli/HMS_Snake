package snake;

import java.awt.Point;
import java.awt.Rectangle;

public class Menu {
    Rectangle rectCredits;
	Point credits;
    Rectangle rectButton;
	Point button;
	Rectangle rectGameLogo;
	Point gameLogo;
	Rectangle rectLogo;
	Point logo;
	Rectangle mouse;
	
	Menu(){
		credits=new Point (178,106);
		rectCredits=new Rectangle(credits.x,credits.y,88,35);
		button=new Point (86,165);
		rectButton= new Rectangle(button.x,button.y,128,64);
		gameLogo=new Point (34,38);
		rectGameLogo= new Rectangle(gameLogo.x,gameLogo.y,232,67);
		logo=new Point (231,208);
		rectLogo= new Rectangle(logo.x,logo.y,64,64);
		mouse=new Rectangle(0,0,3,3);
	}
	
	public void updateMouse(int x,int y){
		mouse.x=x;
		mouse.y=y;
	}
	
	public Rectangle getRectMouse() {
		return mouse;
	}	
	
	public Rectangle getRectButton() {
		return rectButton;
	}

	public Rectangle getRectGameLogo() {
		return rectGameLogo;
	}
	
	public Rectangle getRectLogo() {
		return rectLogo;
	}
	
	public Rectangle getRectCredits() {
		return rectCredits;
	}

}
