package application.GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DrawPane extends Pane{
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	public void malen() {
        gc.setFill(Color.BLACK);
        gc.fillOval(100, 100, 100, 100);
	}
	
	public void init() {
		canvas = new Canvas(getWidth(), getHeight());
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
	}
}
