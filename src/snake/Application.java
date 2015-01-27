package snake;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Application extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Application() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\logo.png"));
        add(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Gestione dell finestra di gioco
        setSize(300, 300);
        setLocationRelativeTo(null);
        setTitle("Snake");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args)	 {
    	new Application();
    }
}
