// The entry point of the application.
// This class loads the fxml gui file containing the map viewer

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
			//load css file
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Map Viewer");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			//Welcome alert dialog box and instructions how to use the map
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Diamond Hunter Map Viewer");
    		alert.setHeaderText("Welcome to Diamond Hunter Map Viewer!");
    		alert.setContentText("Choose an item - Axe or Boat\nClick on the map to change their positions.\n\nWarning sign may appear if the position you\nclicked leads to the game never ending.\n\n You wouldn't want to do that xD .");
    		alert.showAndWait();
    		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
