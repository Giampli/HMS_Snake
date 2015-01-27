package snake;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
	int scrHeight=300;
	int scrWidth=300;
	private Timer timer;
	Random rand = new Random();
	private Head head;
	public ArrayList<Eat> apples=new ArrayList<Eat>();
	public ArrayList<Tail> tail=new ArrayList<Tail>();
	ImgLoader loader;
	Menu menu;
	Mouse mouse;
	Death death;
	int ST=15, T=ST, SN=10, N=SN,AppleN=5;
	boolean Isinmenu=true;
	boolean IsDeath=false;
	Rectangle gameplane;

	public Board() {
		gameplane=new Rectangle(0,0,296,274);
		mouse=new Mouse();
		addMouseMotionListener(mouse);
    	addMouseListener(mouse);
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		loader=new ImgLoader();
		menu=new Menu();
		death=new Death();
		head= new Head(scrHeight,scrWidth);
		for (int i=0; i<=AppleN; i++){
			apples.add(new Eat(scrHeight,scrWidth));
		}
		timer = new Timer (ST , this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.DARK_GRAY);
		g2d.setFont(new Font("Purisa", Font.BOLD, 13));
		if(!Isinmenu){
			if(!IsDeath){
				g2d.drawImage(loader.getBackground(),0,0,null);
				g2d.drawImage(loader.getSnakeShad()[0],head.getX()+3,head.getY()-3 ,null);
				for(int i=0; i<tail.size();i++){
					g2d.drawImage(loader.getSnakeShad()[1],tail.get(i).getTailSq().x+3,tail.get(i).getTailSq().y-3,null);
				}
				for (int i=0; i<AppleN; i++){
					g2d.drawImage(loader.getFruitsShadow()[apples.get(i).getRandFruit()],apples.get(i).getX()+4,apples.get(i).getY()-4,null);
				}
				for (int i=0; i<AppleN; i++){
					g2d.drawImage(loader.getFruits()[apples.get(i).getRandFruit()],apples.get(i).getX(),apples.get(i).getY(),null);
				}
				for(int i=0; i<tail.size();i++){
					g2d.drawImage(loader.getSnake()[4],tail.get(i).getTailSq().x,tail.get(i).getTailSq().y,null);
				}			
				if(head.getDx()==1||head.getDx()==0&&head.getDy()==0){
					g2d.drawImage(loader.getSnake()[0],head.getX(),head.getY() ,null);
				}
				if(head.getDx()==-1){
					g2d.drawImage(loader.getSnake()[2],head.getX(),head.getY() ,null);
				}
				if(head.getDy()==1){
					g2d.drawImage(loader.getSnake()[1],head.getX(),head.getY() ,null);
				}
				if(head.getDy()==-1){
					g2d.drawImage(loader.getSnake()[3],head.getX(),head.getY() ,null);
				}
			    g2d.drawString("Score: "+tail.size(), 10, 15);
			    
			    if(head.getPause()){
					g2d.drawImage(loader.getPause(),0,-50,null);
			    }
				
			}
			else {
				g2d.setColor(Color.WHITE);
				g2d.setFont(new Font("Purisa", Font.PLAIN, 30));
			    g2d.drawString("Your score was: "+tail.size(), 25, 90);
				if(!death.getRectMouse().intersects(death.getRectRetry()))
					g2d.drawImage(loader.getDeahRetry(),death.getRectRetry().x,death.getRectRetry().y,null);
				else
					g2d.drawImage(loader.getDeahRetryPressed(),death.getRectRetry().x,death.getRectRetry().y,null);
			}
		}
		else{
			g2d.drawImage(loader.getCredits(),menu.getRectCredits().x,menu.getRectCredits().y,null);
			g2d.drawImage(loader.getGameLogo(),menu.getRectGameLogo().x,menu.getRectGameLogo().y,null);
			if(!menu.getRectMouse().intersects(menu.getRectButton()))
				g2d.drawImage(loader.getButton(),menu.getRectButton().x,menu.getRectButton().y,null);
			else
				g2d.drawImage(loader.getButtonPressed(),menu.getRectButton().x,menu.getRectButton().y,null);
			g2d.drawImage(loader.getLogo(),menu.getRectLogo().x,menu.getRectLogo().y,null);
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	
	public void actionPerformed(ActionEvent e) {
		if(!Isinmenu){
			if(!IsDeath){
				if(!head.getPause()){
					head.updateCazzillo();
					for(int i=0; i<tail.size();i++)
						tail.get(i).updateTail(head.getDx(), head.getDy());
					for(int i=0; i<tail.size();i++)
						if(head.getHitbox().intersects(tail.get(i).getTailSq2())&&tail.get(i).getJ()>10*tail.size()+10){
							IsDeath=true;
						}
					for (int i=0; i<AppleN; i++)
						if (head.getHead().intersects(apples.get(i).getPoint())){
							apples.remove(i);
							apples.add(new Eat(scrHeight,scrWidth));
							tail.add(tail.size(), new Tail(head.getX(),head.getY(),head.getDx(),head.getDy(),tail.size()));
						}
					if (!head.getHead().intersects(gameplane))
						IsDeath=true;
				}
				if (tail.size()==N){
					updateDif();
				}
			}
			else{
				death.updateMouse(mouse.getX(), mouse.getY());
				if(mouse.Click()){
					if(death.getRectMouse().intersects(death.getRectRetry())){
						reset();
					}
				}
			}
		}
		else{
			menu.updateMouse(mouse.getX(), mouse.getY());
			if(mouse.Click()){
				System.out.println("mouse clicked.");
				if(menu.getRectMouse().intersects(menu.getRectButton())){
					Isinmenu=false;				
				}
			}
		}
		repaint();
	}
	
	void reset(){
		Isinmenu=false;
		IsDeath=false;
		N=SN;
		T=ST;
		timer.stop();
		timer = new Timer (T, this);
		timer.start();
		apples.clear();
		tail.clear();
		head= new Head(scrHeight,scrWidth);
		for (int i=0; i<=AppleN; i++){
			apples.add(new Eat(scrHeight,scrWidth));
		}
	}
	
	void updateDif(){
		N+=SN;
		if(T>2)
			T--;
		timer.stop();
		timer = new Timer (T , this);
		timer.start();
	}

	private class TAdapter extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			head.keyPressed(e);
		}
	}
}