package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
	
	
	@FXML
	private Label label;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private TextField textUsername;
	
	@FXML
	private TextField textPassword;
	
	@FXML
	public void LoginForm(ActionEvent event) throws Exception {
		
		  if (textUsername.getText().isBlank() || textPassword.getText().isBlank()) {
	            errorLabel.setText("Please enter both username and password.");
	            return;
	        }

	        String username = textUsername.getText();
	        String password = textPassword.getText();

	        //  Check if username and password match
	        if (username.equals("Nikhil Shinde") && password.equals("Nikhil@1234")) {
	            // Open a new window for successful login
	            openSuccessWindow();
	        } else {
	            // Display error message for incorrect credentials
	            errorLabel.setText("Incorrect username or password.");
	        }
	    }

	private void openSuccessWindow() throws IOException {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        Parent parent = FXMLLoader.load(getClass().getResource("LoginSuccess.fxml"));
        Scene scene = new Scene(parent);
        Image icon = new Image("Nikhil.jfif");
        stage.setTitle("Login Successful");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
	   
	@FXML
	    public void cancelButton(ActionEvent event) {
	        // Clear the username and password fields
	        textUsername.clear();
	        textPassword.clear();

	        // Clear any error message
	        errorLabel.setText("");
	  }
}
