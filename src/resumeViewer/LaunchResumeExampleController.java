package resumeViewer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LaunchResumeExampleController {
	
	@FXML
	Button launch;
	
	
	
	
	@FXML
	void initialize(){
		ResumeViewer myViewer = new ResumeViewer();
		launch.setOnAction(event -> {
			myViewer.DisplayContentsOf("src/HTML.html");
		});
		
	}

}
