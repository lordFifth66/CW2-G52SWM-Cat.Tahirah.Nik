package com.neet.DiamondHunter.JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Gui.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Map Viewer");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Diamond Hunter Map Viewer");
    		alert.setHeaderText("Welcome to Diamond Hunter Map Viewer!");
    		alert.setContentText("Choose an item and click at the map to change their location");
    		alert.showAndWait();
    		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
