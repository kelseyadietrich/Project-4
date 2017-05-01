package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartController {
	@FXML
	Button update;
	@FXML
	Button create;

	@FXML
	public void initialize(){}

	@FXML
	public void createDB(){
		
		openResumeAdd();
	}

	@FXML
	public void openResumeAdd(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GuiMain.class.getResource("ResumeAdd.fxml"));
			Pane root = (Pane) loader.load();

			Stage secondStage = new Stage();
			Scene scene = new Scene(root);
			secondStage.setScene(scene);
			secondStage.show();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
