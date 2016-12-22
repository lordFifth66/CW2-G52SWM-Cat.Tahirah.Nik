package com.neet.DiamondHunter.Main;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
		
		hb = new HBox(btn1, btn2);
		hb.setSpacing(100);
	    hb.setPadding(new Insets(20));
		
		mainPane = new BorderPane();
		
		mainPane.setTop(launchLabel);
		mainPane.setBottom(hb);
		
		BorderPane.setAlignment(launchLabel, Pos.TOP_CENTER );
		BorderPane.setAlignment(hb, Pos.CENTER );
		
		
		
		mainPane.setStyle("-fx-background-color: gray;-fx-padding: 20px;");
		
	     //make pane
	     /*fp1 = new FlowPane();
	     
	     HBox hb1 = new HBox(btn1, btn2);
	     hb1.setSpacing(10);
	     hb1.setPadding(new Insets(20));
	     
	     //set background color of each Pane
	     fp1.setStyle("-fx-background-color: gray;-fx-padding: 10px;");
	     
	     fp1.getChildren().add(launchLabel);
	     fp1.getChildren().add(hb1);
	     
	     
	     launchScene = new Scene(fp1, 450, 200);*/
		
		 launchScene = new Scene(mainPane, 450, 200);
	     
	     primaryStage.setTitle("Hello World!");
	     primaryStage.setScene(launchScene);
	     primaryStage.setResizable(false);
	     primaryStage.show();
				
		
	}
	
	public void mapViewer() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Gui.fxml"));
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
