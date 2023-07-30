package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField userIDField;
    @FXML
    private TextField passwordField; 

    public void Login(ActionEvent e) {
        // Define the preset strings that are required to open the new dashboard window
        String requiredUserID = "nate";
        String requiredPassword = "wardy";

        // Retrieve the input from the text fields
        String enteredUserID = userIDField.getText();
        String enteredPassword = passwordField.getText();

        // Check if the entered UserID and Password match the preset strings
        if (requiredUserID.equals(enteredUserID) && requiredPassword.equals(enteredPassword)) {
            try {
                // Load the FXML file for the dashboard window
                Parent dashboardRoot = FXMLLoader.load(getClass().getResource("/hub.fxml"));
                Scene dashboardScene = new Scene(dashboardRoot, 600, 400);

                // Create a new stage for the dashboard window
                Stage dashboardStage = new Stage();
                dashboardStage.setTitle("Dashboard");
                dashboardStage.setScene(dashboardScene);

                // Show the dashboard window
                dashboardStage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // Handle the case when the preset strings do not match the entered text
            System.out.println("Invalid UserID or Password. Please try again.");
            // You can display an error message in the existing FXML, show a popup, or handle the error in a different way.
        }
    }
}




