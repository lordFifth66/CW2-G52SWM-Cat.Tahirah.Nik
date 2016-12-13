package com.neet.DiamondHunter.JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import com.neet.DiamondHunter.Main.Game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
//this class contains Controller for JavaFX
public class Controller {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button runGame;

    @FXML
    void initialize() {
    	runGame.setOnAction((event) ->{
    		Game.Run();
    	});
    }
}
