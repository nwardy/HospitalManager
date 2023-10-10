package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

	public class HubController {

	    public Stage hubStage;
	    @FXML
	  
	    private TextField FirstIn;
	    @FXML
	    private TextField MiddleIn;
	    @FXML
	    private TextField lastin;
	    @FXML
	    private TextField emailin;
	    @FXML
	    private TextField birthin;
	    @FXML
	    private TextField phonein;
	    @FXML
	    private TextField addressin;
	    @FXML
	    private TextArea intakeNotes;
	    
	    @FXML
	    
	    
	    public void setHubStage(Stage hubStage) {
	        this.hubStage = hubStage;
	    }

	    @FXML
	    public void showNewRecord() throws IOException {
	        System.out.println("showNewRecord clicked"); 
	        switchView("/newRecord.fxml");
	    }

	    @FXML
	    public void showAddInfo() throws IOException {
	        System.out.println("showAddInfo clicked"); 
	        switchView("/AddInfo.fxml");
	    }
	    @FXML
	    public void showQuickView() throws IOException {
	        System.out.println("QV clicked"); 
	        switchView("/QuickView.fxml");
	    }
	    @FXML
	    public void showAppointments() throws IOException {
	        System.out.println("Apps clicked"); 
	        switchView("/Appointments.fxml");
	    }
	  
	        
	    
	    private void switchView(String fxmlPath) throws IOException {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
	        loader.setController(this); 
	        Parent newRoot = loader.load();
	        Scene newScene = new Scene(newRoot, 850, 620);
	        hubStage.setScene(newScene);
	        hubStage.show();
	        String css = this.getClass().getResource("application.css").toExternalForm();
            newScene.getStylesheets().add(css);
	    }
	    
	    @FXML
	    public void logout() throws IOException {
	    	System.out.println("logged out"); 
	        hubStage.close();
	    }
	    
	    @FXML
	    public void addPatient() {
	        String first = FirstIn.getText();
	     
	        String last = lastin.getText();
	     
	        String email = emailin.getText();
	        String phone = phonein.getText();
	        
	       

	        String query = "INSERT INTO Patients (patient_firstName, Patient_lastName, patient_phone, patient_email) VALUES (?, ?, ?, ?)";

	        try (Connection connection = DatabaseUtil.connect();
	             PreparedStatement stmt = connection.prepareStatement(query)) {

	            stmt.setString(1, first);
	            stmt.setString(2, phone);
	            stmt.setString(3, last);
	            stmt.setString(4, email);
	            
	        
	            

	            stmt.executeUpdate();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	}
	    }
	}
