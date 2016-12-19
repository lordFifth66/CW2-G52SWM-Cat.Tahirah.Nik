package com.neet.DiamondHunter.JavaFX;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ResourceBundle;

import com.neet.DiamondHunter.Main.Game;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//this class contains Controller for JavaFX
public class Controller {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button runGame;
    
    @FXML
    private Button axebutton;
    
    @FXML
    private Button boatbutton;
    
    @FXML
    private Canvas canvas;
    
    @FXML
    private Label xCoordinate;

    @FXML
    private Label yCoordinate;
    
    @FXML
    private Label axeFieldX;
 
    @FXML 
    private Label axeFieldY;
 
    @FXML
    private Label boatFieldX;

    @FXML 
    private Label boatFieldY;

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
    	//load map
    	maps = new Map(16);
    	maps.loadMap();
    	maps.draw(gc);
    	
    	//load item
    	items = new Objects(16);
    	items.loadItem();
    	
    	draw(gc);
    	
    	// default itemStatus
    	itemStatus = 2;
    	
    	//axe if 0, else boat
    	axebutton.setOnAction((event) -> {
    		// Change Axe Position if clicked, itemStatus initialized to 0
    		itemStatus = 0;  
    		
    		// set CSS style (background color) for axeFieldX, axeFieldY, boatFieldX, boatFieldY
    		axeFieldX.setStyle("-fx-background-color: tan");
    		axeFieldY.setStyle("-fx-background-color: tan");
    		boatFieldX.setStyle(null);
    		boatFieldY.setStyle(null);
    	});
    	
    	boatbutton.setOnAction((event) -> {
    		// Change Boat Position if clicked, itemStatus initialized to 1
    		itemStatus = 1;
    		
    		// set CSS style (background color) for axeFieldX, axeFieldY, boatFieldX, boatFieldY
    		boatFieldX.setStyle("-fx-background-color: tan");
    		boatFieldY.setStyle("-fx-background-color: tan");
    		axeFieldX.setStyle(null);
    		axeFieldY.setStyle(null);
    	});
    	
    	
    	
    	//get x and y coordinate when mouse hover on the map
    	canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
    		public void handle (MouseEvent mouseEvent) {
    				
    				xlocation = (int) (mouseEvent.getX() / 16);
    				ylocation = (int) (mouseEvent.getY() / 16);
    				xCoordinate.setText(Integer.toString(xlocation));
    				yCoordinate.setText(Integer.toString(ylocation));
    			}
    		});
    	
    	//change the item coordinate when click on the map
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
    						if (itemStatus == 1)
    						{
    							Objects.boatX = (int)(mouseEvent.getX() / 16);
    							Objects.boatY = (int)(mouseEvent.getY() / 16);	
    						}
    						else
    						{
        						Alert alert = new Alert(AlertType.WARNING);
            					alert.setTitle("Warning");
            					alert.setHeaderText("No item is chosen");
            					alert.setContentText("Please choose one item to change its position in map.");
            					alert.showAndWait();
        					}
    					}
    					
    					draw(gc);    					
    				}
    				else
    				{
    					//warning if try to put item at tree/lake..
    					Alert alert = new Alert(AlertType.ERROR);
    					alert.setTitle("Error");
    					
    					
    					if(itemStatus == 0)
    					{
    						alert.setHeaderText("Invalid Axe Location!");
        					alert.setContentText("The valid location for AXE is neither on any tree-like tile nor any blue-coloured tile (Make sure to position the AXE where you can possbily reach them).  ");
    					}
    					
    					else
    					{
    						alert.setHeaderText("Invalid Boat Location!");
        					alert.setContentText("The valid location for BOAT is neither on any tree-like tile nor any blue-coloured tile (Make sure to position the BOAT where you can possbily reach them). ");
    					}
    					
    					alert.showAndWait();
    				}
    			}
    		});
    	
    	runGame.setOnAction((event) -> {
    		if (checkTiles(Objects.axeX, Objects.axeY) && 
    				checkTiles(Objects.boatX, Objects.boatY))
    		{
    			Stage currentStage = (Stage)runGame.getScene().getWindow();
    			currentStage.close();
    			Game.Run();    		
    		}
    	});
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Diamond Hunter Map Viewer");
    		alert.setHeaderText("Welcome to Diamond Hunter Map Viewer!");
    		alert.setContentText("afasafasfdasgsfgfdsgdfgsf");
    		alert.showAndWait();
    }
    
    //check the tile's type
    private boolean checkTiles(int x, int y)
    {
    	if(maps.map[y][x] < 20)
    		return true;     		
    	else
    		return false;    		
    }
    
    //draw the map
    private void draw(GraphicsContext gc)
    {
		maps.draw(gc);
		items.draw(gc);

	    axeFieldX.setText(Integer.toString(Objects.axeX));
	    axeFieldY.setText(Integer.toString(Objects.axeY));
	    boatFieldX.setText(Integer.toString(Objects.boatX));
	    boatFieldY.setText(Integer.toString(Objects.boatY));
	 
    }
    
}
