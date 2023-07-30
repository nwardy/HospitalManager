package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage InitatStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene = new Scene(root,525,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			InitatStage.setResizable(false); 
			InitatStage.setScene(scene);
			InitatStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
