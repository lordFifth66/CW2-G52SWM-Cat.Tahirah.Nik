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
	private int oriItemSize;
	
	public Objects()
	{
		oriItemSize = 16;
		axeX = 37;
    	axeY = 26;
    	boatX = 4;
    	boatY = 12;
	}
	

	public void loadItem(int itemSize)
	{
		this.itemSize = itemSize;
		Image itemList = new Image("/Sprites/items.gif");
		axe = new WritableImage(itemList.getPixelReader(),
				oriItemSize,
				oriItemSize,
				oriItemSize,
				oriItemSize
				);
		boat = new WritableImage(itemList.getPixelReader(),
				0,
				oriItemSize,
				oriItemSize,
				oriItemSize
				); 
	}
	
	public void draw(GraphicsContext gc)
	{
		gc.drawImage(axe, axeX * itemSize, axeY * itemSize, itemSize, itemSize);
		gc.drawImage(boat, boatX * itemSize, boatY * itemSize, itemSize, itemSize);
	}
	
	public ImageView getAxe(int size)
	{
		ImageView axeImage = new ImageView(axe);
		axeImage.setFitHeight(size);
		axeImage.setFitWidth(size);
		
		return axeImage;
	}
	
	public ImageView getBoat(int size)
	{
		ImageView boatImage = new ImageView(boat);
		boatImage.setFitHeight(size);
		boatImage.setFitWidth(size);
		
		return boatImage;
	}
}
