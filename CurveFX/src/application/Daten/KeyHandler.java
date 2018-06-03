package application.Daten;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyHandler {
	
	private boolean goLeft = false;
	private boolean goRight = false;
	
	public KeyHandler(Scene scene) {
		
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:  setGoLeft(true); break;
                    case RIGHT: setGoRight(true); break;
				default:
					break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:  setGoLeft(false); break;
                    case RIGHT: setGoRight(false); break;
				default:
					break;
                }
            }
        });
	}

	public boolean isGoLeft() {
		return goLeft;
	}

	public void setGoLeft(boolean goLeft) {
		this.goLeft = goLeft;
	}

	public boolean isGoRight() {
		return goRight;
	}

	public void setGoRight(boolean goRight) {
		this.goRight = goRight;
	}
}
