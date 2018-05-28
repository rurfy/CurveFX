package application.GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DrawPane extends Pane{
	
	Canvas canvas;
	GraphicsContext gc;

	public DrawPane() {
		canvas = new Canvas(1000,1000);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillOval(500, 500, 300, 300);
	}
}
