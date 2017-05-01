package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import database.CVDataBase;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resume.User;

public class StartController {
	@FXML
	Button update;
	@FXML
	Button create;
	@FXML
	ListView resumes;

	
	@FXML
	public void initialize(){
		CVDataBase data = new CVDataBase();
		try {
			ArrayList<User> names = data.getPersonalData();
			if (names != null) {
				resumes.setItems(FXCollections.observableList(names));
			}
		} catch (Exception e) {
			System.out.println("Could not start listview!");
			e.printStackTrace();
		}
	}

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
