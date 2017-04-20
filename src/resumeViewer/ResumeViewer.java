package resumeViewer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ResumeViewer {
	private WebView browser;
	private WebEngine webEngine;
	
	
	public ResumeViewer(){
		this.browser = new WebView();
		this.webEngine = browser.getEngine();
	}
	
	
	
	
	public void DisplayContentsOf(String filelocation){
		Stage webStage = new Stage();
		webStage.setWidth(400);
		webStage.setHeight(500);
		
		Scene scene = new Scene(new Group());
		ScrollPane scrollPane = new ScrollPane();
	    scrollPane.setContent(this.browser);
	    
	    String url = ResumeViewer.class.getResource(filelocation).toExternalForm();
	    webEngine.load(url);

	    scene.setRoot(scrollPane);

	    webStage.setScene(scene);
	    webStage.show();
	} 

}
