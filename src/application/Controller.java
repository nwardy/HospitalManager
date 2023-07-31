package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    @FXML
    private TextField userIDField;
    @FXML
    private TextField passwordField;

    private Stage loginStage; // Reference to the login stage

    // Setter method to set the login stage
    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    public void Login(ActionEvent e) {
        // Define the map of acceptable usernames and passwords
        Map<String, String> acceptableUsers = new HashMap<>();
        acceptableUsers.put("nate", "wardy");
        acceptableUsers.put("Password", "User");
        acceptableUsers.put("noah", "wardy");
        
        // Retrieve the input from the text fields
        String enteredUserID = userIDField.getText();
        String enteredPassword = passwordField.getText();

        // Check if the entered UserID and Password match the preset strings
        if (acceptableUsers.containsKey(enteredUserID) && acceptableUsers.get(enteredUserID).equals(enteredPassword)) {
            try {
                // Load the FXML file for the dashboard window
                Parent dashboardRoot = FXMLLoader.load(getClass().getResource("/hub.fxml"));
                Scene dashboardScene = new Scene(dashboardRoot, 390, 330);

                // Create a new stage for the dashboard window
                Stage dashboardStage = new Stage();
                dashboardStage.setTitle("Dashboard");
                dashboardStage.setScene(dashboardScene);

                // Show the dashboard window
                dashboardStage.show();
                dashboardStage.setWidth(850);
                dashboardStage.setHeight(620);
                dashboardStage.setResizable(false);
             
                // Close the login stage
                loginStage.close();
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
	

	}



