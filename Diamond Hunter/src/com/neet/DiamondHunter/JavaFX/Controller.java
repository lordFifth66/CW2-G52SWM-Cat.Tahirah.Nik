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
    //map create
    private Map maps;
    
    private int xlocation;
    private int ylocation;

    @FXML
    void initialize() {
    	
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	maps = new Map(16);
    	maps.loadMap();
    	maps.draw(gc);
    	
    	

    	canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
    		public void handle (MouseEvent mouseEvent) {
    				
    				xlocation = (int) (mouseEvent.getX() / 16);
    				ylocation = (int) (mouseEvent.getY() / 16);
    				xCoordinate.setText(Integer.toString(xlocation));
    				yCoordinate.setText(Integer.toString(ylocation));
    			}
    		});
    	runGame.setOnAction((event) ->{
    		Game.Run();
    	});
    	
    }
    
    
    
}
