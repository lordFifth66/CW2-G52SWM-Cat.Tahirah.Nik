package com.neet.DiamondHunter.JavaFX;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ResourceBundle;

import com.neet.DiamondHunter.Main.Game;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

//this class contains Controller for JavaFX
public class Controller {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button runGame;
    
    @FXML
    private Canvas canvas;
    
    @FXML
    private Label xCoordinate;

    @FXML
    private Label yCoordinate;
    //create map
    private Map maps;
    private Objects items;
    
    private int xlocation;
    private int ylocation;
    
    //item coordinate
    public static int itemStatus;


    @FXML
    void initialize() {
    	
    	GraphicsContext gc = canvas.getGraphicsContext2D();    	
    	maps = new Map(16);
    	maps.loadMap();
    	maps.draw(gc);
    	
    	items = new Objects(16);
    	items.loadItem();
    	
    	drawItem(gc);
    	
    	itemStatus = 0;
    	
    	canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
    		public void handle (MouseEvent mouseEvent) {
    				
    				xlocation = (int) (mouseEvent.getX() / 16);
    				ylocation = (int) (mouseEvent.getY() / 16);
    				xCoordinate.setText(Integer.toString(xlocation));
    				yCoordinate.setText(Integer.toString(ylocation));
    			}
    		});
    	
    	canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		public void handle (MouseEvent mouseEvent) {
    			
    				if (checkTiles(xlocation, ylocation))
    				{
    					if (itemStatus == 0)
    					{
    						Objects.axeX = (int)(mouseEvent.getX() / 16);
    						Objects.axeY = (int)(mouseEvent.getY() / 16);
    					}
    					else
    					{
    						Objects.boatX = (int)(mouseEvent.getX() / 16);
    						Objects.boatY = (int)(mouseEvent.getY() / 16);	
    					}
    					drawItem(gc);    					
    				}
    			}
    		});
    	
    	runGame.setOnAction((event) -> {
    		Game.Run();
    	});
    }
    
    private boolean checkTiles(int x, int y)
    {
    	if(maps.map[y][x] < 20)
    		return true;     		
    	else
    		return false;    		
    }
    
    private void drawItem(GraphicsContext gc)
    {
		maps.draw(gc);
		items.draw(gc);
    }
    
}
