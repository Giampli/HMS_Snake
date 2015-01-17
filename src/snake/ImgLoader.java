package snake;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgLoader {
	int width = 10;
	int height = 10;
	int rows = 1;
	int cols = 5;
	BufferedImage[] spritesBase;
	BufferedImage[] spritesFruit;
	BufferedImage bigImg;
	BufferedImage logo;
	BufferedImage gameLogo;
	BufferedImage credits;
	BufferedImage buttonPressed;
	BufferedImage button;
	BufferedImage deathRetry;
	BufferedImage background;
	BufferedImage pause;

	public ImgLoader(){
	System.out.println(getClass());
	spritesBase = new BufferedImage[rows * cols];
	spritesFruit=new BufferedImage[3 * 3];
	load();
	}
	void load(){
		try {
			deathRetry=ImageIO.read(getClass().getResource("/img/retry_button.png"));
			button=ImageIO.read(getClass().getResource("/img/start_button.png"));
			buttonPressed=ImageIO.read(getClass().getResource("/img/pressed_button.png"));
			gameLogo=ImageIO.read(getClass().getResource("/img/gameLogo.png"));
			logo=ImageIO.read(getClass().getResource("/img/logo.png"));
			credits=ImageIO.read(getClass().getResource("/img/credits.png"));
			background = ImageIO.read(getClass().getResource("/img/background.png"));
			pause = ImageIO.read(getClass().getResource("/img/pauseoverlay.png"));
			bigImg = ImageIO.read(getClass().getResource("/img/Snake_head_body.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        spritesBase[(i * cols) + j] = bigImg.getSubimage(
		            j * width,
		            i * height,
		            width,
		            height
		        );
		    }
		}
		width = 10;
		height = 10;
		rows = 3;
		cols = 3;
		try {
			bigImg = ImageIO.read(getClass().getResource("/img/Snake_fruits.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        spritesFruit[(i * cols) + j] = bigImg.getSubimage(j * width, i * height, width,height);
		    }
		}
		
	}
	
	public BufferedImage getBackground() {
		return background;
	}
	public BufferedImage getPause() {
		return pause;
	}
	public BufferedImage getLogo() {
		return logo;
	}
	public BufferedImage getDeahRetry() {
		return deathRetry;
	}
	public BufferedImage getGameLogo() {
		return gameLogo;
	}
	public BufferedImage getCredits() {
		return credits;
	}
	public BufferedImage getButtonPressed() {
		return buttonPressed;
	}
	public BufferedImage getButton() {
		return button;
	}
	public BufferedImage[] getSnake() {
		return spritesBase;
	}
	
	public BufferedImage[] getFruits() {
		return spritesFruit;
	}
}
