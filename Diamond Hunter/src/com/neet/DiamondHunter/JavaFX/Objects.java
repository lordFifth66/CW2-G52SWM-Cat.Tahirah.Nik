package com.neet.DiamondHunter.JavaFX;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Objects {

	private Image axe;
	private Image boat;
	
    public static int axeX;
    public static int axeY;
    public static int boatX;
    public static int boatY;
    
	private int itemSize;
	
	public Objects(int itemSize)
	{
		this.itemSize = itemSize;
		
		axeX = 37;
    	axeY = 26;
    	boatX = 4;
    	boatY = 12;
	}
	
	public void loadItem()
	{
		Image itemList = new Image("/Sprites/items.gif");
		axe = new WritableImage(itemList.getPixelReader(),
				itemSize,
				itemSize,
				itemSize,
				itemSize
				);
		boat = new WritableImage(itemList.getPixelReader(),
				0,
				itemSize,
				itemSize,
				itemSize
				); 
	}
	
	public void draw(GraphicsContext gc)
	{

		gc.drawImage(axe, axeX * 16, axeY * 16);
		gc.drawImage(boat, boatX * 16, boatY * 16);
	}
}
