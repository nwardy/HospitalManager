package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	  public void start(Stage primaryStage) throws Exception {
	        // Load the FXML for the login page
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
	        Parent root = loader.load();

	        // Set the login stage for the controller
	        Controller loginController = loader.getController();
	        loginController.setLoginStage(primaryStage);

	        primaryStage.setTitle("Login");
	        primaryStage.setScene(new Scene(root, 500, 400));
	        primaryStage.show();
	        primaryStage.setResizable(false);
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}