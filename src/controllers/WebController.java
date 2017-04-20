package controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import resume.DocHandler;

import java.io.IOException;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WebController {
	
	@FXML WebView view;
	
	DocHandler reader;

	@FXML
	void initialize() {
			reader = new DocHandler();
		    try {
				String toSend = reader.read();
				 WebEngine webEngine = view.getEngine();
				 webEngine.loadContent(toSend);
				 view.setVisible(true);
				 Scene scene = new Scene(view);
				 
					try {
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(GuiMain.class.getResource("WebView.fxml"));
						Pane root = (Pane) loader.load();

						Stage webber = new Stage();
						webber.setScene(scene);
						webber.show();
					} catch (Exception exc) {
						exc.printStackTrace();
					}
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  WebEngine webEngine = view.getEngine();
		   
		  //browser = new WebView();
		  //webEngine = browser.getEngine();
		 // webEngine.loadContent(HTML_TO_SEND);

		  //browser.setVisible(true);
		 // Scene scene = new Scene(browser);
		 //   jfxPanel.setScene(scene);


		   
		
	}

}
