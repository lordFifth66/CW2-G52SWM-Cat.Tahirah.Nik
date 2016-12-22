package com.neet.DiamondHunter.Main;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class defLaunch extends Application
{
	
	BorderPane mainPane;
	Button btn1, btn2;
	Label launchLabel;
	Scene launchScene;
	Stage stage;
	HBox hb;
	
	
	
	
	public static void main(String[] args) {

		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)  
	{
		stage = primaryStage;
		
		//label for launcher
		launchLabel = new Label("Launcher");
		launchLabel.setStyle("-fx-font: 20px Tahoma; -fx-padding: 10; -fx-alignment: CENTER; -fx-text-fill: white");
		
		//create 2 buttons
		btn1 = new Button("View Map");
		btn2 = new Button("Launch Game");
		
		btn1.setStyle("-fx-font: 15px Tahoma; -fx-padding: 10");
		btn2.setStyle("-fx-font: 15px Tahoma; -fx-padding: 10");
		
		btn1.setMaxWidth(Double.MAX_VALUE);
		btn2.setMaxWidth(Double.MAX_VALUE);
		
		//define the event when each button is clicked
		btn1.setOnAction(e-> {
			try {
				mapViewer();
				
				Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setTitle("Diamond Hunter Map Viewer");
	    		alert.setHeaderText("Welcome to Diamond Hunter Map Viewer!");
	    		alert.setContentText("Choose an item and click at the map to change their location");
	    		alert.showAndWait();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btn2.setOnAction(e-> launchGame());
		
		//create a new horizontal box containing the two buttons
		hb = new HBox();
		hb.getChildren().addAll(btn1, btn2);
		hb.setSpacing(70);
	    hb.setPadding(new Insets(0, 20, 10, 20));
	    hb.setAlignment(Pos.CENTER);
		
	    //creating the root pane for the launcher
		mainPane = new BorderPane();
		mainPane.setTop(launchLabel);
		mainPane.setBottom(hb);
		mainPane.setStyle("-fx-background-color: gray;-fx-padding: 20px;");
		
		//aligning the label in the pane
		BorderPane.setAlignment(launchLabel, Pos.TOP_CENTER );
		
		
		
		launchScene = new Scene(mainPane, 450, 150);
	     
	    primaryStage.setTitle("Diamond Hunter Launcher");
	    primaryStage.setScene(launchScene);
	    primaryStage.setResizable(false);
	    primaryStage.show();
				
		
	}
	
	public void mapViewer() throws Exception
	{
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../JavaFX/Gui.fxml"));
        stage.setTitle("Map Viewer");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
	
	public static void launchGame()
	{
		JFrame window = new JFrame("Diamond Hunter");
		
		window.add(new GamePanel());
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
