package resumeViewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExampleMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ExampleMain.class.getResource("LaunchResumeExample.fxml"));
		AnchorPane root = (AnchorPane) loader.load();

		Scene scene = new Scene(root, 507, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}
