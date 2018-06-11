package application.Daten;

import java.net.URL;
import java.util.ResourceBundle;

import application.GUI.DrawPane;

import javafx.animation.AnimationTimer;
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
	
	private Player player1;
	
	private AnimationTimer timer;
	
	private KeyHandler keyHandler;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void gameStart(ActionEvent e) {
		startButton.setVisible(false);
		drawPane.init();
		objekteErstellen();
		timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				timerRun();
			}
		};
		timer.start();
	}
	
	private void objekteErstellen() {
		keyHandler = new KeyHandler(drawPane.getScene());
		player1 = new Player(keyHandler);
	}
	
	private void timerRun() {
		player1.move();
		drawPane.kreisZeichnen(player1); 
		//drawPane.kreisMalen(player1);
	}
}
