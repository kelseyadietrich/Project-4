package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GuiMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GuiMain.class.getResource("Start.fxml"));
		Pane root = (Pane) loader.load();

		Scene scene = new Scene(root, 455, 475);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}
