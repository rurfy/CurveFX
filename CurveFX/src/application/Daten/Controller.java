package application.Daten;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Controller implements Initializable{

	@FXML
	Button startButton;
	@FXML
	Pane scoreBoard;
	@FXML
	Pane drawPane;
	
	Timer bew = new Timer();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void gameStart(ActionEvent e) {
		startButton.setVisible(false);
		bew.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, 0, 30);
	}
}
