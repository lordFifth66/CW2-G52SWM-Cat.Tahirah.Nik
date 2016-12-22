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
//import javax.swing.*;

public class defLaunch extends Application
{
	
	Button btn1, btn2;
	Label launchLabel;
	//FlowPane fp1;
	BorderPane mainPane;
	HBox hb;
	Stage stage;
	Scene launchScene;
	
	
	public static void main(String[] args) {

		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)  
	{
		stage = primaryStage;
		
		launchLabel = new Label("Launcher");
		launchLabel.setStyle("-fx-font: 20px Tahoma; -fx-padding: 10; -fx-alignment: CENTER; -fx-text-fill: white");
		
		btn1 = new Button("View Map");
		btn2 = new Button("Launch Game");
		
		
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
		
		hb = new HBox();
		hb.getChildren().addAll(btn1, btn2);
		hb.setSpacing(70);
	    hb.setPadding(new Insets(20));
	    hb.setAlignment(Pos.CENTER);
		
		mainPane = new BorderPane();
		
		mainPane.setTop(launchLabel);
		mainPane.setBottom(hb);
		mainPane.setStyle("-fx-background-color: gray;-fx-padding: 20px;");
		
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
        Scene scene = new Scene(root,878,751);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
	
	public void launchGame()
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
