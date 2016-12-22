package com.neet.DiamondHunter.JavaFX;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class Objects {

	private Image axe;
	private Image boat;
	
	//coordinate for boat and axe
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
	
	//to get image of axe
	public ImageView getAxe(int size)
	{
		ImageView axeImage = new ImageView(axe);
		axeImage.setFitHeight(size);
		axeImage.setFitWidth(size);
		
		return axeImage;
	}
	
	//to get image of boat
	public ImageView getBoat(int size)
	{
		ImageView boatImage = new ImageView(boat);
		boatImage.setFitHeight(size);
		boatImage.setFitWidth(size);
		
		return boatImage;
	}
}
