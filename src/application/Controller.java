package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    @FXML
    private TextField userIDField;
    @FXML
    private PasswordField passwordField;

    private Stage loginStage; 

 
    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    public void Login(ActionEvent e) {
        
    	//hashmap used for testing will include secure database in future development
        Map<String, String> acceptableUsers = new HashMap<>(); 
        acceptableUsers.put("nate", "wardy");
        acceptableUsers.put("Password", "User");
        acceptableUsers.put("noah", "wardy");

     
        String enteredUserID = userIDField.getText();
        String enteredPassword = passwordField.getText();

       
        if (acceptableUsers.containsKey(enteredUserID) && acceptableUsers.get(enteredUserID).equals(enteredPassword)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hub.fxml"));
                Parent dashboardRoot = loader.load();
                HubController hubController = loader.getController();
                hubController.setHubStage(loginStage); 
                Scene dashboardScene = new Scene(dashboardRoot, 850, 620);
                loginStage.setTitle("Dashboard"); 
                
               String css = this.getClass().getResource("application.css").toExternalForm();
               dashboardScene.getStylesheets().add(css);
                
                loginStage.setScene(dashboardScene); 
                loginStage.setWidth(850);
                loginStage.setHeight(620);
                loginStage.setResizable(false);
                
               
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Credentials");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Credentials"); 
            alert.showAndWait();
        }
    }
    public void openHub() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Hub.fxml")); 
        Parent root = loader.load();
        
        HubController hubController = loader.getController();
        hubController.setHubStage(loginStage);

        loginStage.setScene(new Scene(root, 850, 620));
        loginStage.setTitle("Hub");
        loginStage.setResizable(false);
    }
}
    