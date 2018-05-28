package application.Daten;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.GUI.DrawPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Controller implements Initializable{

	@FXML
	private Button startButton;
	@FXML
	private Pane scoreBoard;
	@FXML
	private DrawPane drawPane;
	
	private Timer timer = new Timer();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void gameStart(ActionEvent e) {
		startButton.setVisible(false);
		drawPane.init();
		drawPane.malen();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				timerRun();
			}
		}, 0, 30);
	}
	
	private void timerRun() {
		
	}
}
