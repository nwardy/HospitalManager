package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

	public class HubController {

	    public Stage hubStage;
	  
	    
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
	        loader.setController(this); // set this instance as the controller
	        Parent newRoot = loader.load();
	        Scene newScene = new Scene(newRoot, 850, 620);
	        hubStage.setScene(newScene);
	        hubStage.show();
	    }
	    
	    @FXML
	    public void logout() throws IOException {
	    	System.out.println("logged out"); 
	        hubStage.close();
	    }
	}