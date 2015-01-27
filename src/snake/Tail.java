package snake;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Tail {
	Rectangle tailSq;
	Rectangle tailSq2;
	int Number=0, x=0, y=0, j=0;
	ArrayList<Integer> oldDx;
	ArrayList<Integer> oldDy;

	 Tail(int Hx,int Hy,int Dx,int Dy, int n){
		 oldDx= new ArrayList<Integer>();
		 oldDy= new ArrayList<Integer>();
		 Number=n;
		 tailSq = new Rectangle(Hx,Hy,8,8);
		 tailSq2=new Rectangle(tailSq.x+3,tailSq.y+3,3,3);
	 }


	void updateTail(int Dx,int Dy){
		 if(j>=8*Number+9){
			 tailSq.x+=oldDx.get(0);
			 tailSq.y+=oldDy.get(0);
			 tailSq2.x+=oldDx.get(0);
			 tailSq2.y+=oldDy.get(0);
			 oldDx.remove(0);
			 oldDy.remove(0);
			 oldDx.add(oldDx.size(), Dx);
			 oldDy.add(oldDy.size(), Dy);
			j++;
		 }
		 else{
			 oldDx.add(j, Dx);
			 oldDy.add(j, Dy);
			 j++;
		 	}
		 
	 }

	public Rectangle getTailSq2() {
		return tailSq2;
	}

	public Rectangle getTailSq() {
		return tailSq;
	}
	 
	 public int getJ() {
		return j;
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
}
