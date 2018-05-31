package application.GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DrawPane extends Pane{
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	public void kreisMalen(double posX, double posY, double size) {
        gc.setFill(Color.BLACK);
        gc.fillOval(posX, posY, size, size);
	}
	
	public void init() {
		canvas = new Canvas(getWidth(), getHeight());
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
	}
}
