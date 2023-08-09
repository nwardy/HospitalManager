package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
     
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();
        
        String css = this.getClass().getResource("application.css").toExternalForm();
        root.getStylesheets().add(css);
        
        Controller loginController = loader.getController();
        loginController.setLoginStage(primaryStage);

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
