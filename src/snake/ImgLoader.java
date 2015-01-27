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
	BufferedImage[] spritesBaseShad;
	BufferedImage[] spritesFruit;
	BufferedImage[] spritesFruitShadow;
	BufferedImage bigImg;
	BufferedImage deathRetryPressed;
	BufferedImage logo;
	BufferedImage logoPressed;
	BufferedImage gameLogo;
	BufferedImage credits;
	BufferedImage buttonPressed;
	BufferedImage button;
	BufferedImage deathRetry;
	BufferedImage background;
	BufferedImage pause;

	public ImgLoader(){
	spritesBase = new BufferedImage[rows * cols];
	spritesBaseShad = new BufferedImage[rows * 2];
	spritesFruit=new BufferedImage[3 * 3];
	spritesFruitShadow=new BufferedImage[3 * 3];	
	load();
	}
	void load(){
		try {
			deathRetry=ImageIO.read(getClass().getResource("/img/retry_button.png"));
			deathRetryPressed=ImageIO.read(getClass().getResource("/img/retry_button_pressed.png"));
			button=ImageIO.read(getClass().getResource("/img/start_button.png"));
			buttonPressed=ImageIO.read(getClass().getResource("/img/pressed_button.png"));
			gameLogo=ImageIO.read(getClass().getResource("/img/gameLogo.png"));
			logo=ImageIO.read(getClass().getResource("/img/logo.png"));
			logoPressed=ImageIO.read(getClass().getResource("/img/logoPressed.png"));
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
		        spritesBase[(i * cols) + j] = bigImg.getSubimage(j * width,i * height,width,height);
		    }
		}
		try {
		width = 10;
		height = 10;
		rows=1;
		cols=2;
		bigImg = ImageIO.read(getClass().getResource("/img/Snake_head_body_shadow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        spritesBaseShad[(i * cols) + j] = bigImg.getSubimage(j * width,i * height,width,height);
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
		try {
			bigImg = ImageIO.read(getClass().getResource("/img/Snake_fruits_shadow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		    	spritesFruitShadow[(i * cols) + j] = bigImg.getSubimage(j * width, i * height, width,height);
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
	public BufferedImage getLogoPressed() {
		return logoPressed;
	}
	public BufferedImage getDeahRetry() {
		return deathRetry;
	}
	public BufferedImage getDeahRetryPressed() {
		return deathRetryPressed;
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
	public BufferedImage[] getSnakeShad() {
		return spritesBaseShad;
	}
	public BufferedImage[] getFruits() {
		return spritesFruit;
	}
	public BufferedImage[] getFruitsShadow() {
		return spritesFruitShadow;
	}
}
