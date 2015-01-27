package snake;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;


class Mouse implements MouseInputListener {

	private int mx;
	private int my;
	private boolean click;

	public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
    }

    public int getX() {
        return mx;
    }
    
    public int getY() {
        return my;
    }
    
    public boolean Click(){
    	return click;
    }
    
	public void mousePressed(MouseEvent e) {
		click=true;
	}
	
	public void mouseReleased(MouseEvent e) {
		click=false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
    @Override	//azioni non implementate
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
}

