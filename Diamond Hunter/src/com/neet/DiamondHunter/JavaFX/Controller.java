package com.neet.DiamondHunter.JavaFX;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import com.neet.DiamondHunter.Main.Game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    //map create
    private Map maps;

    @FXML
    void initialize() {
    	maps = new Map();
    	maps.drawMap(canvas);
    	runGame.setOnAction((event) ->{
    		Game.Run();
    	});
    	
    }
    
    
    
}
