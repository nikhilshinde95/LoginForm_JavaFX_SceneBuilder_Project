package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginSuccessController {
	
	@FXML
	private Label label;

	
	 private Stage loginStage; 

	    // Method to initialize the stage
	    public void init(Stage stage) {
	        this.loginStage = stage;
	    }

	    @FXML
	    private void Logout(ActionEvent event) {
	        // Ask for confirmation before logging out
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Logout Confirmation");
	        alert.setHeaderText("Are you sure you want to logout?");
	        alert.setContentText("Click OK to logout, or Cancel to stay logged in.");

	        Optional<ButtonType> result = alert.showAndWait();
	        if (result.isPresent() && result.get() == ButtonType.OK) {	          
	        	try {
	               Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	               Stage primaryStage = new Stage();
	               Scene scene = new Scene(root);
	                primaryStage.initStyle(StageStyle.UNDECORATED);
	                primaryStage.setScene(scene);
	                primaryStage.show();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	            // Show the login window again
	            loginStage.show();
	        }
	        // If user clicks Cancel, do nothing (stay logged in)
	    }
}
